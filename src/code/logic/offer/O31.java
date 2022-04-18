package code.logic.offer;


//输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//        输出：true
//        解释：我们可以按以下顺序执行：
//        push(1), push(2), push(3), push(4), pop() -> 4,
//        push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


import java.util.Stack;

public class O31 {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.empty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }

        }


        return stack.empty();
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] poped = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed, poped));
    }
}
