package com.cqie.graduation.mrms.web.start;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.*;
import java.util.List;

/**
 * @author xd
 * @date 2020/12/13
 */
@Slf4j
@Component
public class AppStart implements ApplicationRunner {
    @Value("${server.port}")
    private String port;

    @Override
    public void run(ApplicationArguments args) {
        InetAddress inetAddress = null;
        try {
            NetworkInterface n = NetworkInterface.getByName("eth1");
            List<InterfaceAddress> list = n.getInterfaceAddresses();
            for (InterfaceAddress address : list) {
                if (address.getAddress() instanceof Inet4Address) {
                    inetAddress = address.getAddress();
                    break;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        if (inetAddress != null) {
            log.info("主机地址:http://{}:{}", inetAddress.getHostAddress(), port);
        }
    }

    public static void main(String[] args) throws SocketException, UnknownHostException {
        /*NetworkInterface n = NetworkInterface.getByName("eth1");
        List<InterfaceAddress> list = n.getInterfaceAddresses();
        InetAddress inetAddress = null;
        for (InterfaceAddress address : list) {
            if (address.getAddress() instanceof Inet4Address) {
                inetAddress = address.getAddress();
                break;
            }
        }
        if (inetAddress != null) {
            log.info(inetAddress.getHostAddress());
        }*/
    }
}
