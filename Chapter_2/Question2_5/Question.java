/* 
 * Author: Hao Tan
 * Time: 2014/07/15
 * Problem Description: Add two reverse order linked list. 
 * Input: (7 -> 1 -> 6), (5 -> 9 -> 2)
 * Output: 2 -> 1 -> 9 (617 + 295 = 912)
 * Time: O(n), Space: O(n)
 */

public class Question {
    public static Node createNodeList(int[] array) {
        assert array.length > 0;
        LinkedList list = new LinkedList();
        for (int i = 0; i < array.length; i++) {
            list.appendToTail(new Node(array[i]));
        }
        return list.head;
    }

    public static Node add(Node node1, Node node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        int carry = 0;
        LinkedList result = new LinkedList();
        while (carry != 0 || node1 != null || node2 != null) {
            int num1 = node1 != null ? node1.data : 0;
            int num2 = node2 != null ? node2.data : 0;
            int sum = num1 + num2 + carry;
            if (sum > 9) {
                sum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result.appendToTail(new Node(sum));
            if (node1 != null) node1 = node1.next;
            if (node2 != null) node2 = node2.next;
        }
        return result.head;
    }

    public static Node reverseNodeList(Node head) {
        if (head == null) return null;
        if (head.next == null) return head;
        Node prev = head;
        Node cur = head.next;
        boolean isEnd = false;
        while (true) {
            Node next = cur.next;
            if (next == null) isEnd = true;
            cur.next = prev;
            if (isEnd) break;
            prev = cur;
            cur = next;
        }
        head.next = null;
        return cur;
    }

    // two numbers are stored in forward roder.
    // Input: (6 -> 1 -> 7) + (2 -> 9 -> 5)
    // Output: 9 -> 1 -> 2
    // Idea: First reverse the two linked lists,
    //       use add function,
    //       and reverse the result
    //       but it is important to pad the tail with 0s
    // Time: O(n), Space: O(n)
    // Disadvantage: It modifies the original input!!
    public static Node add2(Node node1, Node node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;

        int len1 = getLength(node1);
        int len2 = getLength(node2);

        Node shorterList = len1 > len2 ? node2 : node1;

        for (int i = 0; i < Math.abs(len1 - len2); i++) {
            // append 0s to its head
            Node newNode = new Node(0);
            newNode.next = shorterList;
            shorterList = newNode;
        }

        // reverse the lists
        Node reversedNode1 = reverseNodeList(node1);
        Node reversedNode2 = reverseNodeList(node2);

        return reverseNodeList(add(reversedNode1, reversedNode2));
    }
   
    public static int getLength(Node node) {
        if (node == null) return 0;
        int len = 1;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 6};
        int[] arr1 = {5, 9, 2};
        int[] arr2 = {0};
        int[] arr3 = {9, 9, 9, 9, 9, 9};


        Node node1 = createNodeList(arr);
        Node node2 = createNodeList(arr1);

        node1.print();
        node2.print();
        
        add(node1, node2).print();

        // method 2
        int[] arr8 = {6, 1, 7};
        int[] arr7 = {2, 9, 5};
        Node node3 = createNodeList(arr8);
        Node node4 = createNodeList(arr7);

        node3.print();
        node4.print();

        add2(node3, node4).print();
    }
}