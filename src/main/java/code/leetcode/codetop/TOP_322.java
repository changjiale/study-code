package code.leetcode.codetop;

/**
 * 322. 零钱兑换
 * 中等
 * 2.4K
 * 相关企业
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 */
public class TOP_322 {

    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }

        findWay(coins,amount,0);

        // 如果没有任何一种硬币组合能组成总金额，返回 -1。
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

    public void findWay(int[] coins,int amount,int count){
        if(amount < 0){
            return;
        }
        if(amount == 0){
            res = Math.min(res,count);
        }

        for(int i = 0;i < coins.length;i++){
            findWay(coins,amount-coins[i],count+1);
        }
    }
}
