package code.logic.offer;

public class O10 {
    public int fib(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int first = 0;
        int secord = 1;
        for (int i=1; i<n; i++) {
            int sum = (first +secord)%1000000007;
            first = secord%1000000007;
            secord = sum%1000000007;

        }

        return secord;

        //return (fib(n-1) + fib(n-2))%1000000007;


    }
}
