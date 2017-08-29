package com.cares.baseframe.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化工具
 * @author HuangXiaoDong
 *
 */
public class SerializeUtil {

	/**
	 * 字节合并
	 * @param data1
	 * @param data2
	 * @return
	 */
	public static byte[] mergeBytes(byte[] data1, byte[] data2) {
		byte[] result = new byte[data1.length + data2.length];
		System.arraycopy(data1, 0, result, 0, data1.length);
		System.arraycopy(data2, 0, result, data1.length, data2.length);
		return result;
	}

	/**
	 * 序列化
	 * @param object
	 * @return
	 */
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			oos.flush();
			baos.flush();
			return bytes;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}finally{
			try {
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 反序列化
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			Object obj = ois.readObject();
			return obj;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}finally{
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bais.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
