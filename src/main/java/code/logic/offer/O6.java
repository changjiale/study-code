package code.logic.offer;

import java.util.ArrayList;
import java.util.List;

public class O6 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list=new ArrayList<>();
        int index = 0;
        while (head!=null) {
            list.add(head.val);
            head = head.next;
            index++;
        }

        int[] list2=new int[index];
        for (int i=list.size()-1; i>=0; i--) {
            list2[index-i-1] = list.get(i);
        }



        return list2;



    }
}
