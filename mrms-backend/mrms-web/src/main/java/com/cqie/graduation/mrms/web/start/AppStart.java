package com.cqie.graduation.mrms.web.start;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xd
 * @date 2020/12/13
 */
@Slf4j
@Component
public class AppStart implements ApplicationRunner {
    private final static String WLAN = "wlan0";
    private final static String WIRELESS_NETWORK_ADAPTER = "eth1";
    private static Set<String> netName = new HashSet<>();

    @Value("${server.port}")
    private String port;

    @Override
    public void run(ApplicationArguments args) {
        netName.add(WLAN);
        netName.add(WIRELESS_NETWORK_ADAPTER);

        InetAddress inetAddress = null;
        try {

            NetworkInterface n = null;
            for (String s : netName) {
                NetworkInterface networkInterface = NetworkInterface.getByName(s);
                if (networkInterface.getInetAddresses().hasMoreElements()) {
                    n = networkInterface;
                    break;
                }
            }
            if (n != null) {
                List<InterfaceAddress> list = n.getInterfaceAddresses();
                for (InterfaceAddress address : list) {
                    if (address.getAddress() instanceof Inet4Address) {
                        inetAddress = address.getAddress();
                        break;
                    }
                }
            } else {
                log.info("未找对应ipv4地址");
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        if (inetAddress != null) {
            log.info("主机地址:http://{}:{}", inetAddress.getHostAddress(), port);
        }
    }
}
