//package Question1_1;

public class Question {
    public static boolean unique(String str) {
        int checker = 0;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0)
                return false;
            else
                checker |= 1 << val;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = {"abcd", "aabc", "qwdcw"};
        for (String s : strings) {
            System.out.println(s + ": " + unique(s));
        }
    }
}