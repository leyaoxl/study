package chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Resetting {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[frb][aiu][gx]");
        Matcher m = p.matcher("fix the rug with bags");
        int i = 0;
        while (m.find()) {
            i++;
            if (i == 2) {
                m.reset();
                continue;
            }
            System.out.print(m.group() + " ");
        }
        // System.out.println();
        // m.reset("fix the rig with rags");
        // while (m.find()) System.out.print(m.group() + " ");
    }
}
