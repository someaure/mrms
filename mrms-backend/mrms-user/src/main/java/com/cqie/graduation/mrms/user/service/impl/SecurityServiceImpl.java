package com.cqie.graduation.mrms.user.service.impl;

import com.cqie.graduation.mrms.user.service.ISecurityService;
import com.cqie.graduation.mrms.user.util.util.RandomValidateCodeUtil;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

/**
 * @author xd
 * @date 2020/12/12
 */
@Slf4j
@Service
public class SecurityServiceImpl implements ISecurityService {
    @Override
    public Pair<String, BufferedImage> generateVerifyCode() {

        return RandomValidateCodeUtil.generateVerifyCode();
    }
}
