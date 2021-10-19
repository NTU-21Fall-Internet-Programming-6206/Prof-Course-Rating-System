package org.ci6206.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class MD5Util {
    private final static String HEX_DIGITS = "0123456789abcdef";
    
    public static String getMD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes(StandardCharsets.UTF_8));
            return hashToHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getSalt() {
        UUID uuid = UUID.randomUUID();
        String[] arr = uuid.toString().split("-");
        return arr[0];
    }

    private static String hashToHex(byte[] bytes) {
        StringBuilder res = new StringBuilder(bytes.length << 1);
        for (byte b : bytes) {
            res.append(HEX_DIGITS.charAt((b >> 4) & 0xf));
            res.append(HEX_DIGITS.charAt(b & 0xf));
        }
        return res.toString();
    }
}
