package org.ci6206.util;

import java.util.UUID;

public class TokenUtil {
    public static String getToken() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }
}
