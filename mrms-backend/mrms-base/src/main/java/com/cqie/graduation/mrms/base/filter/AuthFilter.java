package com.cqie.graduation.mrms.base.filter;

import com.alibaba.fastjson.JSONObject;
import com.cqie.graduation.mrms.base.bean.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.BearerToken;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author xd
 * @date 2020/12/7
 */
@Slf4j
public class AuthFilter extends BasicHttpAuthenticationFilter {

    private static final String TOKEN_NAME = "token";

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //判断请求的请求头是否带上 "Token"
        if (((HttpServletRequest) request).getHeader(TOKEN_NAME) != null) {
            //如果存在，则进入 executeLogin 方法执行登入，检查 token 是否正确
            return executeLogin(request, response);
        }
        //如果请求头不存在 Token，则可能是执行登陆操作或者是游客状态访问，无需检查 token，直接返回 true
        return true;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(TOKEN_NAME);
        BearerToken bearerToken = new BearerToken(token);
        try {
            SecurityUtils.getSubject().login(bearerToken);
        } catch (AuthenticationException authenticationException) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            try {
                response.getWriter().println(JSONObject.toJSON(new Response().error(authenticationException)));
            } catch (IOException e) {
                log.error(e.getMessage(), e.getCause());
            }
            return false;
        }
        return true;
    }
}
