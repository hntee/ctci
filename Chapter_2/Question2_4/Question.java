/* 
 * Author: Hao Tan
 * Time: 2014/07/14
 * Problem Description: Partition a linked list around a value x,
 *     such that all nodes leass than x come before all nodes greater than or equal to x. 
 * Idea: Find the first element that is greater or equal to x,
 *       iterate the following elements,
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
        Node prev = fakeHead;

        while (pivot.data < x) {
            pivot = pivot.next;
            prev = prev.next;

            // all elements are less than x,
            // return the original head
            if (pivot == null) 
                return head;
        }

        // iterate through elements after pivot,
        // and move them right before pivot
        Node node = pivot.next;
        while (node != null) {
            if (node.data < x) {
                // create a new node and concatinate it to prev
                Node tempNode = new Node(node.data);
                tempNode.next = pivot;
                prev.next = tempNode;
                prev = tempNode;

                // delete the old node
                if (node.next == null) {
                    node = null;
                } else {
                    node.data = node.next.data;
                    node.next = node.next.next;
                }
            } else {
                node = node.next;
            }
        }

        return fakeHead.next;
    }
   
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 2, 3, 4};
        int[] arr1 = {1, 5};
        int[] arr2 = {1};

        // node : 4 -> 3 -> 2 -> 6 -> 5 -> 1
        Node node = createNodeList(arr);

        // node : 5 -> 1
        Node node1 = createNodeList(arr);

        // node : 1
        Node node2 = createNodeList(arr);
        
        node.print();


        for (int i = 0; i < 7; i++) {
            System.out.println("Partition by " + i);
            Node partition = partition(node, i);
            partition.print();
        }




        /*
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
        */

    }
}