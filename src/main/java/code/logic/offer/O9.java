package code.logic.offer;

import java.util.Stack;

public class O9 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public O9() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);

    }

    public int deleteHead() {
        if (stack2.empty()) {
            if (stack1.empty()) {
                return -1;
            }
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }

        }
        return stack2.pop();
    }
}
