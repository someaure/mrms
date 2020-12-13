package com.cqie.graduation.mrms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xd
 * @date 2020/12/2
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
