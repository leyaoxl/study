package com.yaole.problems.string;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords_804 {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] all = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> resultSet = new HashSet<>();
        for (String s : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : s.toCharArray()) {
                stringBuilder.append(all[c - 'a']);
            }
            resultSet.add(stringBuilder.toString());
        }
        return resultSet.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }
}
