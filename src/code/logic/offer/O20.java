package code.logic.offer;

public class O20 {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0)
            return false;
        s = s.trim();
        char[] chars = s.toCharArray();

        boolean numIsOk = false;
        boolean eIsOk = false;
        boolean doIsOk = false;
        for (int i=0; i < chars.length; i++) {
            if (chars[i] == '+' || chars[i] == '-') {
                if (!(i==0 || (chars[i-1]=='e' || chars[i-1]=='E'))) {
                    return false;
                }
            } else if (chars[i] >= '0' && chars[i] <= '9'){
                numIsOk = true;
            } else if ((chars[i]=='e' || chars[i]=='E') && numIsOk && !eIsOk) {
                eIsOk = true;
                numIsOk = false;
            } else if (chars[i]=='.' && !eIsOk && !doIsOk ){
                doIsOk = true;
            } else {
                return false;
            }
        }

        return numIsOk;

    }
}
