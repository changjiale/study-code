package code.leetcode.codetop;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 46. 全排列
 * 中等
 * 2.5K
 * 相关企业
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class TOP_46 {

    public List<List<Integer>> permute(int[] nums) {
        boolean[]visted  = new boolean[nums.length];
        int len = nums.length;
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> path = new ArrayList<>(nums.length);
        execute(nums, visted, 0, len, path, ret);
        return null;

    }

    public void execute(int[] nums, boolean[] visted, int dep, int len, List<Integer> path, List<List<Integer>> ret) {

        if (len == dep) {
            ret.add(path);
            return;
        }
        for (int i=0; i<len; i++) {

            if (!visted[i]) {

                path.add(nums[i]);

                visted[i] = true;
                execute(nums, visted, dep+1, len, path, ret);
                visted[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
