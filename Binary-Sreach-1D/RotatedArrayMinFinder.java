import java.util.Scanner;

public class RotatedArrayMinFinder
{
    // Method to find minimum in a rotated sorted array
    public static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            // Optimization: If the current subarray is already sorted
            if (arr[left] <= arr[right]) {
                min = Math.min(min, arr[left]);
                break;
            }

            int mid = (left + right) / 2;
            min = Math.min(min, arr[mid]);

            if (arr[left] <= arr[mid]) {
                // Left half is sorted
                min = Math.min(min, arr[left]);
                left = mid + 1;
            } else {
                // Right half is sorted
                min = Math.min(min, arr[mid + 1]);
                right = mid - 1;
            }
        }
        return min;
    }

    // Main method for user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements of the rotated sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int min = findMin(arr);
        System.out.println("The minimum element in the rotated sorted array is: " + min);
    }
}
