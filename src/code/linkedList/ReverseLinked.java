package code.linkedList;

import java.util.Arrays;
import java.util.List;

/**
 * 翻转链表
 */

/**
 * 翻转链表要素
 * 1 初始条件 链表要移动 所以记录当前的节点cur和前驱节点pre
 * 2 在后移中， 通过获取当前节点的下一个节点next  进行后移
 * 3 将当前节点的后置节点 变更为之前记录的前置节点pre
 * 4 修改前置节点pre 为当前节点（后移 会自动变为下一节点的前置节点）
 */


public class ReverseLinked {

    private ListNode reverse(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {

        ReverseLinked linkedListCycle = new ReverseLinked();

        List<Integer> lists = Arrays.asList(2, 3, 4, 5);

        ListNode head = new ListNode(1);

        for (Integer value : lists) {
            head.add(value);
        }

        System.out.println(head.sout());
        ListNode reverse = linkedListCycle.reverse(head);
        System.out.println(reverse.sout());

    }

}
