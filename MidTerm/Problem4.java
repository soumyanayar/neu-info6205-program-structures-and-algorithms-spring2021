package MidTerm;

public class Problem4 {
    /*
     * Time Complexity: O(log n) where n is the length of the input array.
     * 
     * Space Complexity: O(1) since we do not use any extra space.
     */
    static int getIndex(int arr[], int key) {
        int low = 0;
        int high = arr.length - 1;
        int searchIndex = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                searchIndex = mid;
                high = mid - 1;
            }
        }
        return searchIndex;
    }

    public static void main(String[] args) {
        int array1[] = { 2, 4, 4, 4, 6, 7, 7, 7, 8, 9, 9, 9 };
        int key1 = 7;
        System.out.println("First Occurrence of " + key1 + " in array1 is at index " + getIndex(array1, key1));

        int array2[] = { 1, 7, 15, 16, 20, 20, 20, 20, 22 };
        int key2 = 20;
        System.out.println("First Occurrence of " + key2 + " in array2 is at index " + getIndex(array2, key2));

        int array3[] = { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
        int key3 = 5;
        System.out.println("First Occurrence of " + key3 + " in array3 is at index " + getIndex(array3, key3));
    }
}
