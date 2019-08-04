package com.wsn.conference.Util;

public class RandomUtil {
    /**
     * 产生随机6位数
     */
    public static String randomCode() {
        Integer res = (int)(Math.random()*1000000);
        return res+"";
    }
}
