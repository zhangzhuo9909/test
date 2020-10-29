package org.zhangzhuo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.zhangzhuo.entity.Member;
import org.zhangzhuo.service.MemberService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor implements HandlerInterceptor {
    @Autowired
    private MemberService memberService;
    @Value("${LOGIN_URL}")
    private String LOGIN_URL;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Cookie[] cookies = request.getCookies();
        System.out.println(cookies);
        String token = "";
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                token = cookie.getValue();
            }
        }
        System.out.println(token);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);
        if(StringUtils.isEmpty(token)){
            response.sendRedirect(LOGIN_URL+"?returnUrl="+requestURL);
            return false;
        }else {
            Member member = memberService.getMemberInfo(token);
            if(member == null) {
                response.sendRedirect(LOGIN_URL = "?returnUrl=" + requestURL);
                return false;
            }else {
                request.setAttribute("member",member);
                return true;
            }
        }
    }
}
