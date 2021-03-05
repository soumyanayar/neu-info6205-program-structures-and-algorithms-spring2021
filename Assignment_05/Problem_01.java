package Assignment_05;

import java.util.*;

public class Problem_01 {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - 1;
        while (end - start >= k) {
            if (Math.abs(arr[start] - x) > Math.abs(arr[end] - x)) {
                start++;
            } else {
                end--;
            }
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void display(List<Integer> list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = { 2, 5, 8, 9, 12, 13 };
        int k = 3;
        int x = 10;
        List<Integer> result = findClosestElements(array, k, x);
        display(result);

    }
}
