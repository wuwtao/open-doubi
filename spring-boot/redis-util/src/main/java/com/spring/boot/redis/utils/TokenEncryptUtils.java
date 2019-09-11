package com.spring.boot.redis.utils;

/**
 * @author:伍梓涛
 * @version:1.0.0
 * @Modified By:SimpleWu
 * @CopyRright (c)2019-:YUM架构平台
 */

import java.util.UUID;

/**
 * token编码工具类
 * @author ouyangjun
 */
public class TokenEncryptUtils {

    public static void main(String[] args) {
        System.out.println(encoded("{user:SimpleWu,pass:,}"));
        System.out.println(decoded("3f6c3175302b417e2b32287143603e34233532786a38"));
    }

    // 编码密码,可自定义
    private static final String ENCODED_PASSWORD = "d9b0b127fbd4452dbfabfe0db75876de";

    /**
     * 编码
     * @param str
     * @return
     */
    public static String encoded(String str) {
        return strToHex(encodedString(str, ENCODED_PASSWORD));
    }

    /**
     * 转换
     * @param str
     * @param password
     * @return
     */
    private static String encodedString(String str, String password) {
        char[] pwd = password.toCharArray();
        int pwdLen = pwd.length;

        char[] strArray = str.toCharArray();
        for (int i=0; i<strArray.length; i++) {
            strArray[i] = (char)(strArray[i] ^ pwd[i%pwdLen] ^ pwdLen);
        }
        return new String(strArray);
    }

    private static String strToHex(String s) {
        return bytesToHexStr(s.getBytes());
    }

    private static String bytesToHexStr(byte[] bytesArray) {
        StringBuilder builder = new StringBuilder();
        String hexStr;
        for (byte bt : bytesArray) {
            hexStr = Integer.toHexString(bt & 0xFF);
            if (hexStr.length() == 1) {
                builder.append("0");
                builder.append(hexStr);
            }else{
                builder.append(hexStr);
            }
        }
        return builder.toString();
    }

    /**
     * 解码
     * @param str
     * @return
     */
    public static String decoded(String str) {
        String hexStr = null;
        try {
            hexStr = hexStrToStr(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (hexStr != null) {
            hexStr = encodedString(hexStr, ENCODED_PASSWORD);
        }
        return hexStr;
    }

    private static String hexStrToStr(String hexStr) {
        return new String(hexStrToBytes(hexStr));
    }

    private static byte[] hexStrToBytes(String hexStr) {
        String hex;
        int val;
        byte[] btHexStr = new byte[hexStr.length()/2];
        for (int i=0; i<btHexStr.length; i++) {
            hex = hexStr.substring(2*i, 2*i+2);
            val = Integer.valueOf(hex, 16);
            btHexStr[i] = (byte) val;
        }
        return btHexStr;
    }

}