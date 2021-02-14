package Assignment_03;

// Problem statement : 
// Remove link list element
// Remove all elements from a linked list of integers that have value val.

// Example:
// Input:  1->2->6->3->4->5->6, val = 6
// Output: 1->2->3->4->5

public class Problem3 {
    ListNode head;

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode current = head;
        dummyNode.next = current;
        ListNode prev = dummyNode;
        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return dummyNode.next;
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
        Problem3 problem3list = new Problem3();
        problem3list.head = new ListNode(2);
        problem3list.head.next = new ListNode(4);
        problem3list.head.next.next = new ListNode(5);
        problem3list.head.next.next.next = new ListNode(6);
        problem3list.head.next.next.next.next = new ListNode(8);
        problem3list.head.next.next.next.next.next = new ListNode(7);
        problem3list.head.next.next.next.next.next.next = new ListNode(3);
        problem3list.head.next.next.next.next.next.next.next = new ListNode(6);

        int val = 6;
        System.out.println("Before removing all elements from a linked list of integers that have value " + val);
        problem3list.display(problem3list.head);

        problem3list.head = problem3list.removeElements(problem3list.head, val);

        System.out.println("After removing all elements from a linked list of integers that have value " + val);
        problem3list.display(problem3list.head);

    }
}
