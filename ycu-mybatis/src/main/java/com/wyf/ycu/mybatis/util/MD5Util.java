package com.wyf.ycu.mybatis.util;


import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    public static final String salt = "9d5b364d";

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    /** 第一次加密 */
    public static String inputPassToFromPass(String inputPass) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass
                + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    /** 第二次加密 */
    public static String  fromPasstoDBPass(String fromPass, String  salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + fromPass
                + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDbPass(String inputPass, String slatDB) {
        String fromPass = inputPassToFromPass(inputPass); // 第一次加密
        String dbPass = fromPasstoDBPass(fromPass, slatDB);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(md5("123456"));
        // e10adc3949ba59abbe56e057f20f883e
        System.out.println(inputPassToFromPass("123456"));
        // 3457ceaeba3426466887369f1a1f7a88
        System.out.println(inputPassToDbPass("123456", salt));
        // ae2fe40a6242ef07a35a30da2232e10a
    }
}

