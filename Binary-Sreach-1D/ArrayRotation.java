// WAP to find the count of Array roatation

import java.util.Scanner;

class ArrayRotation {
    
    public static int findKRotation(int arr[]) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        // If array is not rotated at all
        if (arr[low] <= arr[high]) {
            return 0;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int next = (mid + 1) % n; // To avoid index out of bounds
            int prev = (mid - 1 + n) % n;

            // Check if mid element is minimum (rotation point)
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
            } 
            else if (arr[mid] >= arr[low]) {
                // Left part is sorted, so pivot must be in right part
                low = mid + 1;
            } else {
                // Right part is sorted, pivot must be in left part
                high = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements of the array (rotated sorted array):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int rotations = findKRotation(arr);
        System.out.println("The array is rotated " + rotations + " times.");

        sc.close();
    }
}
