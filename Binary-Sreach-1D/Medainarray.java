// WAP (Write A Program) to find the median of two sorted arrays
import java.util.Scanner;

class Medainarray
{
    // Method to find median of two sorted arrays
    public double medianOf2(int a[], int b[])
    {
        // Get the lengths of both arrays
        int n1 = a.length;
        int n2 = b.length;

        // Create a merged array to hold elements of both arrays
        int[] merged = new int[n1 + n2];

        // Pointers for traversing both arrays
        int i = 0, j = 0, k = 0;

        // Merge both sorted arrays into one sorted array
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                merged[k++] = a[i++];  // Add element from first array
            } else {
                merged[k++] = b[j++];  // Add element from second array
            }
        }

        // If elements remain in first array, add them
        while (i < n1) {
            merged[k++] = a[i++];
        }

        // If elements remain in second array, add them
        while (j < n2) {
            merged[k++] = b[j++];
        }

        // Calculate total length of merged array
        int totalLength = n1 + n2;

        // If total number of elements is even, median is the average of the two middle elements
        if (totalLength % 2 == 0) {
            return (merged[totalLength / 2 - 1] + merged[totalLength / 2]) / 2.0;
        } 
        // If odd, median is the middle element
        else {
            return merged[totalLength / 2];
        }    
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Medainarray obj = new Medainarray();

        // Input: size of first sorted array
        System.out.println("Enter size of first sorted array:");
        int n1 = sc.nextInt();
        int[] a = new int[n1];

        // Input: elements of first sorted array
        System.out.println("Enter elements of first sorted array:");
        for (int i = 0; i < n1; i++) {
            a[i] = sc.nextInt();
        }

        // Input: size of second sorted array
        System.out.println("Enter size of second sorted array:");
        int n2 = sc.nextInt();
        int[] b = new int[n2];

        // Input: elements of second sorted array
        System.out.println("Enter elements of second sorted array:");
        for (int i = 0; i < n2; i++) {
            b[i] = sc.nextInt();
        }

        // Call the method to find the median
        double median = obj.medianOf2(a, b);

        // Output: display the result
        System.out.println("The median of the two sorted arrays is: " + median);

        sc.close();  // Close the scanner to free resources
    }
}
