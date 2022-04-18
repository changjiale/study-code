package code.logic.offer;


import java.util.HashMap;
import java.util.Map;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class O26 {

    private Map<Integer, Integer> innMap;

    //判断是否是子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (judge(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean judge(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null || A.val != B.val) {
            return false;
        }

        return judge(A.left, B.left) && judge(A.right, B.right);
    }





    //重建二叉树
    public TreeNode buildTree(int[] preList, int[] innList) {

        innMap = new HashMap<>();
        for (int i = 0; i < innList.length; i++) {
            innMap.put(innList[i], i);
        }

        return findNode(preList, innList, 0, 0, innList.length-1);
    }

    public TreeNode findNode(int[] preList, int[] innList, int root, int left , int right) {
        if (left > right) {
            return null;
        }

        int rootNode = preList[root];
        TreeNode treeNode = new TreeNode(rootNode);

        int innRootIndex = innMap.get(rootNode);

        treeNode.left = findNode(preList, innList, root+1, left, innRootIndex-1);

        // root  + 左串长度 + 1
        treeNode.right = findNode(preList, innList,  root+ innRootIndex-left +1, innRootIndex+1 , right);

        return treeNode;

    }



    public void preSout(TreeNode root) {
        System.out.println(root.val);
        if (root.left != null) {
            preSout(root.left);
        }
        if (root.right != null) {
            preSout(root.right);
        }
    }




    //1. 先根据 先序遍历 + 中序遍历 构建二叉树
    //2. 再根据两颗数  来判断是否是子结构

    public static void main(String[] args) {

        O26 o26 = new O26();
        int[] preorder = {3, 9, 20 , 15, 7};
        int[] inorder = {9, 3 , 15 ,20 ,7};
        TreeNode treeNode = o26.buildTree(preorder, inorder);
        o26.preSout(treeNode);


        int[] preorder_2 = {20 , 15, 7};
        int[] inorder_2 = {15 ,20 ,7};
        TreeNode treeNode_2 = o26.buildTree(preorder_2, inorder_2);
        boolean subStructure = o26.isSubStructure(treeNode, treeNode_2);
        System.out.println(subStructure);


    }

}
