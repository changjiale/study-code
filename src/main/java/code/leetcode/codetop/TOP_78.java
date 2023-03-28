package code.leetcode.codetop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 78. 子集
 * 中等
 * 2K
 * 相关企业
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class TOP_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> stack=new ArrayList<>();
        dfs(nums,0,nums.length,stack,res);
        return res;
    }
    public void dfs(int[] nums,int index,int len,List<Integer> stack,List<List<Integer>> res){
        //遍历结束将子集添加搭配集合
        if(index == len){
            res.add(new ArrayList<>(stack));
            return;
        }
        //不选，进入下一层
        dfs(nums,index+1,len,stack,res);
        stack.add(nums[index]);
        //选，进入下一层
        dfs(nums,index+1,len,stack,res);
        stack.remove(stack.size()-1);
    }


}
/**0 []  []
 *0  [[]] [1]
 *1  [[], [1]] [1, 2]
 *2 [[], [1], [1, 2]] [1,2,3]
 *3 [[], [1, 2], [1,2, 3]] [1, 2, 3]
 *2 [[], [1, 2], [1,2, 3]] [1, 2]
 *3 []
 */
