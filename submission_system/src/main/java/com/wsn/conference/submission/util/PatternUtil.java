package com.wsn.conference.submission.util;

import com.wsn.conference.submission.entity.enums.PatternEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtil {
    /**
     * 用户名合法性匹配
     * @param s
     * @return
     */
    public static boolean pattern(String item, String s) {
        String patternStr;
        switch (item) {
            case "ACCOUNT":
                patternStr = PatternEnum.ACCOUNT_PATTERN.getValue();
                break;
            case "PASSWORD":
                patternStr = PatternEnum.PASSWORD_PATTERN.getValue();
                break;
            case "EMAIL":
                patternStr = PatternEnum.EMAIL_PATTERN.getValue();
                break;
            default:
                patternStr = "";
        }
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }
}
