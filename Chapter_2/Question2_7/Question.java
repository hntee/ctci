/* 
 * Author: Hao Tan
 * Time: 2014/07/15
 * Problem Description: check if a linked list is a palindrome 
 * Input: A linked list
 * Output: boolean value
 * Time: O(n), Space: O(n/2) 
 */

import java.util.Stack;

public class Question {
    public static Node createNodeList(int[] array) {
        assert array.length > 0;
        LinkedList list = new LinkedList();
        for (int i = 0; i < array.length; i++) {
            list.appendToTail(new Node(array[i]));
        }
        return list.head;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;
        Node slow = head;
        Node fast = head;

        // push elements into stack until we reach the middle position
        Stack stack = new Stack();
        while (fast.next != null && fast.next.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        } 

        /* if the length is odd, fast will reach the end,
         * slow will be right at middle
         * otherwise fast.next.next == null,
         * slow will be at the end of the left half
         *
         * for example,
         *
         * stack
         *  | 
         * (1 -> 2 -> 3 -> 4)
         *       |    |
         *      slow fast
         * 
         *     stack
         *       |
         * (1 -> 2 -> 3 -> 4 -> 5)
         *            |         |
         *           slow      fast
         *
         * Be caucios, current slow node's data has not been pushed to stack
         */

        // only push it when the list is even
        if (fast.next != null)
            stack.push(slow.data);

        // move slow to the right half
        slow = slow.next;

        // compare data with data in the stack
        while (slow != null) {
            if (!stack.pop().equals(slow.data))
                return false;
            slow = slow.next;
        }

        return true;

    }
    public static void main(String[] args) {
        int[] arr = {9};
        int[] arr1 = {5, 9, 5};
        int[] arr2 = {9, 9};
        int[] arr3 = {1, 9};
        int[] arr4 = {9, 8};
        int[] arr5 = {9, 8, 8, 9};
        int[] arr6 = {1, 2, 3, 2, 1};
        int[] arr7 = {1, 2, 3, 4, 1};
        int[] arr8 = {1, 2, 3, 2, 0};

        Node node = createNodeList(arr);
        Node node1 = createNodeList(arr1);
        Node node2 = createNodeList(arr2);
        Node node3 = createNodeList(arr3);
        Node node4 = createNodeList(arr4);
        Node node5 = createNodeList(arr5);
        Node node6 = createNodeList(arr6);
        Node node7 = createNodeList(arr7);
        Node node8 = createNodeList(arr8);

		node.print();
		System.out.println("isPalindrome: " + isPalindrome(node));

		node1.print();
		System.out.println("isPalindrome: " + isPalindrome(node1));
			
		node2.print();
		System.out.println("isPalindrome: " + isPalindrome(node2));

		node3.print();
		System.out.println("isPalindrome: " + isPalindrome(node3));

		node4.print();
		System.out.println("isPalindrome: " + isPalindrome(node4));

		node5.print();
		System.out.println("isPalindrome: " + isPalindrome(node5));

		node6.print();
		System.out.println("isPalindrome: " + isPalindrome(node6));

		node7.print();
		System.out.println("isPalindrome: " + isPalindrome(node7));

		node8.print();
		System.out.println("isPalindrome: " + isPalindrome(node8));

    }
}
