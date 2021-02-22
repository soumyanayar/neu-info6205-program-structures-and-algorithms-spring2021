package Assignment_04;

import java.util.*;

class Problem1 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> resultSet = new HashSet<>();
        Arrays.sort(nums2);
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

    public boolean binarySearch(int[] nums, int target) {
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

    public static void main(String[] args) {
        Problem1 obj = new Problem1();
        int[] array1 = { 8, 6, 3, 8, 2, 5 };
        int[] array2 = { 4, 6, 0, 3, 7, 6 };
        int[] result = obj.intersection(array1, array2);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}