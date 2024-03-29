package code.leetcode.editor.cn;
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？ 
// Related Topics 数组 哈希表 
// 👍 15793 👎 0


import java.util.*;

/**
 * 两数之和
 *
 * @author changjiale
 */
public class P1_TwoSum{
    public static void main(String[] args) {

        Solution solution = new P1_TwoSum().new Solution();
        int[] ints = solution.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(ints);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                List<Integer> integers = map.getOrDefault(nums[i], new ArrayList<>());
                integers.add(Integer.valueOf(i));
                map.put(nums[i], integers);
            }
            for (Integer num : nums) {
                Integer diff = target - num;
                if (diff.equals(num) && !Objects.isNull(map.get(diff)) && map.get(diff).size() == 2) {
                    return map.get(diff).stream().mapToInt(Integer::intValue).toArray();
                } else if (diff.equals(num) && !Objects.isNull(map.get(diff)) && map.get(diff).size() != 2) {
                    continue;
                }
                if (!Objects.isNull(map.get(num)) && !Objects.isNull(map.get(diff)) && map.get(num).size() == 1 && map.get(diff).size() == 1) {

                    return new int[]{map.get(num).get(0), map.get(diff).get(0)};
                }
            }

            return null;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
