package code.logic.offer;

public class O5 {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuffer buff = new StringBuffer();

        for (int i=0; i<chars.length; i++) {
            if (chars[i] == ' ') {
                buff.append("%20");
            } else {
                buff.append(chars[i]);
            }
        }



        return buff.toString();

    }
}
