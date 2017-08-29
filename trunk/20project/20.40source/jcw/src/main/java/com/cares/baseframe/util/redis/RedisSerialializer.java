package com.cares.baseframe.util.redis;

import java.io.Serializable;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import com.cares.baseframe.util.SerializeUtil;

@Component("redisSerialializer")
public class RedisSerialializer implements RedisSerializer<Serializable> {

	@Override
	public byte[] serialize(Serializable t) {
		return SerializeUtil.serialize(t);
	}

	@Override
	public Serializable deserialize(byte[] bytes) {
		return (Serializable) SerializeUtil.unserialize(bytes);
	}

}
