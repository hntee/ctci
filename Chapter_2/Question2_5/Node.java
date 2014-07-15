public class Node {
    public int data;
    public Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
    }

    public void print() {
        Node n = this;
        while (n != null) {
            System.out.print(n.data);
            if (n.next != null)
                System.out.print(" -> ");
            n = n.next;
        }
        System.out.println();
    }
}


