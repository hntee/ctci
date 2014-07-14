/* 
 * Author: Hao Tan
 * Time: 2014/07/14
 * Problem Description: Find the kth to last element of a singly linked list.
 */

public class Question {
    public static Node createNodeList(int[] array) {
        assert array.length > 0;
        Node head = new Node(array[0]);
        for (int i = 1; i < array.length; i++) {
            Node n = new Node(array[i], head);
            head = n;
        }
        return head;
    }

    public static Node kthToLast(Node head, int k) {
        if (head == null) return null;
        Node runner = head;

        // let runner go further k elements first
        for (int i = 0; i < k; i++) {
            runner = runner.next;
            if (runner == null) return null;
        }

        // head and runner go together
        while (runner.next != null) {
            head = head.next;
            runner = runner.next;
        }

        return head;
    }
   
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] arr1 = {99};

        // node :7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1
        Node node = createNodeList(arr);
        Node node1 = createNodeList(arr1);
        Node node2 = null;

        Node kthToLastNode = kthToLast(node, 1); // 2
        Node kthToLastNode1 = kthToLast(node, 5); // 6
        Node kthToLastNode2 = kthToLast(node, 0); // 1
        Node kthToLastNode3 = kthToLast(node, 9); // null
        Node kthToLastNode4 = kthToLast(node1, 1); // null
        Node kthToLastNode5 = kthToLast(node1, 2); // null
        Node kthToLastNode6 = kthToLast(node1, 0); // 99
        Node kthToLastNode7 = kthToLast(node2, 1); // null
        Node kthToLastNode8 = kthToLast(node, 6); // 7
        Node kthToLastNode9 = kthToLast(node, 7); // null

        assert kthToLastNode.data == 2;
        assert kthToLastNode1.data == 6;
        assert kthToLastNode2.data == 1;
        assert kthToLastNode3 == null;
        assert kthToLastNode4 == null;
        assert kthToLastNode5 == null;
        assert kthToLastNode6.data == 99;
        assert kthToLastNode7 == null;
        assert kthToLastNode8.data == 7;
        assert kthToLastNode9 == null;

    }
}