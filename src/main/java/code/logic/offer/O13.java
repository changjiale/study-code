package code.logic.offer;

/**
 * 机器人运动范围   范围从坐标 [0,0] 到坐标 [m-1,n-1]  从坐标 [0, 0]  开始移动，但不能进入行坐标和列坐标的数位之和大于k的格子
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19
 */
public class O13 {
    public static int movingCnt(int m, int n ,int k) {
        boolean[][] visited= new boolean[m][n];
        int dfs = dfs(m, n, k, visited, 0, 0);
        return dfs;
    }


    public static int dfs(int m, int n, int k, boolean[][] visited, int i, int j) {
        if (i >=m || i<0 || j>=n || j<0 || sumNum(i) + sumNum(j) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int step = 1 + dfs(m, n, k, visited, i+1, j) + dfs(m, n, k, visited, i, j+1)  + dfs(m, n, k, visited, i-1, j) + dfs(m, n, k, visited, i, j-1);
        return step;

    }

    public static int sumNum(int num) {
        int ret = 0;
        while (num > 0) {
            ret = ret + num%10;
            num = num /10;
        }
        return ret;
    }



    public static void main(String[] args) {
        int cnt = movingCnt(3, 1, 0);
        System.out.println(cnt);


    }

}
