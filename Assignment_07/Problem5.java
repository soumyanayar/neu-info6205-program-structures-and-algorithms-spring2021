package Assignment_07;

public class Problem5 {
    public String longestCommonPrefix(String[] string) {
        if (string.length == 0) {
            return "";
        }
        String pre = string[0];
        for (int i = 0; i < string.length; i++) {
            while (string[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
                if (pre.isEmpty()) {
                    return "";
                }
            }
        }
        return pre;
    }
}
