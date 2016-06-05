package com.projectbolek.util;

import lombok.experimental.UtilityClass;
import org.springframework.util.DigestUtils;

/**
 * Created by rogalsp1 on 05.06.16.
 */
@UtilityClass
public class BolekUtils {

    public static String hashPassword(String password) {
        byte[] passwordBytes = password.getBytes();
        return DigestUtils.md5DigestAsHex(passwordBytes);
    }
}
