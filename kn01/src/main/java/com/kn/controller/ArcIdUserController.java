package com.kn.controller;

import com.kn.bean.Act_id_user;
import com.kn.service.ActIdUserService;
import com.kn.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * 用户控制层
 */


@Controller
@RequestMapping(value = "/user")
public class ArcIdUserController {

    //自动注入service层
    @Autowired
    private ActIdUserService actIdUserService;

    //前往登录页面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    //前往登录页面 测试使用
    /*@RequestMapping("/toLogin1")
    public String toLogin1(){
        return "html/404/login1";
    }*/

    /*
        生成验证码
     */
    @RequestMapping(value = "/authImage")
    public void getAuthImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        String username = request.getParameter("username");
        if (username == null) {
            username = "aaa";
        }
        //System.out.println(username);//aaa
        //生成随机字串VerifyCodeUtils
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话session
        HttpSession session = request.getSession();
        //删除以前的
        session.removeAttribute("verCode");
        //登录验证码
        session.setAttribute("verCode", verifyCode.toLowerCase());
        //生成图片
        int w = 100, h = 30;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }

    /*
        用户登录
     */
    @RequestMapping(value = "/login")
    public String userLogin(HttpServletRequest request, HttpServletResponse response, Map<String , Object> map) throws ServletException, IOException {
        //1、获取页面传来的参数  获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + ";  password: " + password);
        map.put("UserLoginAlertInfo", null);
        //2、判断用户名和密码是否正确
        Act_id_user user = actIdUserService.queryAct_id_userByUsernameAndPassword(username, password);
        HttpSession session = request.getSession();
        if (user == null) {
            //登陆失败,没有这个人
            map.put("UserLoginAlertInfo","用户名或密码错误,请从新输入");
//            session.setAttribute("UserLoginAlertInfo", "用户名或密码错误,请从新输入");
//            request.getRequestDispatcher("/html/login.html").forward(request, response);
            return "login";
        } else {
            //获取验证码
            String identifyingcode = request.getParameter("identifyingcode");
            //3、判断验证码是否正确(获取验证码的时候保存的验证码信息)
            String verCode = (String) session.getAttribute("verCode");
            if (verCode.equals(identifyingcode.toLowerCase())) {
                //验证码正确(登陆成功:1、存储用户登陆信息,2、进入到主页)
                session.setAttribute("LOGIN_USERINFO", user);
//                request.getRequestDispatcher("/index.html").forward(request, response);
                return "index";
            } else {
                //验证码错误(返回登陆页面并给出对应提示)
                map.put("UserLoginAlertInfo","验证码错误,请从新输入");
//                session.setAttribute("UserLoginAlertInfo", "验证码错误,请从新输入");
//                request.getRequestDispatcher("/html/login.html").forward(request, response);
                return "login";
            }
        }
    }

    /*
    * 进入个人信息页面
    */
    @RequestMapping("/userInfo")
    public String toUserInfo(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map){
        Act_id_user user = (Act_id_user) request.getSession().getAttribute("LOGIN_USERINFO");
        map.put("USER_INFO", user);
        return "userInfo";
    }

    /*
    * 退出登陆
    */
    @RequestMapping(value = "/loginOut")
    public String loginOut(HttpServletRequest request){
        //清除掉登陆的session的值
        request.getSession().removeAttribute("LOGIN_USERINFO");
        return "login";
    }

}
