package MidTerm;

public class Problem3 {
    /*
     * Time Complexity: O(n) where n is the length of the input array;
     * 
     * Space Complexity: O(1) since we do not use any extra space;
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maximumSum = 0;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = currentSum * nums[i];
            currentSum = currentSum + nums[i];
            maximumSum = Math.max(maximumSum, currentSum);
        }
        return maximumSum;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        int[] nums1 = { 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0 };
        System.out.println("Maximum Consecutive Ones for nums1 is: " + problem3.findMaxConsecutiveOnes(nums1));

        int[] nums2 = { 0, 0, 0, 1, 1, 0, 1, 1 };
        System.out.println("Maximum Consecutive Ones for nums2 is: " + problem3.findMaxConsecutiveOnes(nums2));

        int[] nums3 = { 0, 0, 0, 0, 0, 0 };
        System.out.println("Maximum Consecutive Ones for nums3 is: " + problem3.findMaxConsecutiveOnes(nums3));
    }
}
