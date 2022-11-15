package code.logic.offer;

public class O30 {

    private O30Node head;
//    /** initialize your data structure here. */
//    public O30Node() {
//    }

    public void push(int x) {
        if (head == null) {
            head = new O30Node(x, x, null);
        } else {
            head = new O30Node(x, Math.min(x, head.min), head);
        }

    }
    public void pop() {
        head = head.next;

    }

    public int top() {
        return head.val;

    }

    public int min() {
        return head.min;
    }

}

class O30Node {

    int val;
    int min;
    O30Node next;

    public O30Node(int val, int min, O30Node next) {

        this.val = val;
        this.min = min;
        this.next = next;
    }
}
