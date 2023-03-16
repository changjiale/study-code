package code.sort;

/**
* 最坏，最好，平均时间复杂度均为O(nlogn)，它也是不稳定排序
*
* 1. 构建起始大根堆
* 2. 循环开始
* 3. 交换跟节点和最后一个节点的位置
* 4. 排除当前最后一个节点， 其余节点继续构建大根堆
* 5. 知道全部堆重复以上操作完成
* */

import java.util.Arrays;

/**
 * 最后一个根节点 位置 ar.length/2 -1
 * 如果根节点下标为i 则两个子节点位置 [2i+1]  [2i+2]
 */
public class HeapSort {


    public static void sort(int []arr){

        //构建初始初始大根堆
        //从第一个非叶子结点从下至上，从右至左调整结构
        for (int i=arr.length/2-1; i>=0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for(int j=arr.length-1;j>0;j--){
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }


    }

    //调整节点
    public static void adjustHeap(int []arr, int i, int length){
        //当前堆的根节点
        int tmp = arr[i];
        for (int j=2*i+1;j <length; j=2*j+1) {
            //判断右子节点是否大于左子节点， 如果是则 需要交换 或者右子节点即可
            if (j+1<length && arr[j+1] > arr[j]) {
                j++;
            }

            if (arr[j] > tmp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = tmp;
    }

    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {5, 1, 6, 2, 8, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     *          5(0)
     *     1(1)       6(2)
     *  2(3)  8(4)  3(5)   (6)
     * (7)
     *
     *排序逻辑  先从最后一个有叶子节点的根（n/2-1）开始构建 初始根堆
     *
     * 将排序好的大根堆 顶部 移动到尾部
     * 再次构建大根堆
     * 循环
     */

}
