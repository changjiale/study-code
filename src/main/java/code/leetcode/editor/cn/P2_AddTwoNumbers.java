package code.leetcode.editor.cn;
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 8904 👎 0

import java.util.Arrays;
import java.util.List;

/**
 * 两数相加
 *
 * @author changjiale
 */
public class P2_AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new P2_AddTwoNumbers().new Solution();

        List<Integer> listL1 = Arrays.asList(9,9,9,9,9,9,9);
        ListNode l1 = buildNode(listL1);
        List<Integer> listL2 = Arrays.asList(9,9,9,9);
        ListNode l2 = buildNode(listL2);
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        listNode.sout();


    }

    private static ListNode buildNode(List<Integer> lists) {
        ListNode head = new ListNode(lists.get(0));

        for (int i = 1; i < lists.size(); i++) {
            head.add(lists.get(i));
        }

        return head;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode listNode = new ListNode();
            ListNode head = listNode;
            int next = 0;
            int index = 0;
            while (l1 != null || l2 != null) {

                int sum = 0;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }

                ListNode tmp = new ListNode();
                sum = sum + next;
                int diff = sum - (sum/10)*10;
                tmp.val = diff;

                next = sum / 10;

                listNode.next = tmp;


                index += 1;
                listNode = listNode.next;
            }

            if (next > 0) {
                ListNode tmp = new ListNode();
                tmp.val = next;
                listNode.next = tmp;
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

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

