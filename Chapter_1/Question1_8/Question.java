public class Question {
    public static boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null) 
            return false;
        if (s1.length() != s2.length())
            return false;

        return isSubstring(s1 + s1, s2);
    }

    public static void main(String[] args) {
    }
}