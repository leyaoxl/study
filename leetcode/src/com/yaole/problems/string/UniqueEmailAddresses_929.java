package com.yaole.problems.string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses_929 {
    public static int numUniqueEmails(String[] emails) {
        Set<String> resultSet = new HashSet<>();
        for (String s : emails) {
            int n = s.indexOf("@");
            String preStr = s.substring(0, n);
            String sufStr = s.substring(n + 1, s.length());
            if (preStr.contains("+")) preStr = preStr.substring(0, preStr.indexOf("+"));
            preStr = preStr.replaceAll("\\.", "");
            String resultStr = preStr + sufStr;
            resultSet.add(resultStr);
        }
        return resultSet.size();
    }

    public static void main(String[] args) {
        String[] emails =
                {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }
}
