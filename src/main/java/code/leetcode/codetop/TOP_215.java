package code.leetcode.codetop;

import java.util.Random;

/**  数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class TOP_215 {

    public int findKthLargest(int[] nums, int k) {

        return heapSelect(nums);
        // return quickSelect(nums, 0, nums.length - 1, nums.length - k);  快排解法
    }

    public int heapSelect(int[] arr) {

        //构建初始大根堆
        for (int i=arr.length-1; i>=0; i--) {
            buidHead(arr, i, arr.length);
        }

        //重复构建

        for(int j=arr.length-1;j>0;j--){
            //将根移动到尾部
            swap(arr, 0, j);
            buidHead(arr, 0, j);

            //重新将剩余节点构建根堆
        }


        return 0;
    }

   public void buidHead(int[] arr, int index, int length) {
        int root = arr[index];
        //获取子节点  2i+1 2i+2
       for (int i=2*index+1; i<length; i=2*i+1) {
           if (i+1<length && arr[i+1] > arr[i]) {
               i++;
           }

           if (arr[i] > root) {
               arr[i] = root;
               index = i;
           } else {
               break;
           }
       }

       arr[index] = root;

    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }




    public int quickSelect(int[] a, int l, int r, int index) {
        if (l > 0 && r <= a.length-1 && l <=r) {
            int i = l;
            int j = r;
            int flag = a[i];
            while(i < j) {
                if (a[j] >= flag && i<j) {
                    j--;
                }
                if (a[i] <flag && i<j) {
                    i++;
                }

                if (i < j) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }


            if (i == j) {
                a[l] = a[i];
                a[i] = flag;
            }

            if(i == index) {
                return a[index];
            } else {
                if(index > i) {
                    return quickSelect(a, i+1, r, index);
                } else {
                    return quickSelect(a, l, i - 1, index);
                }
            }
        }

        return 0;

    }



    public static void main(String[] args) {

        int[] arr = {1, 2, 3 ,4};

    }
}
