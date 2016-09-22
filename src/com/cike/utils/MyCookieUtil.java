package com.cike.utils;

import javax.servlet.http.Cookie;

/**
 * cookie工具类
 * 
 * @author CIKE
 *
 */
public class MyCookieUtil {
	/**
	 * 通过指定名称查找指定cookie
	 * 
	 * @param cookies
	 * @param name
	 * @return
	 */
	public static Cookie getCookieByName(Cookie[] cookies, String name) {
		if (cookies == null) {
			return null;
		} else {
			// 循环遍历，和name进行匹配，如果匹配成功，返回当前cookie
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}
		return null;
	}
}
