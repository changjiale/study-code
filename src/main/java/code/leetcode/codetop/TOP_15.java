package code.leetcode.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 * //思路: 排序 + 双指针 + 剪枝
 */
public class TOP_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);

        for(int i=0; i< nums.length; i++) {


            if (nums[i] > 0) {
                break;
            }

            if (i >0 &&nums[i] == nums[i-1]) { //结果重复 去重
                continue;

            }
            int l = i+1;
            int r = len-1;
            while (l < r) {
                int sum = nums[i] +nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i] ,nums[l] , nums[r]));
                    //去重
                    while (l<r && nums[l] == nums[l+1]) {
                        l++;
                    }

                    while (l<r && nums[r] == nums[r+1]) {
                        r--;
                    }
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        List<List<Integer>> lists = new TOP_15().threeSum(nums);
        System.out.println(lists);
    }



}
