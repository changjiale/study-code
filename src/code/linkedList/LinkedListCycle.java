package code.linkedList;

import java.util.Arrays;
import java.util.List;


/**
 * 给定一个链表，判断链表中是否有环。
 */

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }

    void add (int value) {
        ListNode newNode = new ListNode(value);
        if(this.next == null)
            this.next = newNode;
        else
            this.next.add(value);
    }

    String sout() {
        StringBuffer buffer = new StringBuffer();
        ListNode node = this;
        while(node!= null) {
            buffer.append(node.value);
            buffer.append("->");
            node = node.next;
        }
        buffer.append("NULL");
        return buffer.toString();
    }
}

public class LinkedListCycle {

    private boolean listedListCycle(ListNode node) {

        if(node == null){
            return false;
        }

        ListNode fast = node.next;
        ListNode slow = node;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;

        }
        return true;
    }

    public static void main(String[] args) {

        LinkedListCycle linkedListCycle = new LinkedListCycle();

        List<Integer> lists = Arrays.asList(1, 2, 3, 4, 5);

        ListNode head = new ListNode(0);

        for (Integer value : lists) {
            head.add(value);
        }

        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = head;

        boolean b = linkedListCycle.listedListCycle(head);
        System.out.println(b);

    }
}
