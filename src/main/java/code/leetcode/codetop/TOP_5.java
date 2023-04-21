package code.leetcode.codetop;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class TOP_5 {

    public String longestPalindrome(String s) {
        String res ="";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j=i+1; j<=s.length(); j++) {
                String substring = s.substring(i, j);
                if (isP(substring) && substring.length() > max) {
                    max = Math.max(max, substring.length());
                    res = substring;
                }
            }
        }
        return res;
    }


    public boolean isP(String s) {
        for (int i=0; i<s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }


}
