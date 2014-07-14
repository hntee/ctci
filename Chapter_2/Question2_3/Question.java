/* 
 * Author: Hao Tan
 * Time: 2014/07/14
 * Problem Description: Delete a node in the middle of a singly linked list.
 * Idea: Copy data of the next node to the current node, and delete the next node
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

    public static boolean deleteNode(Node node) {
        if (node == null || node.next == null)
            return false;
        node.data = node.next.data;
        node.next = node.next.next;
        return true;
    }
   
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        // node :7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1
        Node node = createNodeList(arr);
        
        Node node4 = node.next.next.next;
        Node node5 = node.next.next;
        Node node6 = node.next;

        assert deleteNode(node4) == true;

        // should be 7 -> 6 -> 5 -> 3 -> 2 -> 1
        node.print();

        assert deleteNode(node5) == true;

        // should be 7 -> 6 -> 3 -> 2 -> 1
        node.print();

        assert deleteNode(node6) == true;

        // should be 7 -> 3 -> 2 -> 1
        node.print();

        Node node1 = node.next.next.next;
        assert deleteNode(node1) == false;

        // should be 7 -> 3 -> 2 -> 1
        node.print();

    }
}