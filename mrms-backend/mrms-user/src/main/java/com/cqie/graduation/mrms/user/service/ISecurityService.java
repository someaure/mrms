package com.cqie.graduation.mrms.user.service;

import javafx.util.Pair;

import java.awt.image.BufferedImage;

/**
 * @author xd
 * @date 2020/12/12
 */
public interface ISecurityService {

    /**
     * 生成验证码 及对应图片buffer
     *
     * @return 验证码
     */
    Pair<String, BufferedImage> generateVerifyCode();
}
