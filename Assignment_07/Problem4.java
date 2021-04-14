package Assignment_07;

import java.util.Arrays;

public class Problem4 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        boolean result = Arrays.equals(array1, array2);
        return result;
    }
}
