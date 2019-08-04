package chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression {
    public static void main(String[] args) {
        String s = "Java now has regular expressions";
        Pattern pattern = Pattern.compile("s+");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            System.out.println(matcher.lookingAt());
        }
        // System.out.println(Pattern.matches("^[a-z]+$", "dsafds"));
    }
}
