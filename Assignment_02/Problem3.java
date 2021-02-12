package Assignment_02;

// Problem Statement

// Odd Even Linked List
// Given a singly linked list, group all odd nodes together followed by the even nodes. 
// Please note here we are talking about the node number and not the value in the nodes.
// Example 1:
// Input: 1->2->3->4->5->NULL
// Output: 1->3->5->2->4->NULL
// Example 2:
// Input: 2->1->3->5->6->4->7->NULL
// Output: 2->3->6->7->1->5->4->NULL

public class Problem3 {
    ListNode head;

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenBeginning = head.next;
        ListNode evenHead = head.next;

        while (evenHead != null) {
            oddHead.next = evenHead.next;
            if (oddHead.next != null) {
                oddHead = oddHead.next;
            }
            evenHead.next = oddHead.next;
            evenHead = evenHead.next;
        }
        oddHead.next = evenBeginning;
        return head;
    }

    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        problem3.head = new ListNode(2);
        problem3.head.next = new ListNode(4);
        problem3.head.next.next = new ListNode(5);
        problem3.head.next.next.next = new ListNode(6);
        problem3.head.next.next.next.next = new ListNode(8);
        problem3.head.next.next.next.next.next = new ListNode(7);
        problem3.head.next.next.next.next.next.next = new ListNode(3);
        problem3.head.next.next.next.next.next.next.next = new ListNode(9);
        problem3.head.next.next.next.next.next.next.next.next = new ListNode(1);
        problem3.head.next.next.next.next.next.next.next.next.next = new ListNode(13);
        problem3.head.next.next.next.next.next.next.next.next.next.next = new ListNode(12);
        System.out.println("LinkedList before grouping all odd nodes together followed by the even nodes");
        problem3.display();
        problem3.head = problem3.oddEvenList(problem3.head);
        System.out.println("\nLinkedList after grouping all odd nodes together followed by the even nodes");
        problem3.display();
    }
}