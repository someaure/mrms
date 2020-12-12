package com.cqie.graduation.mrms.user.controller;

import com.cqie.graduation.mrms.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xd
 * @date 2020/11/20
 */
@RestController
@RequiredArgsConstructor
public class TestController {
    private final RoomService roomService;

    @RequestMapping("/test")
    public Object test() {
        return SecurityUtils.getSubject().getPrincipal();
    }
}
