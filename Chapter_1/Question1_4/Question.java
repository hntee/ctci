public class Question {
    public static String replaceSpace(String str, int tLength) {
        if (str == null || tLength == 0) return str;

        char[] charArray = str.toCharArray();

        // scan for spaces
        int spaceCount = 0;
        for (int i = 0; i < tLength; i++) {
            if (charArray[i] == ' ')
                spaceCount++;
        }

        // compute the length
        int totalLength = tLength + 2 * spaceCount;

        // scan reversely and move the chars
        int tailIndex = totalLength - 1;
        for (int i = tLength - 1; i >= 0; i--) {
            if (charArray[i] != ' ') {
                charArray[tailIndex--] = charArray[i];
            } else {
                charArray[tailIndex--] = '0';
                charArray[tailIndex--] = '2';
                charArray[tailIndex--] = '%';
            }
        }

        // reassemble the string
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < totalLength; i++) {
            buffer.append(charArray[i]);
        }

        return buffer.toString();
    }


    public static void main(String[] args) {
        String s1 = "a b d                   ";
        String s2 = " Mr John           ";
        String s3 = "    ";

        System.out.println(s1 + ", " + replaceSpace(s1, 5));
        System.out.println(s1 + ", " + replaceSpace(s1, 6));
        System.out.println(s2 + ", " + replaceSpace(s2, 8));
        System.out.println(s2 + ", " + replaceSpace(s2, 9));
        System.out.println(s3 + ", " + replaceSpace(s3, 1));

    }
}