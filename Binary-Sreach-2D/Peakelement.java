// WAP to find the peak element in a 2D array.

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Program to find a peak element in a 2D array using Binary Search.
 * A "peak element" is an element that is greater than or equal to its neighbors (up, down, left, right).
 * 
 * Approach:
 * - Instead of searching every element (O(rows * cols)), we use Binary Search on columns.
 * - At each step, we:
 *   1. Find the column's middle index (midCol).
 *   2. Find the row index (maxRow) where the value is maximum in this column.
 *   3. Compare mat[maxRow][midCol] with its left and right neighbors:
 *      - If it's smaller than the left neighbor, move search to the left half.
 *      - If it's smaller than the right neighbor, move search to the right half.
 *      - Else, this element is a peak.
 * 
 * Time Complexity: O(rows * log(cols))
 * Space Complexity: O(1)
 */
class Peakelement
{
    public ArrayList<Integer> findPeakGrid(int[][] mat)
    {
        int rows = mat.length;
        int cols = mat[0].length;
        int left = 0;
        int right = cols - 1;

        while (left <= right) {
            // Perform binary search on columns
            int midCol = left + (right - left) / 2;
            // Find the row with maximum element in the current middle column
            int maxRow = 0;

            for (int i = 0; i < rows; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            boolean isPeak = true;

            // If the left neighbor is greater, move to the left half
            if (midCol - 1 >= 0 && mat[maxRow][midCol] < mat[maxRow][midCol - 1]) {
                isPeak = false;
                right = midCol - 1;
            }

            // If the right neighbor is greater, move to the right half
            if (midCol + 1 < cols && mat[maxRow][midCol] < mat[maxRow][midCol + 1]) {
                isPeak = false;
                left = midCol + 1;
            }

            // The element at (maxRow, midCol) is a peak — return its position
            if (isPeak) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(maxRow);
                result.add(midCol);
                /*
                 * The algorithm ensures the found element is a peak because:
                 * - It is the maximum in its column.
                 * - It is not smaller than its left or right neighbors.
                 * Hence, it is greater than or equal to all its neighbors.
                 */
                return result;
            }
        }

        return new ArrayList<>(); // Should never reach here   
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the rows and columns of the 2D array: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] mat = new int[rows][cols];
        System.out.println("Enter the elements of the 2D array: ");
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                mat[i][j] = sc.nextInt();
            }
        }
        Peakelement pe = new Peakelement();
        ArrayList<Integer> peak = pe.findPeakGrid(mat);
        System.out.println("Peak element found at: " + peak);    
    }
}