package code.logic.offer;

public class O11 {
    public int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (numbers[end] > numbers[mid]) {
                end = mid;
            } else if (numbers[end] < numbers[mid]) {
                start = mid + 1;
            } else {
                end =end -1;
            }
        }
        return numbers[start];
    }


}
