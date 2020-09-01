package org.lanqiao.utils;

import javax.servlet.http.Cookie;

public class CookieUtil {
	
	public static Cookie getCookie(Cookie[] cookies , String cookiename) {
		//遍历cookie获取名称为cookie的cookie
		Cookie co = null;
		for (Cookie cookie : cookies) {
			//获取cookie的名称
			String cookieName = cookie.getName();
			if(cookiename.equals(cookieName)) {
				//获取该cookie
				co = cookie;
			}
		}
		return co;
	}
	
}
