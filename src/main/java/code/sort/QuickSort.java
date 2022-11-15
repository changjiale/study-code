package code.sort;

import com.sun.tools.classfile.ConstantPool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 快速排序的时间复杂度为O(nlogn)，空间复杂度为O(n)
 */


public class QuickSort {


    private void quickSort(int[] arr, int start, int end) {
        if (start >=0 && end <= arr.length-1 && start < end) {
            int i = start;
            int j = end;
            int flag = arr[i];
            while (i < j) {
                while (arr[j] >= flag && i < j) {
                    j--;
                }

                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }

                while (arr[i] < flag && i<j) {
                    i++;
                }

                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }

                arr[i] = flag;
            }
            quickSort(arr, start, i-1);
            quickSort(arr, i+1, end);
        }
    }

    private void quickSortV2(int[] arr, int start, int end) {
        if (start >=0 && end <= arr.length-1 && start < end) {
            int i = start;
            int j = end;
            int flag = arr[i];
            while (i < j) {
                while (arr[j] >= flag && i < j) {
                    j--;
                }

                while (arr[i] <= flag && i<j) {
                    i++;
                }

                if (i < j) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }

            if (i == j) {
               arr[start] = arr[i];
               arr[i] = flag;
            }

            quickSort(arr, start, i-1);
            quickSort(arr, i+1, end);
        }
    }

    private void quickSort(int[]arr) {

        quickSortV2(arr, 0, arr.length-1);
    }

    public static void main(String[] args) {

//        int arr[] = {2, 4, 5, 8,1, 3};
        int arr[] = {2, 2, 5, 8,1, 1};
        System.out.println(Arrays.toString(arr));
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
