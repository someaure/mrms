package com.cqie.graduation.mrms.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xd
 * @date 2020/12/2
 */
@Controller
@Slf4j
@RequestMapping("/views/")
public class HomeController {

    public static void main(String[] args) throws InvalidKeyException, IOException {
        List<Byte[]> bytes = new ArrayList<>();
        while (true) {
            bytes.add(new Byte[1024]);
        }
    }

    @RequestMapping(value = "/home/console", method = RequestMethod.GET)
    public String homeConsole() {
        return "/home/console";
    }
}
