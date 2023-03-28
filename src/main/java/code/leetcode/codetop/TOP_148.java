package code.leetcode.codetop;

/**
 *给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class TOP_148 {

    public ListNode sortList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode headI = head;

        ListNode headJ = head;
        int i= 0;
        int j = 0;
        while (headI != null) {
            headJ = headI.next;
            j = i+1;
            while (headJ != null) {
                if (headI.value > headJ.value) {
                    //保存 headJ的前驱节点和后记节点
                    Integer tmp = headI.value;
                    headI.value = headJ.value;
                    headJ.value = tmp;
                }
                headJ = headJ.next;
                j++;
            }
            headI = headI.next;
            i++;
        }

        return head;
    }
}
