package code.leetcode.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 中等
 * 8.9K
 * 相关企业
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class TOP_3 {

    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return 0;
        }

        int max = 0;
        int left = 0;
        Map<Character, Integer> map= new HashMap<>();
        for(int i = 0; i < s.length(); i ++){
            if (map.containsKey(chars[i])) {
                left = Math.max(left, map.get(chars[i])+1);
            }

            map.put(chars[i],i);
            max = Math.max(max, i-left+1);

        }

        return max;
    }



    //暴力
    public int lengthOfLongestSubstring_simple(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return 0;
        }

        int len = 0;
        int max = 1;
        Map<Character, Integer> map= new HashMap<>();
        for (int i = 0; i< chars.length;i++) {
            for (int j = i; j < chars.length; j++) {
                char aChar = chars[j];
                if (!map.containsKey(aChar)) {
                    map.put(aChar, 1);
                    len++;
                } else {
                    map= new HashMap<>();
                    max = Math.max(max, len);
                    len = 0;
                    break;
                }
            }
        }


        return max;

    }



    public static void main(String[] args) {
        new TOP_3().lengthOfLongestSubstring_simple("jbpnbwwd");

    }

}
