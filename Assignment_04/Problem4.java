package Assignment_04;

import java.util.*;

class Problem4 {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        int largest = A.length;
        for (int i = 0; i < A.length; i++) {
            int index = find(A, largest);
            flip(A, index);
            flip(A, largest - 1);
            result.add(index + 1);
            result.add(largest--);
        }
        return result;
    }

    private int find(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private void flip(int[] A, int index) {
        int i = 0, j = index;
        while (i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            ++i;
            --j;
        }
    }

    private void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        int[] array = { 3, 2, 4, 1 };
        System.out.println("Array before pancake sorting...");
        problem4.printArray(array);
        List<Integer> flips = problem4.pancakeSort(array);
        System.out.println("Flips needed to sort the array");
        for (int i : flips) {
            System.out.print(i + " ");
        }
        System.out.println("\nArray after pancake sorting...");
        problem4.printArray(array);
    }
}
