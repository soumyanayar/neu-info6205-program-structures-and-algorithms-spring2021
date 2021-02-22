package Assignment_04;

class Problem2 {
    private int partition(int[] arr, int low, int high) {
        int i = low + 1;
        int j = high;
        while (true) {
            while (i < high && arr[low] < arr[i]) {
                ++i;
            }
            while (j > low && arr[j] < arr[low]) {
                --j;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int findNthSmallest(int[] nums, int n) {
        n = nums.length - n;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if (j < n) {
                lo = j + 1;
            } else if (j > n) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {
        int arr[] = { 12, 3, 5, 7, 4, 19, 26 };
        int n = 3;
        System.out.println("N'th smallest element is " + new Problem2().findNthSmallest(arr, n));
    }

}