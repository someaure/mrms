package com.cqie.graduation.mrms.user.util;

import com.cqie.graduation.mrms.user.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

public class PasswordHelper {
    private static final String algorithmName = "md5";
    private static final int hashIterations = 2;
    private static final String salt = "salt";
    private final RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    public static void encryptPassword(User user) {
        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                hashIterations).toHex();
        user.setPassword(newPassword);
    }
}
