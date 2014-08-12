/* 
 * Author: Hao Tan
 * Time: 2014/08/12
 * Problem Description: Swap odd and even bits in an integer 
 *                      with as few instructions as possible.
 */


public class Question {
    public static int swapOddEven(int x) {
        // 0xaaaaaaaa makes odd bits zeros
        // 0x55555555 makes even bits zeros
        return (((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1));
    }

    public static void main(String[] args) {
        int a = Integer.parseInt("10101010100", 2);
        System.out.println(a);
        int b = swapOddEven(a);
        System.out.println(b);
        System.out.println(Integer.toBinaryString(swapOddEven(a)));
    }
}