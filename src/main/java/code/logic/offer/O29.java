package code.logic.offer;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

public class O29 {
    public int[] spiralOrder(int[][] matrix) {

        if(matrix.length == 0) return new int[0];


        int l = 0;
        int r = matrix[0].length-1;
        int t = 0;
        int b = matrix.length-1;

        int[] ret = new int[(r+1)*(b+1)];

        int x = 0;

        while (true) {
            //右移
            for (int i=l; i<=r; i++) {
                ret[x++] = matrix[t][i];
            }
            t++;

            if (t > b) {
                break;
            }

            //下移
            for (int i=t; i<=b; i++) {
                ret[x++] = matrix[i][r];
            }
            r--;

            if (r < l) {
                break;
            }

            //左移
            for (int i=r; i>=l; i--) {
                ret[x++] = matrix[b][i];
            }
            b--;
            if (b < t) {
                break;
            }


            //上移
            for (int i=b; i>=t; i--) {
                ret[x++] = matrix[i][l];
            }
            l++;

            if (l > r) {
                break;
            }


        }

        return ret;
    }
}
