package com.cares.baseframe.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.cares.baseframe.util.SerializeUtil;


/**
 * Redis工具类
 * @author HuangXiaoDong
 *
 */
@Service("redisCacheUtilService")
public class RedisCacheUtilService {
	@Autowired
	private RedisTemplate<Serializable, Serializable> redisTemplate;

	public Double[] getHitRadio(final String namesPace) {
		return (Double[]) redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Double[] doInRedis(RedisConnection connection) throws DataAccessException {
				connection.openPipeline();
				List<Object> list = connection.closePipeline();
				return new Double[] { (Double) list.get(0), (Double) list.get(1) };
			}
		});
	}

	private void changeStatisInfo(final String nameSpace, final boolean isNull) {
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {

				if (isNull)
					connection.zIncrBy("nameSpaceReqTotal".getBytes(), 1, nameSpace.getBytes());
				else {
					connection.openPipeline();
					connection.zIncrBy("nameSpaceReqTotal".getBytes(), 1, nameSpace.getBytes());
					connection.zIncrBy("nameSpaceReqTotal".getBytes(), 1, (nameSpace + "mzTotal").getBytes());
					connection.closePipeline();
				}
				return null;
			}

		});
	}

	public void expire(String nameSpace, Object key, int expireation) {
		byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));
		redisTemplate.expire(bytes, expireation, TimeUnit.SECONDS);
	}

	public void del(String nameSpace, Object key) {

		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.del(bytes);

				return null;
			}

		});
	}

	public void set(String nameSpace, Object key, final Object value) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));

		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.set(bytes, SerializeUtil.serialize(value));

				return null;
			}

		});
	}

	public void set(String nameSpace, Object key, final Object value, final int expiration) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.set(bytes, SerializeUtil.serialize(value));
				if (expiration > 0)
					connection.expire(bytes, expiration);
				return null;
			}

		});
	}

	public Object get(String nameSpace, Object key) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));
		byte[] result = redisTemplate.execute(new RedisCallback<byte[]>() {
			@Override
			public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.get(bytes);
			}
		});

		this.changeStatisInfo(nameSpace, result == null ? true : false);
		if (result != null)
			return SerializeUtil.unserialize(result);

		return null;

	}

	public String flushDB() {
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.flushDb();
				return null;
			}

		});

		return "";
	}

	public RedisTemplate<Serializable, Serializable> getTemplate() {
		return redisTemplate;
	}

	public void setTemplate(RedisTemplate<Serializable, Serializable> template) {
		this.redisTemplate = template;
	}

	/**
	 * 列表的长度
	 * 
	 * @param nameSpace
	 * @param key
	 * @return
	 */
	public Long listSize(String nameSpace, Object key) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.lLen(bytes);
			}
		});
	}

	/**
	 * 删除并取得LIST头部一个元素
	 * 
	 * @param nameSpace
	 * @param key
	 * @return
	 */
	public Object popLlist(String nameSpace, Object key) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));
		byte[] result = redisTemplate.execute(new RedisCallback<byte[]>() {
			@Override
			public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.lPop(bytes);
			}
		});

		if (result != null)
			return SerializeUtil.unserialize(result);

		return null;
	}

	/**
	 * 在LIST头部扩展一个元素
	 * 
	 * @param nameSpace
	 * @param key
	 * @param value
	 * @param expireation
	 */
	public void setLpushList(String nameSpace, Object key, final Object value) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.lPush(bytes, SerializeUtil.serialize(value));

				return null;
			}

		});
	}

	/**
	 * 在LIST尾部扩展一个元素
	 * 
	 * @param nameSpace
	 * @param key
	 * @param value
	 * @param expireation
	 */
	public void setRpushList(String nameSpace, Object key, final Object value) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.rPush(bytes, SerializeUtil.serialize(value));

				return null;
			}

		});
	}

	/**
	 * 取得LIST在指定范围内的元素
	 * 
	 * @param nameSpace
	 * @param key
	 * @param start
	 * @param stop
	 * @return
	 */
	public List<Object> getListRang(String nameSpace, Object key, final int start, final int stop) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));
		List<byte[]> list = redisTemplate.execute(new RedisCallback<List<byte[]>>() {
			@Override
			public List<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.lRange(SerializeUtil.serialize(bytes), start, stop);
			}

		});

		List<Object> result = new ArrayList<Object>();
		for (byte[] obj : list) {
			result.add(SerializeUtil.unserialize(obj));
		}
		return result;
	}

	public void addGroup(final Long KEY, final Long grp) {
		redisTemplate.execute(new RedisCallback<List<byte[]>>() {
			@Override
			public List<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {

				connection.zAdd(KEY.toString().getBytes(), 1, grp.toString().getBytes());

				return null;
			}

		});
	}

	public void delGroup(final Long key, final Long grp) {
		redisTemplate.execute(new RedisCallback<List<byte[]>>() {
			@Override
			public List<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {

				connection.zRem(key.toString().getBytes(), grp.toString().getBytes());

				return null;
			}

		});
	}

	public Set<byte[]> getGroup(final Long key) {
		return redisTemplate.execute(new RedisCallback<Set<byte[]>>() {
			@Override
			public Set<byte[]> doInRedis(RedisConnection conn) throws DataAccessException {
				Set<byte[]> sets = conn.zRange(key.toString().getBytes(), 0L, -1L);
				return sets;
			}
		});
	}
	//Set添加元素
	public void setAddValue(String nameSpace, Object key, String value) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));
		final byte[] valueB = SerializeUtil.serialize(value);
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection conn) throws DataAccessException {
				conn.sAdd(bytes, valueB);
				
				return null;
			}
		});
	}
	//Set添加元素 过期时间
	public void setAddValue(String nameSpace, Object key, String value, final long expiration) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));
		final byte[] valueB = SerializeUtil.serialize(value);
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection conn) throws DataAccessException {
				conn.sAdd(bytes, valueB);
				if (expiration > 0)
					conn.expire(bytes, expiration);
				return null;
			}
		});
	}
	//Set删除元素
	public void setDeleteValue(String nameSpace, Object key, String value) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));
		final byte[] valueB = SerializeUtil.serialize(value);
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection conn) throws DataAccessException {
				conn.sRem(bytes, valueB);
				
				return null;
			}
		});
	}
	//Set获取元素
	public Set<byte[]> setGetValue(String nameSpace, Object key) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));
		return redisTemplate.execute(new RedisCallback<Set<byte[]>>() {
			@Override
			public Set<byte[]> doInRedis(RedisConnection conn) throws DataAccessException {
							
				return conn.sMembers(bytes);
			}
		});
	}
	//Set删除KEY
	public void setDeleteKey(String nameSpace, Object key) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection conn) throws DataAccessException {
				conn.sRem(bytes);				
				return null;
			}
		});
	}
	//Map删除key
	public void mapDeleteKey(String nameSpace, Object key, Object otherKey) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));
		final byte[] otherB = SerializeUtil.serialize(otherKey);
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection conn) throws DataAccessException {
				conn.hDel(bytes, otherB);	
				return null;
			}
		});
	}	
	//Map增加value
	public void mapAddValue(String nameSpace, Object key, final Map<byte[], byte[]> value) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));

		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection conn) throws DataAccessException {
				conn.hMSet(bytes, value);	
				return null;
			}
		});
	}	
	//Map增加value  过期时间expiration
	public void mapAddValue(String nameSpace, Object key, final Map<byte[], byte[]> value, final long expiration) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));

		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection conn) throws DataAccessException {
				conn.hMSet(bytes, value);	
				if (expiration > 0)
					conn.expire(bytes, expiration);
				return null;
			}
		});
	}	
	//Map获取value
	public List<byte[]> mapGetValue(String nameSpace, Object key, Object keyOther) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));
		final byte[] otherB = SerializeUtil.serialize(keyOther);
		return redisTemplate.execute(new RedisCallback<List<byte[]>>() {
			@Override
			public List<byte[]> doInRedis(RedisConnection conn) throws DataAccessException {
				return conn.hMGet(bytes, otherB);
			}
		});
	}	
	
	//Map获取key的所有value
	public Map<byte[], byte[]> mapGetValue(String nameSpace, Object key) {
		final byte[] bytes = SerializeUtil.mergeBytes(nameSpace.getBytes(), SerializeUtil.serialize(key));
		
		return redisTemplate.execute(new RedisCallback<Map<byte[], byte[]>>() {
			@Override
			public Map<byte[], byte[]> doInRedis(RedisConnection conn) throws DataAccessException {
				return conn.hGetAll(bytes);
			}
		});
	}	
	
	public void hset(String nameSpace, String key, Serializable hashKey,
			Serializable value) {
		redisTemplate.opsForHash().put(generateKey(nameSpace, key), hashKey,
				value);
	};

	public Serializable hget(String nameSpace, String key, Serializable hashKey) {
		return (Serializable) redisTemplate.opsForHash().get(
				generateKey(nameSpace, key), hashKey);
	};

	public void del(String nameSpace, String key) {
		redisTemplate.delete(generateKey(nameSpace, key));
	}
	//生成key
	private String generateKey(String nameSpace, String key) {
		return new StringBuilder().append(nameSpace).append("_").append(key)
				.toString();
	}
	

}
