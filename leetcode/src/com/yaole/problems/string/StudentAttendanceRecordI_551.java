package com.yaole.problems.string;

public class StudentAttendanceRecordI_551 {
    public static boolean checkRecord(String s) {
        if (s.length() == 1) return true;
        char[] cArr = s.toCharArray();
        int ANum = 0;
        int LNum = 0;
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == 'L') LNum++;
            else {
                if (cArr[i] == 'A') ANum++;
                LNum = 0;
            }
            if (ANum > 1) return false;
            if (LNum > 2) return false;
        }
        return true;
    }
}
