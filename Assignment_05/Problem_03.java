package Assignment_05;

public class Problem_03 {
    public static int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void display(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = { 2, 5, 6, 7, 0, 1, 8, 5, 9, 10, 4, 6, 9, 12 };
        display(array);
        System.out.println("The peak element in the array is : " + peakIndexInMountainArray(array));

    }
}
