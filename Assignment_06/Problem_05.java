package Assignment_06;

public class Problem_05 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode start = dummyHead;
        ListNode previous, current, tempNext;
        while (true) {
            previous = start;
            tempNext = start;
            start = previous.next;

            for (int i = 0; i < k && tempNext != null; ++i) {
                tempNext = tempNext.next;
            }

            if (tempNext == null) {
                break;
            }
            for (int i = 0; i < k - 1; ++i) {
                current = previous.next;
                previous.next = current.next;
                current.next = tempNext.next;
                tempNext.next = current;
            }
        }
        return dummyHead.next;
    }
}
