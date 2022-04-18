package code.logic.offer;

import java.util.Arrays;

/**
 * 合并两个有序链表
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int value) {
        this.val = value;
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
            buffer.append(node.val);
            buffer.append("->");
            node = node.next;
        }
        buffer.append("NULL");
        return buffer.toString();
    }
}
public class O25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(0);

        ListNode cur = node;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;

        }

        if (l1 != null) {
            node.next = l1;
        }

        if (l2 != null) {
            node.next = l2;
        }
        return cur.next;

    }
    public static void main(String[] args) {
        int[] arr1 ={1, 2, 3, 4, 5, 100};
        int[] arr2 = {3, 4, 5, 6 , 8, 9 , 10};
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

        for (int i = 0; i < arr1.length; i++) {
            l1.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            l2.add(arr2[i]);
        }
        O25 o25 = new O25();
        ListNode listNode = o25.mergeTwoLists(l1.next, l2.next);
        String sout = listNode.sout();
        System.out.println(sout);
    }

}
