/* 
 * Author: Hao Tan
 * Time: 2014/07/14
 * Problem Description: Partition a linked list around a value x,
 *     such that all nodes leass than x come before all nodes greater than or equal to x. 
 * Idea: Find the first element that is greater or equal to x,
 *       iterate through the following elements,
 *       place the elements less than x right before the pivot
 * Time: O(n), Space: O(1)
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

    public static Node partition(Node head, int x) {
        if (head == null) return null;

        // create a fake node pointing to the origin head
        Node fakeHead = new Node(0);
        fakeHead.next = head;

        // find the pivot
        Node pivot = head;
        Node leftEnd = fakeHead;

        while (pivot.data < x) {
            pivot = pivot.next;
            leftEnd = leftEnd.next;

            // all elements are less than x,
            // return the original head
            if (pivot == null) 
                return head;

        }

        // iterate through elements after pivot,
        // and move them right before pivot
        Node node = pivot.next;

        // keep track of the penultimate element,
        // so if the last element needs to be deleted,
        // we will need it
        Node penultimate = pivot;

        while (node != null) {

            if (node.data < x) {
                // create a new node and concatinate it to leftEnd
                Node tempNode = new Node(node.data);
                tempNode.next = pivot;
                leftEnd.next = tempNode;
                leftEnd = tempNode;

                // delete the old node
                if (node.next == null) {
                    penultimate.next = null;
                    node = null;
                } else {
                    node.data = node.next.data;
                    node.next = node.next.next;
                }
            } else {
                node = node.next;
                penultimate = penultimate.next;
            }
        }

        return fakeHead.next;
    }
   
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 2, 3, 4};
        int[] arr1 = {1, 5};
        int[] arr2 = {1};

        for (int i = 0; i < 9; i++) {
            System.out.println("==========");
            Node node = createNodeList(arr2);
            node.print();
            System.out.println("Partition by " + i);
            Node partition = partition(node, i);
            partition.print();
        }

    }
}