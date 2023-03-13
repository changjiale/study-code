package code.leetcode.codetop;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }

    void add (int value) {
        ListNode newNode = new ListNode(value);
        if(this.next == null)
            this.next = newNode;
        else
            this.next.add(value);
    }

    String sout() {
        StringBuffer buffer = new StringBuffer();
        ListNode node = this;
        while(node!= null) {
            buffer.append(node.value);
            buffer.append("->");
            node = node.next;
        }
        buffer.append("NULL");
        return buffer.toString();
    }
}
