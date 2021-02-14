package Assignment_03;

// Problem statement : Delete N Nodes After M Nodes of a Linked List

// Given the head of a linked list and two integers m and n. Traverse the linked list and remove some nodes in the following way:
// Start with the head as the current node.
// Keep the first m nodes starting with the current node.
// Remove the next n nodes
// Keep repeating steps 2 and 3 until you reach the end of the list.
// Return the head of the modified list after removing the mentioned nodes.

// Example 1:
// Input: head = [1,2,3,4,5,6,7,8,9,10,11,12,13], m = 2, n = 3
// Output: [1,2,6,7,11,12]

public class Problem4 {
    ListNode head;

    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode current = head;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = current;
        int a = m;
        int b = n;
        while (current != null) {
            if (a > 0) {
                b = n;
                prev = current;
                current = current.next;
                a--;
            } else if (b > 0) {
                current = current.next;
                b--;
            } else {
                a = m;
                prev.next = current;
            }
        }
        prev.next = null;
        return dummy.next;
    }

    public void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Problem4 problem4list = new Problem4();
        problem4list.head = new ListNode(2);
        problem4list.head.next = new ListNode(4);
        problem4list.head.next.next = new ListNode(5);
        problem4list.head.next.next.next = new ListNode(6);
        problem4list.head.next.next.next.next = new ListNode(8);
        problem4list.head.next.next.next.next.next = new ListNode(7);
        problem4list.head.next.next.next.next.next.next = new ListNode(3);
        problem4list.head.next.next.next.next.next.next.next = new ListNode(9);
        int m = 2, n = 3;
        System.out.println("Before deleting N Nodes After M Nodes of the Linked List");
        problem4list.display(problem4list.head);

        problem4list.head = problem4list.deleteNodes(problem4list.head, m, n);

        System.out.println("Before deleting N Nodes After M Nodes of the Linked List");
        problem4list.display(problem4list.head);

    }
}
