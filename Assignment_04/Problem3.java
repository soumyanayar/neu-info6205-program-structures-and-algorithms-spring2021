package Assignment_04;

class Problem3 {
    public void sortColors(int[] nums) {
        int begin = 0;
        int mid = 0;
        int end = nums.length - 1;
        while (mid <= end) {
            if (nums[mid] < 1) {
                swap(nums, mid, begin);
                ++mid;
                ++begin;
            } else if (nums[mid] == 1) {
                ++mid;
            } else {
                swap(nums, mid, end);
                --end;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem3 obj = new Problem3();
        int[] array1 = { 2, 1, 0, 2, 1, 1 };
        System.out.println("Array before color sorting : ");
        obj.printArray(array1);
        obj.sortColors(array1);
        System.out.println("Array After color sorting : ");
        obj.printArray(array1);
    }
}