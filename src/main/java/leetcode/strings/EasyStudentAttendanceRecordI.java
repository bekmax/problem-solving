package leetcode.strings;

/**
 * N551 Student Attendance Record I.
 * You are given a string s representing an attendance record for a student where each character
 * signifies whether the student was absent, late, or present on that day.
 * The record only contains the following three characters:
 * 'A': Absent.
 * 'L': Late.
 * 'P': Present.
 * The student is eligible for an attendance award if they meet both of the following criteria:
 * The student was absent ('A') for strictly fewer than 2 days total.
 * The student was never late ('L') for 3 or more consecutive days.
 * Return true if the student is eligible for an attendance award, or false otherwise.
 */
public class EasyStudentAttendanceRecordI {
    public static void main(String[] args) {
        String s = "PPALLPLL";

        System.out.println(checkRecord(s));
    }

    public static boolean checkRecord(String s) {
        int absentDays = 0;
        int lateDays = 0;
        boolean isLateYesterday = false;

        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absentDays++;
                lateDays = 0;
                if (absentDays >= 2) {
                    return false;
                }
            } else if (c == 'L') {
                if (isLateYesterday) {
                    lateDays++;
                } else {
                    lateDays = 1;
                    isLateYesterday = true;
                }
                if (lateDays >= 3) {
                    return false;
                }
            } else{
                lateDays = 0;
            }
        }
        return true;
    }

}
