package com.cares.baseframe.util;

import java.util.UUID;

public class TokenUtil {
	// 生成唯一的
	public static String generateTokenCode() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
