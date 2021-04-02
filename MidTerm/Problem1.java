package MidTerm;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Problem1 {
    ListNode head;

    /*
     * Time Complexity: O(m+n) where m is the length of list1 and n is the length of
     * list2
     * 
     * Space Complexity: O(1) since we aren't using any extra space
     */
    public boolean areConverging(ListNode n1, ListNode n2) {
        int sizeA = size(n1);
        int sizeB = size(n2);
        int diff = Math.abs(sizeA - sizeB);
        if (sizeA > sizeB) {
            for (int i = 0; i < diff; i++) {
                n1 = n1.next;
            }
        } else if (sizeB > sizeA) {
            for (int i = 0; i < diff; i++) {
                n2 = n2.next;
            }
        }

        while (n1 != null && n2 != null && n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        if (n1 == null) {
            return false;
        }

        if (n1 == n2) {
            while (n1 != null && n2 != null) {
                if (n1 != n2) {
                    return false;
                }
                n1 = n1.next;
                n2 = n2.next;
            }
            return true;
        }
        return false;
    }

    public int size(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            ++size;
        }
        return size;
    }

    public static void main(String[] args) {
        Problem1 list1 = new Problem1();

        // creating first linked list
        list1.head = new ListNode(5);
        list1.head.next = new ListNode(20);

        ListNode node = new ListNode(15);
        node.next = new ListNode(10);
        node.next.next = new ListNode(8);

        list1.head.next.next = node;

        Problem1 list2 = new Problem1();
        // creating second linked list
        list2.head = new ListNode(1);
        list2.head.next = node;

        Problem1 list3 = new Problem1();
        // creating third linked list
        list3.head = new ListNode(12);
        list3.head.next = new ListNode(0);
        list3.head.next.next = new ListNode(11);

        System.out.println("Does two linkedlists intersect: " + list1.areConverging(list1.head, list2.head));
        System.out.println("Does two linkedlists intersect: " + list1.areConverging(list1.head, list3.head));
    }
}
