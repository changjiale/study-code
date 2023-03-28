package code.leetcode.codetop;

import java.util.Arrays;

/**
 * 169. 多数元素
 * 简单
 * 1.7K
 * 相关企业
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 */
public class TOP_169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }
}

