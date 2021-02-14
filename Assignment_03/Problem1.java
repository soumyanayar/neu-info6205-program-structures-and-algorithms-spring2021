package Assignment_03;

// Problem Statement

// You are given two linked lists: list1 and list2 of sizes n and m respectively.
// Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
// The blue edges and nodes in the following figure incidate the result:
// Build the result list and return its head.

// Example 1:
// Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
// Output: [0,1,2,1000000,1000001,1000002,5]
// Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.

// Example 2:
// Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
// Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
// Explanation: The blue edges and nodes in the above figure indicate the result.

public class Problem1 {
    ListNode head;

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode list1prevNodeBeforeDelete = list1;
        ListNode list1nextNodeAfterDelete = list1;
        int k = 0;
        ListNode current = list1;
        while (current != null) {
            if (k == a - 1) {
                list1prevNodeBeforeDelete = current;
            } else if (k == b + 1) {
                list1nextNodeAfterDelete = current;
                break;
            }
            ++k;
            current = current.next;
        }
        ListNode list2LastNode = list2;
        while (list2LastNode.next != null) {
            list2LastNode = list2LastNode.next;
        }
        list1prevNodeBeforeDelete.next = list2;
        list2LastNode.next = list1nextNodeAfterDelete;
        return list1;
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
        Problem1 problem1List1 = new Problem1();
        problem1List1.head = new ListNode(2);
        problem1List1.head.next = new ListNode(4);
        problem1List1.head.next.next = new ListNode(5);
        problem1List1.head.next.next.next = new ListNode(6);
        problem1List1.head.next.next.next.next = new ListNode(8);
        problem1List1.head.next.next.next.next.next = new ListNode(7);
        problem1List1.head.next.next.next.next.next.next = new ListNode(3);
        problem1List1.head.next.next.next.next.next.next.next = new ListNode(9);

        System.out.println("Linkedlist 1");
        problem1List1.display();

        Problem1 problem1List2 = new Problem1();
        problem1List2.head = new ListNode(23);
        problem1List2.head.next = new ListNode(24);
        problem1List2.head.next.next = new ListNode(25);
        problem1List2.head.next.next.next = new ListNode(26);
        problem1List2.head.next.next.next.next = new ListNode(28);

        System.out.println("Linkedlist 2");
        problem1List2.display();

        int a = 2;
        int b = 5;
        problem1List1.head = mergeInBetween(problem1List1.head, a, b, problem1List2.head);

        System.out.println(
                "Linked List 1 after removing list1's nodes from the ath node to the bth node, and putting list2 in their place");
        problem1List1.display();
    }
}
