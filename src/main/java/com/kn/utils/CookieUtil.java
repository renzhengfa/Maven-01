package com.kn.utils;

import javax.servlet.http.Cookie;

public class CookieUtil {

    public static Cookie getCookie(Cookie[] cookies, String cookiename) {
        //����cookie��ȡ����Ϊcookie��cookie
        Cookie co = null;
        for (Cookie cookie : cookies) {
            //��ȡcookie������
            String cookieName = cookie.getName();
            if (cookiename.equals(cookieName)) {
                //��ȡ��cookie
                co = cookie;
            }
        }
        return co;
    }

}
