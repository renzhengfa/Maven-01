
package com.kn.utils.interceptor;

/*
 * 登录拦截器
 * 要只用的话还得注册在容器当中
 */

import com.kn.bean.Act_id_user;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {


    /*
     * 登陆拦截（进入controller层之前执行方法）
     * 应用场景: 身份认证,身份授权
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1、获取请求路径
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        System.out.println("preHandle");
        //2、判断请求是否为登陆页面及静态资源
        if (requestURI.contains("login.html") || requestURI.contains(".js") || requestURI.contains(".css") || requestURI.contains(".jpg") || requestURI.contains("favicon.ico")
                || requestURI.contains(".png") || requestURI.contains(".gif") || requestURI.contains(".txt") || requestURI.contains(".eot") || requestURI.contains(".svg")
                || requestURI.contains(".ttf") || requestURI.contains(".woff") || requestURI.contains("authImage")
                || requestURI.contains("login") || requestURI.contains("toLogin")) {
//            session.removeAttribute("UserLoginAlertInfo");
            //是登陆页面
            return true;
        } else {
            //3、拦截用户是否登录
            HttpSession session = request.getSession();
            Act_id_user login_userinfo = (Act_id_user) session.getAttribute("LOGIN_USERINFO");
            if (login_userinfo == null) {
                //用户没有登录,返回到登录页面进行登录操作
//                request.getRequestDispatcher("/login.html").forward(request, response);
                return true;
            } else {
//                session.removeAttribute("UserLoginAlertInfo");
                //用户已经登录
                return true;
            }
        }
    }

    /*
     *  登陆拦截 该方法在进入Handler方法之后,返回ModelAndView之前执行
     *  应用场景从modelAndView出发,将公用模型数据（如菜单导航）在这里传到视图,也可以在这里统一制定视图
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    /*
     *  该方法在handler方法执行完之后执行
     *  应用场景: 统一日志处理,统一异常处理
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }

}

