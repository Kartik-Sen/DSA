public class MergeTwoSortedLists {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node mergeSortedLists(Node list1, Node list2) {
        Node dummy = new Node(-1); // Dummy node to start the merged list
        Node tail = dummy; // Tail to build the new list

        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // If one list still has nodes, attach it
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return dummy.next; // Return the real head
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create first sorted list: 1 → 3 → 5
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);

        // Create second sorted list: 2 → 4 → 6
        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);

        System.out.print("List 1: ");
        printList(list1);

        System.out.print("List 2: ");
        printList(list2);

        // Merge them
        Node merged = mergeSortedLists(list1, list2);

        System.out.print("Merged List: ");
        printList(merged);
    }
}
