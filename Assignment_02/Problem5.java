package Assignment_02;

// Problem Statement

// Insert in Circular link list

// Given a node from a Circular Linked List which is sorted in ascending order, write a function to insert a value insertVal into the list such that it remains a sorted circular list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the circular list.
// If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the circular list should remain sorted.
// If the list is empty (i.e., given node is null), you should create a new single circular list and return the reference to that single node. Otherwise, you should return the original given node.

// Example 1:
// Input: head = [3,4,1], insertVal = 2
// Output: [3,4,1,2]
// Explanation: In the figure above, there is a sorted circular list of three elements. You are given a reference to the node with value 3, and we need to insert 2 into the list. The new node should be inserted between node 1 and node 3. After the insertion, the list should look like this, and we should still return node 3.

// Example 2:
// Input: head = [], insertVal = 1
// Output: [1]
// Explanation: The list is empty (given head is null). We create a new single circular list and return the reference to that single node.

// Example 3:
// Input: head = [1], insertVal = 0
// Output: [1,0]

public class Problem5 {
    ListNode head;

    public ListNode insert(ListNode head, int insertVal) {
        ListNode newListNode = new ListNode(insertVal);
        if (head == null) {
            head = newListNode;
            head.next = head;
            return head;
        } else if (head.next == head) {
            if (head.val > insertVal) {
                newListNode.next = head;
                head.next = newListNode;
                head = newListNode;
            } else {
                head.next = newListNode;
                newListNode.next = head;
            }
            return head;
        } else {
            ListNode current = head.next;
            ListNode previous = head;
            while (current.val >= previous.val && current != head) {
                previous = current;
                current = current.next;
            }
            if ((current == head && (current.val == previous.val || current.val > insertVal)) || insertVal < current.val
                    || insertVal > previous.val) {
                previous.next = newListNode;
                newListNode.next = current;
                return head;
            }
            ListNode actualHead = current;
            previous = actualHead;
            current = actualHead.next;
            while (true) {
                if (previous.val <= insertVal && current.val >= insertVal) {
                    previous.next = newListNode;
                    newListNode.next = current;
                    break;
                }
                previous = current;
                current = current.next;
            }
            return head;
        }
    }

    public void display(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + "->");
        ListNode current = head.next;
        while (current != head) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("HEAD");
    }

    public static void main(String[] args) {
        Problem5 problem5 = new Problem5();
        problem5.head = new ListNode(2);
        problem5.head.next = new ListNode(4);
        problem5.head.next.next = new ListNode(5);
        problem5.head.next.next.next = new ListNode(6);
        problem5.head.next.next.next.next = new ListNode(7);
        problem5.head.next.next.next.next.next = new ListNode(8);
        problem5.head.next.next.next.next.next.next = new ListNode(9);
        problem5.head.next.next.next.next.next.next.next = new ListNode(11);
        problem5.head.next.next.next.next.next.next.next.next = new ListNode(12);
        problem5.head.next.next.next.next.next.next.next.next.next = new ListNode(13);
        problem5.head.next.next.next.next.next.next.next.next.next.next = problem5.head;
        System.out.println("Linkedlist before adding node with value 10");
        problem5.display(problem5.head);
        problem5.insert(problem5.head.next.next.next, 10);
        System.out.println("\nLinkedlist after adding node with value 10");
        problem5.display(problem5.head);
    }
}
