package code.leetcode.codetop;

/**
 * 234. 回文链表
 * 简单
 * 1.6K
 * 相关企业
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：false
 */
public class TOP_234 {

    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMiddleNode(head);
        ListNode head2 = reverseListNode(mid);
        // 判断回文
        while (head != null && head2 != null){
            if (head.value != head2.value){
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    // 中间节点
    public ListNode findMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 反转链表
    public ListNode reverseListNode(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
