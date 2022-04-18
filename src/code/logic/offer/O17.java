package code.logic.offer;

public class O17 {
    public int[] printNumbers(int n) {
        int ret = 1;
        while (n > 0) {
            n--;
            ret *= 10;
        }

        int[] resp = new int[ret-1];
        for (int i=1; i< ret; i++) {
            resp[i-1] = i;
        }


        return resp;

    }
}
