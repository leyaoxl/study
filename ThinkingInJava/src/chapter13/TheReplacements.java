package chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheReplacements {
    public static void main(String[] args) {
        String s = "This, unusual use, unuwfwsdfw exclamation!!points";
        Pattern p = Pattern.compile("u\\w+");
        Matcher m = p.matcher(s);
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (m.find()) {
            i++;
            if (i == 3) {
                break;
            }
            m.appendReplacement(stringBuffer, "yaole");
        }
        m.appendTail(stringBuffer);
        System.out.println(stringBuffer);
    }
}
