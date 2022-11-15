package code.sort;

import java.util.Arrays;


/**
 * 排序算法	平均时间复杂度	最坏时间复杂度	空间复杂度	是否稳定
 * 冒泡排序	O（n2）O（n2）	O（n2）O（n2）	O（1）O（1）	是
 * 选择排序	O（n2）O（n2）	O（n2）O（n2）	O（1）O（1）	不是
 * 直接插入排序	O（n2）O（n2）	O（n2）O（n2）	O（1）O（1）	是
 * 归并排序	O(nlogn)O(nlogn)	O(nlogn)O(nlogn)	O（n）O（n）	是
 * 快速排序	O(nlogn)O(nlogn)	O（n2）O（n2）	O（logn）O（logn）	不是
 * 堆排序	O(nlogn)O(nlogn)	O(nlogn)O(nlogn)	O（1）O（1）	不是
 * 希尔排序	O(nlogn)O(nlogn)	O（ns）O（ns）	O（1）O（1）	不是
 * 计数排序	O(n+k)O(n+k)	O(n+k)O(n+k)	O(n+k)O(n+k)	是
 * 基数排序	O(N∗M)O(N∗M)	O(N∗M)O(N∗M)	O(M)O(M)	是
 */

public class SimpleSort {

    public static void sortV1(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

    }

    public static void sortV2(int[] arr) {

        for (int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }

    }



//    public static void main(String[] args) {
//        int[] arr = {5, 1, 6, 2, 8, 3};
//        sortV2(arr);
//        System.out.println(Arrays.toString(arr));
//    }

    /**
     * get请求串转换为post请求串
     * @param url
     * @return
     */
    public static String getConvertPost(String url){
        StringBuffer sb = new StringBuffer();
        String jsonStart = "{\"parameter\":{";//json字符串头
        String jsonEnd = "}}";//json字符串尾
        String args [] = url.split("&");//按分割
        sb.append(jsonStart);
        for(String arg:args){
            if(arg.indexOf("=")!=-1){
                //对start及rows字段值特殊处理
                if(arg.indexOf("start")!=-1 ||arg.indexOf("rows")!=-1){
                    String s1 ="\""+arg.substring(0,arg.indexOf("="))+"\":";
                    String s2 = arg.substring(arg.indexOf("=")+1)+",";
                    sb.append(s1).append(s2);
                }else {//常规处理
                    String s3 ="\""+arg.substring(0,arg.indexOf("="))+"\":";
                    String s4 = "\""+arg.substring(arg.indexOf("=")+1)+"\",";
                    sb.append(s3).append(s4);
                }
            }
        }
        int strlength = sb.length();
        sb.delete(strlength-1,strlength);//删除最后一位(逗号)
        sb.append(jsonEnd);
        return sb.toString();
    }

    public static void main(String [] args){
        String str ="wsgsig=dd03-TQcGcL4gyXsAk82Z%2FI4yNHCCS0C0%2FQkyix7j4ZDFS0CGloAmq2nW%2BHJdxnsGl8Iwk63QL1bbwmpFtJFqjPbk%2BTcCOnz9q%2BAOU5%2BsM1Ggznpck8ZZUZts4YzFzXU&id=111&phone=1111&cities=1&cities=2&leadsType=1&createCp=111&createStore=1111&createSales=222&transactionCp=222&transactionStore=222&transactionSales=22&leadsStatusId=4&followStatusId=10&bizScope=1&forbidStatus=0&lockStatus=0&createTimeStart=2022-02-11%2015%3A05%3A22&createTimeEnd=2022-02-12%2015%3A05%3A22&page=1&size=10";
        String result = getConvertPost(str);
        System.out.println(result);


    }

}
