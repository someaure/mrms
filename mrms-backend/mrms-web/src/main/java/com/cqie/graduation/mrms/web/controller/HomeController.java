package com.cqie.graduation.mrms.web.controller;

import com.cqie.graduation.mrms.user.entity.Menu;
import com.cqie.graduation.mrms.user.service.IMenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xd
 * @date 2020/12/2
 */
@Slf4j
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class HomeController {
    private final IMenuService menuService;

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

    @RequestMapping("/menu")
    public List<Menu> test() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        return menuService.findMenu(set);
    }
}
