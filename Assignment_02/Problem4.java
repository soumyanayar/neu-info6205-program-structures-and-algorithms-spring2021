package Assignment_02;

// Problem Statement
// Split Link list in parts

// Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
// The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.
// The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
// Return a List of ListNode's representing the linked list parts that are formed.

// Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
// Example 1:
// Input:
// root = [1, 2, 3], k = 5
// Output: [[1],[2],[3],[],[]]
// Explanation:
// The input and each element of the output are ListNodes, not arrays.
// For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
// The first element output[0] has output[0].val = 1, output[0].next = null.
// The last element output[4] is null, but it's string representation as a ListNode is [].
// Example 2:
// Input: 
// root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
// Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
// Explanation: The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.

public class Problem4 {
    ListNode head;

    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode current = root;
        while (current != null) {
            ++len;
            current = current.next;
        }
        int n = len / k;
        int r = len % k;
        current = root;
        ListNode[] splitLists = new ListNode[k];
        for (int i = 0; i < k; ++i) {
            ListNode dummyHead = new ListNode(-1);
            ListNode currentSplit = dummyHead;
            for (int j = 0; j < n; ++j) {
                currentSplit.next = current;
                currentSplit = currentSplit.next;
                current = current.next;
            }
            if (r > 0) {
                currentSplit.next = current;
                currentSplit = currentSplit.next;
                current = current.next;
                --r;
            }
            currentSplit.next = null;
            splitLists[i] = dummyHead.next;
        }
        return splitLists;
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
        Problem4 problem4 = new Problem4();
        problem4.head = new ListNode(2);
        problem4.head.next = new ListNode(4);
        problem4.head.next.next = new ListNode(5);
        problem4.head.next.next.next = new ListNode(6);
        problem4.head.next.next.next.next = new ListNode(8);
        problem4.head.next.next.next.next.next = new ListNode(7);
        problem4.head.next.next.next.next.next.next = new ListNode(3);
        problem4.head.next.next.next.next.next.next.next = new ListNode(9);
        problem4.head.next.next.next.next.next.next.next.next = new ListNode(1);
        problem4.head.next.next.next.next.next.next.next.next.next = new ListNode(13);
        problem4.head.next.next.next.next.next.next.next.next.next.next = new ListNode(12);

        System.out.println("Linkedlist before splitting into k parts");
        problem4.display(problem4.head);

        int k = 3;
        System.out.println("\nLinkedlist after splitting into " + k + " parts");
        ListNode[] chunks = problem4.splitListToParts(problem4.head, k);
        for (ListNode chunkHead : chunks) {
            problem4.display(chunkHead);
        }
    }
}
