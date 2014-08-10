/* 
 * Author: Hao Tan
 * Time: 2014/08/10
 * Problem Description: Print a real number (between 0 and 1)'s binary representation.
 */


public class Question {

    public static String binaryPrint(double n) {
        if (n < 0 || n > 1) return "ERROR";
        if (n == 0) return "0";
        if (n == 1) return "1";
        StringBuilder s = new StringBuilder();
        s.append('.');
        double frac = 0.5;

        while (true) {
            if (s.length() > 32) return "ERROR";
            if (n >= frac) {
                s.append('1');
                n -= frac;
            } else {
                s.append('0');
            }
            if (n == 0) return s.toString();
            frac /= 2;
        }
    }
    public static void main(String[] args) {
        System.out.println(binaryPrint(0.5));
        System.out.println(binaryPrint(0.0));
        System.out.println(binaryPrint(0.5009765625));
        System.out.println(binaryPrint(0.3));
        System.out.println(binaryPrint(0.5000000009313226));
    }
}