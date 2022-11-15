package code.logic.offer;

public class O22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        int i=0;
        while (i < k && head != null) {
            second = second.next;
            i++;
        }
        while (second != null) {
            first = first.next;
            second = second.next;
        }

        return first;

    }
}
