package code.logic.offer;

public class O14 {

    /**
     * 这题用动态规划是比较好理解的
     *
     * 我们想要求长度为n的绳子剪掉后的最大乘积，可以从前面比n小的绳子转移而来
     * 用一个dp数组记录从0到n长度的绳子剪掉后的最大乘积，也就是dp[i]表示长度为i的绳子剪成m段后的最大乘积，初始化dp[2] = 1
     * 我们先把绳子剪掉第一段（长度为j），如果只剪掉长度为1，对最后的乘积无任何增益，所以从长度为2开始剪
     * 剪了第一段后，剩下(i - j)长度可以剪也可以不剪。如果不剪的话长度乘积即为j * (i - j)；如果剪的话长度乘积即为j * dp[i - j]。取两者最大值max(j * (i - j), j * dp[i - j])
     * 第一段长度j可以取的区间为[2,i)，对所有j不同的情况取最大值，因此最终dp[i]的转移方程为
     * dp[i] = max(dp[i], max(j * (i - j), j * dp[i - j]))
     * 最后返回dp[n]即可
     */
    public int cuttingRopeV1(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i=2; i<=n; i++) {
            for (int j=0; j< i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i-j), j*dp[i-j]));
            }
        }
        return dp[n];

    }

    /**
     *根据数学大佬推到， 将绳子根据3 做分段， 即可取乘机最大   最后一段如果为4 不分
     * @param n
     * @return
     *
     * 注意整数乘机 用long  int 不够存
     */
    public int cuttingRopeV2(int n) {
        if (n<4) {
            return n-1;
        }
        long ret = 1;
        while (n > 4) {
            ret = ret * 3 % 1000000007;
            n -= 3;
        }

        return (int)(ret * n % 1000000007);

    }


    public static void main(String[] args) {

        //状态转移方程
        //dp[i] = Math.max(dp[i], Math.max(j * (i-j), j*dp[i-j]));
        O14 o14 = new O14();
        System.out.println(o14.cuttingRopeV1(10));

    }
}
