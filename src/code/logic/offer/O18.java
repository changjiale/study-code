package code.logic.offer;

public class O18 {
    public ListNode deleteNode(ListNode head, int val) {

        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }

        ListNode node = head;

        while(node.next != null && node.next.val != val) {
            node = node.next;
        }

        if (node.next != null && node.next.val == val) {
            node.next = node.next.next;
        }
        return head;

    }
}
