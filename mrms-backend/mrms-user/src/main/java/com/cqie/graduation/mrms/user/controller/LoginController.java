package com.cqie.graduation.mrms.user.controller;

import com.cqie.graduation.mrms.base.bean.Response;
import com.cqie.graduation.mrms.base.util.CommonStatic;
import com.cqie.graduation.mrms.user.service.ISecurityService;
import com.cqie.graduation.mrms.user.service.IUserService;
import javafx.util.Pair;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author xd
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final IUserService userService;
    private final ISecurityService securityService;
    private final RedisTemplate<Object, Object> redisTemplate;


    @PostMapping("/login")
    @ResponseBody
    public Response login(Integer userId, String password, String verifyCode, HttpServletRequest
            request) {
        String redisVerifyCode = (String) redisTemplate.opsForValue().get(CommonStatic.CAPTCHA + request.getRemoteAddr());
        if (StringUtils.isAnyBlank(redisVerifyCode, verifyCode) || Objects.equals(redisVerifyCode, verifyCode)) {
            return new Response().error("验证码过期或输入错误");
        }
        if (userId == null) {
            return new Response().error("密码不能为空");
        }

        if (StringUtils.isBlank(password)) {
            return new Response().error("密码不能为空");
        }
        boolean legal = userService.checkPassword(userId, password);

        if (legal) {
            String token = userService.login(userId, password);
            return new Response().ok().data(token);
        } else {
            return new Response().error("账号或密码错误");
        }
    }

    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    @RequestMapping(value = "/captcha", method = RequestMethod.GET)
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        Pair<String, BufferedImage> verifyCode = securityService.generateVerifyCode();
        try {
            response.setHeader("Cache-Control", "no-store, no-cache");
            response.setContentType("image/jpeg");
            ImageIO.write(verifyCode.getValue(), "JPG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        redisTemplate.opsForValue().set(CommonStatic.CAPTCHA + request.getRemoteAddr(), verifyCode.getKey(), 1,
                TimeUnit.HOURS);
    }

}
