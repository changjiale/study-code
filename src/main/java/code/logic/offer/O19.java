package code.logic.offer;

public class O19 {
    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();
        //边界终止逻辑
        if (n==0) {
            return m==0;
        }

        boolean isMatch = (m >0 && (s.charAt(0)==p.charAt(0) || p.charAt(0) == '.'));

        //如果可以匹配 就往下走递归

        if ( p.length() >= 2 && p.charAt(1) == '*') {
            //如果出现*  两种情况  >=1 次   || 0次
            return (isMatch && isMatch(s.substring(1), p) )  || isMatch(s, p.substring(2));

        } else {
            return isMatch  &&  isMatch(s.substring(1), p.substring(1));
        }
    }
}
