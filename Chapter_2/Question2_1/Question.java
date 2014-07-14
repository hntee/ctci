import java.util.Hashtable;

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

    // Time complexity: O(n), space complexity: O(n)
    public static void removeDuplicates(Node head) {
        Hashtable table = new Hashtable();
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (table.containsKey(current.data)) {
                previous.next = current.next;
            } else {
                table.put(current.data, true);
                previous = current;
            }
            current = current.next;
        }
    }

    // Time complexity: O(n^2), space complexity: O(1)
    public static void removeDuplicates2(Node head) {
        //Node current = head;
        while (head != null) {
            Node previous = head;
            Node n = head.next;
            while (n != null) {
                if (n.data == head.data) {
                    previous.next = n.next;
                } else {
                    previous = n;
                }
                n = n.next;
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
        int[] arr1 = {1};
        int[] arr2 = {2, 2, 2};
        Node node = createNodeList(arr);
        Node node1 = createNodeList(arr1);
        Node node2 = createNodeList(arr2);

        node.print();
        node1.print();
        node2.print();

        System.out.println("After removing:");

        removeDuplicates(node);
        removeDuplicates(node1);
        removeDuplicates(node2);

        node.print();
        node1.print();
        node2.print();

        System.out.println("Method2:");
        node = createNodeList(arr);
        node1 = createNodeList(arr1);
        node2 = createNodeList(arr2);

        System.out.println("After removing:");

        removeDuplicates2(node);
        removeDuplicates2(node1);
        removeDuplicates2(node2);

        node.print();
        node1.print();
        node2.print();


    }
}