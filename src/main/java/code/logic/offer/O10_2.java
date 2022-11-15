package code.logic.offer;

public class O10_2 {
    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a % 1000000007 + b % 1000000007) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
