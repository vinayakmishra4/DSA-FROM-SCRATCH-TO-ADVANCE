// https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1

import java.util.Arrays;
import java.util.Scanner;

class Mergearray {
    // Function to merge two sorted arrays without extra space
    public void mergeArrays(int a[], int b[]) {
        int i = a.length - 1;  // Start from the end of array a
        int j = 0;             // Start from the beginning of array b

        // Swap elements if element in a is greater than element in b
        // This pushes larger elements towards b and smaller towards a
        while (i >= 0 && j < b.length) {
            if (a[i] > b[j]) {
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                i--;
                j++;
            } else {
                // If a[i] <= b[j], just move j forward to check next element in b
                j++;
            }
        }

        // After swapping, sort both arrays individually to restore sorted order
        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read size of first array
        System.out.print("Enter size of first sorted array: ");
        int n = scanner.nextInt();
        int[] a = new int[n];

        // Read elements of first array
        System.out.println("Enter elements of first sorted array:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // Read size of second array
        System.out.print("Enter size of second sorted array: ");
        int m = scanner.nextInt();
        int[] b = new int[m];

        // Read elements of second array
        System.out.println("Enter elements of second sorted array:");
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        Mergearray mergeObj = new Mergearray();
        mergeObj.mergeArrays(a, b);

        // Print the merged arrays
        System.out.println("After merging:");
        System.out.println("First array: " + Arrays.toString(a));
        System.out.println("Second array: " + Arrays.toString(b));

        scanner.close();
    }
}
