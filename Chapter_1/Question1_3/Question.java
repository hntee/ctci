public class Question {
    public static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int length = str1.length();

        // scan str1 and str2
        int[] count1 = new int[256];
        int[] count2 = new int[256];
        for (int i = 0; i < length; i++) {
            int val1 = str1.charAt(i);
            int val2 = str2.charAt(i);
            count1[val1]++;
            count2[val2]++;
        }

        // check count array
        for (int i = 0; i < length; i++) {
            int val = str1.charAt(i);
            if (count1[val] != count2[val])
                return false;
        }

        return true;
    }

    // this method has better performance 
    // (half of the space complexity of the above one)
    public static boolean isPermutation2(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int length = str1.length();

        // scan str1
        int[] count = new int[256];
        for (int i = 0; i < length; i++) {
            int val = str1.charAt(i);
            count[val]++;
        }

        // scan str2 and check if each char has the same count
        for (int i = 0; i < length; i++) {
            int val = str2.charAt(i);
            if (--count[val] < 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "abd";
        String s2 = "adb";
        String s3 = "aaa";
        String s4 = "";
        String s5 = "";
        String s6 = "q";
        String s7 = "q";

        System.out.println(s1 + ", " + s2 + ": " + isPermutation(s1, s2));
        System.out.println(s1 + ", " + s3 + ": " + isPermutation(s1, s3));
        System.out.println(s2 + ", " + s3 + ": " + isPermutation(s2, s3));
        System.out.println(s4 + ", " + s5 + ": " + isPermutation(s4, s5));
        System.out.println(s4 + ", " + s6 + ": " + isPermutation(s4, s6));
        System.out.println(s7 + ", " + s6 + ": " + isPermutation(s7, s6));


        System.out.println(s1 + ", " + s2 + ": " + isPermutation2(s1, s2));
        System.out.println(s1 + ", " + s3 + ": " + isPermutation2(s1, s3));
        System.out.println(s2 + ", " + s3 + ": " + isPermutation2(s2, s3));
        System.out.println(s4 + ", " + s5 + ": " + isPermutation2(s4, s5));
        System.out.println(s4 + ", " + s6 + ": " + isPermutation2(s4, s6));
        System.out.println(s7 + ", " + s6 + ": " + isPermutation2(s7, s6));

    }
}