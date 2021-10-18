package org.ci6206.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class MD5Util {
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
        final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();
        StringBuilder res = new StringBuilder(bytes.length << 1);
        for (int i = 0; i < bytes.length; ++i) {
            res.append(HEX_DIGITS[(bytes[i]>>4) & 0xf]);
            res.append(HEX_DIGITS[bytes[i] & 0xf]);
        }
        return res.toString();
    }
}
