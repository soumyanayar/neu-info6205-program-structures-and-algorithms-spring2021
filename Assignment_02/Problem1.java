package Assignment_02;

// Problem Statement: 
//
// Given a linked list, swap every two adjacent nodes and return its head.
//
// Example:
// Input: head = [1,2,3,4]
// Output: [2,1,4,3]

public class Problem1 {
    ListNode head;

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        ListNode first;
        ListNode second;
        while (current.next != null && current.next.next != null) {
            first = current.next;
            second = current.next.next;
            first.next = second.next;
            second.next = first;
            current.next = second;
            current = current.next.next;
        }
        return dummy.next;
    }

    public void display() {
        ListNode current = this.head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        problem1.head = new ListNode(0);
        problem1.head.next = new ListNode(1);
        problem1.head.next.next = new ListNode(2);
        problem1.head.next.next.next = new ListNode(3);
        problem1.head.next.next.next.next = new ListNode(4);
        problem1.head.next.next.next.next.next = new ListNode(5);
        problem1.head.next.next.next.next.next.next = new ListNode(6);
        problem1.head.next.next.next.next.next.next.next = new ListNode(7);
        System.out.println("Linked List before swapping the alternate nodes");
        problem1.display();

        problem1.head = problem1.swapPairs(problem1.head);
        System.out.println("Linked List after swapping the alternate nodes");
        problem1.display();
    }
}
