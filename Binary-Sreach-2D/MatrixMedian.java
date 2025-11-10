// WAP to find the median of a row-wise sorted matrix

import java.util.Scanner;

class MatrixMedian
{
    // Function to find the median of a row-wise sorted matrix
    public static int findMedian(int arr[][], int n, int m)
    {
        // Initialize min and max with extreme values
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Step 1: Find the minimum and maximum elements in the matrix
        // Since rows are sorted, the smallest element of each row is at index 0,
        // and the largest element is at index m-1.
        for (int i = 0; i < n; i++) {
            if (arr[i][0] < min) {
                min = arr[i][0];
            }
            if (arr[i][m - 1] > max) {
                max = arr[i][m - 1];
            }
        }

        // The position of the median element in the sorted order
        int desired = (n * m + 1) / 2;

        // Step 2: Perform binary search between min and max
        while (min < max) {
            int mid = min + (max - min) / 2; // Find mid value
            int place = 0; // To count numbers less than or equal to mid

            // Step 3: Count how many elements are less than or equal to mid
            for (int i = 0; i < n; i++) {
                int l = 0, h = m - 1;

                // Binary search in each row since it is sorted
                while (l <= h) {
                    int md = l + (h - l) / 2;
                    if (arr[i][md] <= mid) {
                        // If middle element is <= mid, move right
                        place = place + (md + 1);
                        l = md + 1;
                    } else {
                        // If middle element > mid, move left
                        h = md - 1;
                    }
                }
            }

            // Step 4: Adjust search range based on number of elements <= mid
            if (place < desired) {
                // If there are fewer elements than desired, search in right half
                min = mid + 1;
            } else {
                // Otherwise, search in left half (including mid)
                max = mid;
            }
        }

        // Step 5: When min == max, we've found the median
        return min;
    }

    // Main function
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        // Input matrix size
        System.out.println("Enter number of rows and columns:");
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Input matrix elements
        int arr[][] = new int[n][m];
        System.out.println("Enter the elements of the matrix:");
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }

        // Find and display the median
        int median = findMedian(arr, n, m);
        System.out.println("The median is: " + median);
    }
}
