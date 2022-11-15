package code.logic.offer;

import java.util.HashSet;
import java.util.Set;

public class O3 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ret = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                ret = num;
                break;
            }
        }
        return ret;
    }
}
