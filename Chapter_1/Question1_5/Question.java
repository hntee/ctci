public class Question {
    public static String compress(String str) {
        if (str == null || str.isEmpty()) return str;
        int length = str.length();

        // set a flag char and initialize count and string buffer
        char flag = '\0';
        int count = 0;
        StringBuffer buffer = new StringBuffer();

        // read through the string
        for (int i = 0; i < length; i++) {
            char current = str.charAt(i);
            if (current != flag) {
                flag = current;
                // append last count if it is not at the beginning
                if (count != 0) buffer.append(count);
                // append the current char
                buffer.append(current);
                // set count
                count = 1;
            } else {
                count++;
            }
        }

        // append the last count
        buffer.append(count);

        String newString = buffer.toString();

        // return only when the new one is smaller
        if (newString.length() < length)
            return newString;
        else
            return str;

    }


    public static void main(String[] args) {
        String s1 = "aaaaaa b d                   ";
        String s2 = " Mr John  mmmm         ";
        String s3 = "    ";
        String s4 = "abcde";
        String s5 = "abbcde";
        String s6 = "a";
        String s7 = null;
        String s8 = "";

        System.out.println(s1 + ", " + compress(s1));
        System.out.println(s2 + ", " + compress(s2));
        System.out.println(s3 + ", " + compress(s3));
        System.out.println(s4 + ", " + compress(s4));
        System.out.println(s5 + ", " + compress(s5));
        System.out.println(s6 + ", " + compress(s6));
        System.out.println(s7 + ", " + compress(s7));
        System.out.println(s8 + ", " + compress(s8));

    }
}