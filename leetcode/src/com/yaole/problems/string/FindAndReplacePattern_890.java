package com.yaole.problems.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindAndReplacePattern_890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> resultList = new LinkedList<>();
        char[] patternChars = pattern.toCharArray();
        loop:
        for (String word : words) {
            HashMap<Character, Character> map = new HashMap<>();
            int i = 0, j = 0;
            char[] wordChars = word.toCharArray();
            while (i < word.length()) {
                if (!map.containsKey(patternChars[i])) {
                    if (!map.containsValue(wordChars[j])) {
                        map.put(patternChars[i++], wordChars[j++]);
                    } else {
                        continue loop;
                    }

                } else {
                    if (map.get(patternChars[i]).equals(wordChars[j])) {
                        map.put(patternChars[i++], wordChars[j++]);
                    } else {
                        continue loop;
                    }
                }
            }
            resultList.add(word);
        }
        return resultList;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        FindAndReplacePattern_890 f = new FindAndReplacePattern_890();
        System.out.println(f.findAndReplacePattern(words, pattern));
    }
}
