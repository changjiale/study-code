package code.leetcode.codetop;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class TOP_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0); // 虚拟头节点
        dummyHead.next = head;
        ListNode fastIndex = dummyHead;
        ListNode slowIndex = dummyHead;
        // 快慢指针相差n步,快指针先走n步
        for (int i = 0; i < n; i++) {
            fastIndex = fastIndex.next;
        }
        // 然后快慢指针同时移动，当快指针走到链表尾部时停止
        while (fastIndex.next != null) {
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }
        // 这时慢指针移动到了需要删除结点的前一个结点
        slowIndex.next = slowIndex.next.next;
        return dummyHead.next;
    }

}
