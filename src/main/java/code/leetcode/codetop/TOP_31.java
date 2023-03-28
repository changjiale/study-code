package code.leetcode.codetop;

/**
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class TOP_31 {

    /**
     * 没意义 不写了
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        //1. 1,2,3 ==> 1,3,2
        //1. 倒序遍历, 找到第一个数, 这个数比后面的数小;
        //2. 继续倒序遍历, 找到一个比上面的数大的数;
        //3. 交换
        //4. 把1中的这个数后面的数全部递增排列, 因为在1后面的数时递减排列的, 所以首尾交换即可获得升序排列
        int len = nums.length;
        int i = len - 2; //i = len - 2 是为了防止下面nums[i + 1]越界!

        //1. 倒序遍历, 找到第一个数, 这个数比后面的数小;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) break;
            --i;
        }

        //2. 继续倒序遍历, 找到一个上面的数大的数
        if (i >= 0) {
            int j = len - 1;
            while (j >= 0) {
                if (nums[j] > nums[i]) break;
                --j;
            }
            //3. 交换i和j
            swap(nums, i, j); //交换i和j的位置
        }

        //4. 将 i后面的数升序排列, 只需要对撞双指针交换即可(因为i后面的数时降序的)
        reverse(nums, i + 1, len - 1);
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            ++left;
            --right;
        }
    }
}
