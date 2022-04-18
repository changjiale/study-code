package code.logic.offer;

public class O16 {
    public double myPow(double x, int n) {
        if(x == 0) return 0;


        //神坑 最后一个case 2.00000  -2147483648  超过int最大值 要强制转long
        long b = n;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }

        double res = 1.0;
        while(b > 0) {
            if((n & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }

        return res;



    }
}
