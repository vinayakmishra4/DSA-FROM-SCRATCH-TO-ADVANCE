import java.util.Scanner;

public class Sreach2 {

    // Method to search key in rotated sorted array
    public boolean search(int[] arr, int key) {
        if (arr == null || arr.length == 0) return false;

        int low = 0, high = arr.length - 1;
        int pivot = findPivot(arr);

        // Determine which side of the pivot to search
        if (key >= arr[pivot] && key <= arr[high]) {
            low = pivot;
        } else {
            high = pivot - 1;
        }

        // Standard Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) return true;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }

    // Helper method to find pivot (index of the smallest element)
    private int findPivot(int[] arr) {
        int low = 0, high = arr.length - 1;

        // If array is not rotated
        if (arr[low] <= arr[high]) return 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is pivot
            if (mid < high && arr[mid] > arr[mid + 1])
                return mid + 1;

            if (mid > low && arr[mid] < arr[mid - 1])
                return mid;

            // Decide which side to go
            if (arr[mid] >= arr[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return 0; // If not found, array is not rotated
    }

    // Main method to test the search
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sreach2 obj = new Sreach2();

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements (rotated sorted array): ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter key to search: ");
        int key = sc.nextInt();

        boolean found = obj.search(arr, key);
        if (found)
            System.out.println("Key " + key + " found in the array.");
        else
            System.out.println("Key " + key + " not found in the array.");

        sc.close();
    }
}
