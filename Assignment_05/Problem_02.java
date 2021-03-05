package Assignment_05;

import java.util.*;

public class Problem_02 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> resultSet = new HashSet<>();
        // Arrays.sort(nums2);
        for (int number : nums1) {
            if (binarySearch(nums2, number)) {
                resultSet.add(number);
            }
        }
        int i = 0;
        int[] result = new int[resultSet.size()];
        for (int number : resultSet) {
            result[i++] = number;
        }
        return result;
    }

    public static boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void display(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array1 = { 2, 5, 8, 9, 10, 11, 12 };
        int[] array2 = { 4, 5, 6, 8, 10, 11, 12 };
        int[] result = intersection(array1, array2);
        display(result);

    }
}
