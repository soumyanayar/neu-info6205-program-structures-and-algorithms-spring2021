import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Problem3 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        // BFS Approach
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int q = 0; q < size; q++) {
                char[] cur = queue.poll().toCharArray();
                for (int i = 0; i < cur.length; i++) {
                    char tmp = cur[i];
                    for (char chr = 'a'; chr <= 'z'; chr++) {
                        cur[i] = chr;
                        String dest = new String(cur);
                        if (dict.contains(dest)) {
                            if (dest.equals(endWord))
                                return level + 1;
                            queue.add(dest);
                            dict.remove(dest);
                        }
                    }
                    cur[i] = tmp;
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] agrs) {
        Problem3 problem3 = new Problem3();

        // Test Case 1
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("the number of words in the shortest transformation sequence from " + beginWord + " to "
                + endWord + ": " + problem3.ladderLength(beginWord, endWord, wordList));

        // Test Case 2
        beginWord = "hit";
        endWord = "cog";
        wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println("the number of words in the shortest transformation sequence from " + beginWord + " to "
                + endWord + ": " + problem3.ladderLength(beginWord, endWord, wordList));
    }
}
