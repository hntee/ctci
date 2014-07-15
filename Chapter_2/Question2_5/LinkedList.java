public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void appendToHead(Node node) {
        assert node != null;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head.next;
            head = node;    
        }
        
    }

    public void appendToTail(Node node) {
        assert node != null;
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

}

