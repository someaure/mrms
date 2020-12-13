package com.cqie.graduation.mrms.user.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author xd
 */
public class PasswordHelper {
    private static final String ALGORITHM_NAME = "md5";
    private static final int HASH_ITERATIONS = 2;
    private static final String SALT = "xd";

    public static String encryptPassword(String password) {
        return new SimpleHash(
                ALGORITHM_NAME,
                password, SALT,
                HASH_ITERATIONS).toHex();
    }
}
