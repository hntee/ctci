/* 
 * Author: Hao Tan
 * Time: 2014/08/10
 * Problem Description: Given two 32-bit numbers, N and M, and two bit positions, i and j.
 *                      Insert M into N such that M starts at bit j and ends at bit i.
 */


public class Question {

    public static void binaryPrint(int x) {
        System.out.println(Integer.toBinaryString(x));
    }

    public static int insert (int M, int N, int i, int j) {
        // 11..111111100
        int mask_left = 1 << 31 >> (31 - i);
        // 00..000111111
        int mask_right = ~(1 << 31 >> (31 - (j + 1)));
        return ((mask_left ^ mask_right) & N) | (M << i) ;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt("10000000000", 2);
        int M = Integer.parseInt("10011", 2);
        int i = 2;
        int j = 6;
        int x = insert(M, N, i, j);

        binaryPrint(x);

    }
}