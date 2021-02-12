package Assignment_02;

// Problem Statement: 

// Delete Node in a LinkedList
// Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, 
// instead you will be given access to the node to be deleted directly.
// Example:
// Input: head = [4,5,1,9], node = 5
// Output: [4,1,9]

public class Problem2 {
    ListNode head;

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
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
        Problem2 problem1 = new Problem2();
        problem1.head = new ListNode(2);
        problem1.head.next = new ListNode(4);
        problem1.head.next.next = new ListNode(5);
        problem1.head.next.next.next = new ListNode(6);
        problem1.head.next.next.next.next = new ListNode(8);
        problem1.head.next.next.next.next.next = new ListNode(7);
        problem1.head.next.next.next.next.next.next = new ListNode(3);
        problem1.head.next.next.next.next.next.next.next = new ListNode(9);
        problem1.head.next.next.next.next.next.next.next.next = new ListNode(1);
        problem1.head.next.next.next.next.next.next.next.next.next = new ListNode(13);
        problem1.head.next.next.next.next.next.next.next.next.next.next = new ListNode(12);
        System.out.println("LinkedList before deleting a node with value 3");
        problem1.display();
        problem1.deleteNode(problem1.head.next.next.next.next.next.next);
        System.out.println("\nLinkedList after deleting the node with value 3");
        problem1.display();
    }
}
