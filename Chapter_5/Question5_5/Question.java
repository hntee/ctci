/* 
 * Author: Hao Tan
 * Time: 2014/08/12
 * Problem Description: Write a function to determine the number of bits required to 
 *                      convert integer A to integer B
 */


public class Question {
    public static int bitsToConvert(int a, int b) {
        int diff = a ^ b;
        int count = 0;
        while (diff != 0) {
            count++;
            diff = diff & (diff - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 31;
        int b = 14;
        System.out.println(bitsToConvert(a, b));
    }
}