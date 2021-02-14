package Assignment_03;

//Problem Statement:
// Swap Nodes in link list 
// You are given the head of a linked list, and an integer k.
// Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [1,4,3,2,5]

public class Problem2 {
    ListNode head;

    public ListNode swapNodes(ListNode head, int k) {
        ListNode ref1 = head;
        ListNode ref2 = head;
        while (ref1 != null && --k > 0) {
            ref1 = ref1.next;
        }
        ListNode kthFromBeginning = ref1;
        while (ref1.next != null) {
            ref1 = ref1.next;
            ref2 = ref2.next;
        }
        ListNode kthFromEnd = ref2;
        int temp = kthFromBeginning.val;
        kthFromBeginning.val = kthFromEnd.val;
        kthFromEnd.val = temp;
        return head;
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
        Problem2 problem2list = new Problem2();
        problem2list.head = new ListNode(2);
        problem2list.head.next = new ListNode(4);
        problem2list.head.next.next = new ListNode(5);
        problem2list.head.next.next.next = new ListNode(6);
        problem2list.head.next.next.next.next = new ListNode(8);
        problem2list.head.next.next.next.next.next = new ListNode(7);
        problem2list.head.next.next.next.next.next.next = new ListNode(3);
        problem2list.head.next.next.next.next.next.next.next = new ListNode(9);

        System.out.println("Linkedlist before swapping values of kth element from beginning and end");
        problem2list.display(problem2list.head);
        int k = 3;

        System.out.println("Linkedlist after swapping values of kth element from beginning and end");
        problem2list.head = problem2list.swapNodes(problem2list.head, k);
        problem2list.display(problem2list.head);
    }
}