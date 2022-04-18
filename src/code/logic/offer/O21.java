package code.logic.offer;

public class O21 {


    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while (i < j) {
            while (i < j && nums[i] % 2 == 1)
                i++;
            while (i < j && nums[j] % 2 == 0)
                j--;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        return nums;
    }
}
