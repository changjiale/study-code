package code.find;

import code.sort.HeapSort;
import code.sort.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二分查找
 */
public class BinarySearch {

    public static boolean binarySearch(int[] arr, int value) {

        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int middle = start + (end - start)/2;
            if (arr[middle] == value) {
                return true;
            } else if (arr[middle] > value) {
                end  = middle - 1;
            } else if (arr[middle] < value) {
                start = middle + 1;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int[] arr = {5, 1, 6, 2, 8, 3};
        HeapSort.sort(arr);
        boolean ret = binarySearch(arr, 8);
        System.out.println(ret);

    }
}
