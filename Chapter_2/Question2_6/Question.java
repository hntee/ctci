/* 
 * Author: Hao Tan
 * Time: 2014/07/15
 * Problem Description: Given a circular linked list,
 *                      return the node at the beginning of the loop
 * Input: A -> B -> C -> D -> E -> C
 * Output: C
 * Time: O(n), Space: O(1)
 * Idea: Make two pointers:
 *       fastPointer: 2 steps at a time
 *       slowPointer: 1 step at a time
 *       when they collide, move slowPointer back to head,
 *       then two pointers both move 1 step at a time,
 *       when they collide again, the node is the result
 */

public class Question {
    public static Node loopBeginning(Node head) {
        Node slow = head;
        Node fast = head;

        boolean begin = false;

        while (slow != fast || !begin) {
            begin = true;
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        // 1 -> 2 -> 3 -> 4 -> 5 -> 3
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        System.out.println(loopBeginning(node1).data); // 3
    }
}