package code.logic.offer;


//判断是否是镜像树
public class O28 {
    public boolean isSymmetric(TreeNode root) {

        if(root == null) {
            return true;
        }

        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode left, TreeNode right) {
        //边界

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }


        return left.val == right.val && recur(left.left, right.right) && recur(left.right, right.left);

    }


}
