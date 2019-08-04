package com.wsn.conference.submission.util;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES对称加解密算法
 *
 * @author leyao
 * @version 2018-7-12
 */
@Component
public class AESUtil {
    private final String KEY_AES = "AES";
    private final String KEY = "ibt691lnT95Pl81O";

    public String encrypt(String src) throws Exception {
        if (KEY == null || KEY.length() == 0) {
            throw new RuntimeException("密钥格式不符合要求！");
        }
        byte[] raw = KEY.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw, KEY_AES);
        Cipher cipher = Cipher.getInstance(KEY_AES);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encrypted = cipher.doFinal(src.getBytes());
        return byte2hex(encrypted);
    }

    public String decrypt(String src) throws Exception {
        if (KEY == null || KEY.length() != 16) {
            throw new RuntimeException("密钥格式不符合要求！");
        }
        byte[] raw = KEY.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw, KEY_AES);
        Cipher cipher = Cipher.getInstance(KEY_AES);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] encrypted1 = hex2byte(src);
        byte[] original = cipher.doFinal(encrypted1);
        return new String(original);
    }

    private String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (byte by : b) {
            stmp = Integer.toHexString(by & 0xff);
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            }
            else hs = hs + stmp;
        }
        return hs.toUpperCase();
    }

    private byte[] hex2byte(String strhex) {
        if (strhex == null) {
            return null;
        }
        int length = strhex.length();
        if (length % 2 == 1) {
            return null;
        }
        byte[] b = new byte[length / 2];
        for (int i = 0; i < length / 2; i++) {
            b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2), 16);
        }
        return b;
    }
}
