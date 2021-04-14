package Assignment_07;

public class Problem2 {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        char[] a = s.toCharArray();
        int n = s.length();
        reverse(a, 0, n - 1);
        reverseCharactersInWord(a, n);
        return cleanWhiteSpaces(a, n);
    }

    private void reverse(char[] a, int i, int j) {
        char temp;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    private void reverseCharactersInWord(char[] a, int n) {
        int i = 0;
        int j = 0;
        while (i < n) {
            while (i < j || i < n && a[i] == ' ') {
                ++i;
            }
            while (j < i || j < n && a[j] != ' ') {
                ++j;
            }
            reverse(a, i, j - 1);
        }
    }

    private String cleanWhiteSpaces(char[] a, int n) {
        int i = 0;
        int j = 0;
        while (true) {
            while (j < n && a[j] == ' ') {
                ++j;
            }
            while (j < n && a[j] != ' ') {
                a[i++] = a[j++];
            }
            while (j < n && a[j] == ' ') {
                ++j;
            }
            if (j < n) {
                a[i++] = ' ';
            } else {
                break;
            }
        }
        return String.valueOf(a).substring(0, i);
    }
}
