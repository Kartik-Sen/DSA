public class ReverseLinkedlList {
     // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Reverse the linked list
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;  // Save next node
            curr.next = prev;       // Reverse the link
            prev = curr;            // Move prev to current
            curr = next;            // Move current to next
        }

        return prev;  // New head of reversed list
    }

    // Print the list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to test
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Original List: ");
        printList(head);

        head = reverse(head);

        System.out.print("Reversed List: ");
        printList(head);
    }
}
