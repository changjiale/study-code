package code.leetcode.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 *
 *
 * 示例 1:
 *
 *
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 *
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 */
public class TOP_105 {


    int[] preorder;

    Map<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        //记录中序遍历下标
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return findNode(0, 0, inorder.length-1);
    }

    public TreeNode findNode(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);
        int index = inMap.get(preorder[root]);
        node.left =findNode(root+1, left, index - 1);
        node.right=findNode(root + index -left+1 ,index +1, right);
        return node;
    }


}
