package code.leetcode.codetop;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class TOP20 {

    private static final Map<Character, Character> map = new HashMap<Character, Character>() {
        {
           put('(', ')');
           put('[', ']');
           put('{', '}');
        }
    };

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<s.length(); i++) {

            if (!stack.empty()) {
                if (stack.peek() == '(' && s.charAt(i) == ')') {
                    stack.pop();
                } else if (stack.peek() == '[' && s.charAt(i) == ']') {
                    stack.pop();
                } else if (stack.peek() == '{' && s.charAt(i) == '}') {
                    stack.pop();
                } else {
                    stack.add(s.charAt(i));
                }
            } else {
                stack.add(s.charAt(i));
            }
        }

        return stack.empty();

    }

}
