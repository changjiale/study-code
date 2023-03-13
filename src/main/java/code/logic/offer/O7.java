package code.logic.offer;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 */

/**
 * 构建左右子树： 开启左右子树递归；
 * 根节点索引	中序遍历左边界	中序遍历右边界
 * 左子树	root + 1	left	i - 1
 * 右子树	i - left + root + 1	i + 1	right
 * tips: 右子树的跟节点 公式： 根节点下标+左子树长度+1   即先序遍历 左子树最后一个节点下标+1
 *
 */
public class O7 {


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

    public void preSout(TreeNode root) {
        System.out.print(root.val + " ");
        if (root.left != null) {
            preSout(root.left);
        }
        if (root.right != null) {
            preSout(root.right);
        }
    }
    public void midSout(TreeNode root) {
        if (root.left != null) {
            preSout(root.left);
        }
        System.out.print(root.val + " ");
        if (root.right != null) {
            preSout(root.right);
        }
    }
    public void endSout(TreeNode root) {
        if (root.left != null) {
            preSout(root.left);
        }
        if (root.right != null) {
            preSout(root.right);
        }
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {


        O7 o7 = new O7();
        int[] preorder = {3, 9, 20 , 15, 7};
        int[] inorder = {9, 3 , 15 ,20 ,7};
        TreeNode treeNode = o7.buildTree(preorder, inorder);
        o7.preSout(treeNode);

    }
}
