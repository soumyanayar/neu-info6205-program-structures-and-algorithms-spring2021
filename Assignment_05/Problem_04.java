package Assignment_05;

import java.util.*;

public class Problem_04 {
    public static String reorganizeString(String S) {
        Map<Character, Integer> unSortedMap = new HashMap<>();
        for (char c : S.toCharArray()) {
            if (unSortedMap.containsKey(c)) {
                unSortedMap.put(c, unSortedMap.get(c) + 1);
            } else {
                unSortedMap.put(c, 1);
            }
        }

        LinkedHashMap<Character, Integer> sortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        int highestFrequency = sortedMap.entrySet().stream().findFirst().get().getValue();

        if (highestFrequency > (S.length() + 1) / 2) {
            return "";
        }

        char[] output = new char[S.length()];
        int index = 0;
        for (Map.Entry mapElement : sortedMap.entrySet()) {
            char key = (Character) mapElement.getKey();
            int value = (Integer) mapElement.getValue();

            for (int k = 0; k < value; ++k) {
                output[index] = key;
                index += 2;

                if (index >= output.length) {
                    index = 1;
                }
            }
        }
        return String.valueOf(output);
    }

    public static void main(String[] args) {
        String array = "aab";
        String result = reorganizeString(array);
        System.out.println(result);

    }
}
