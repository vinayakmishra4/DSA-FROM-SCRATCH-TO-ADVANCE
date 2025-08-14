// WAP to print the matrix sprial from matrix
import java.util.ArrayList;
import java.util.Scanner;

public class Sprialform
{
    // Method to traverse a matrix in spiral form
    public ArrayList<Integer> spirallyTraverse(int[][] mat)
    {
        int n = mat.length;        // Number of rows
        int m = mat[0].length;     // Number of columns
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Defining boundaries of the current layer
        int top = 0;            // starting row index
        int bottom = n - 1;     // ending row index
        int left = 0;           // starting column index
        int right = m - 1;      // ending column index
        
        // Loop until all elements are traversed
        while (top <= bottom && left <= right)
        {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) 
            {
                ans.add(mat[top][i]);
            }
            top++; // Move the top boundary down
            // Traverse from top to bottom along the rightmost column
            for (int i = top; i <= bottom; i++)
            {
                ans.add(mat[i][right]);
            }
            right--; // Move the right boundary left
            // Traverse from right to left along the bottom row (if still within bounds)
            if (top <= bottom)
            {
                for (int i = right; i >= left; i--)
                {
                    ans.add(mat[bottom][i]);
                }
                bottom--; // Move the bottom boundary up
            }
            // Traverse from bottom to top along the leftmost column (if still within bounds)
            if (left <= right)
            {
                for (int i = bottom; i >= top; i--)
                {
                    ans.add(mat[i][left]);
                }
                left++; // Move the left boundary right
            }
        }
        return ans; // Return the spiral order list
    }

    // Main method to test the spiral traversal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking matrix size input
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        // Taking matrix elements input
        System.out.println("Enter matrix elements row-wise:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Calling the spiral function
        Sprialform sf = new Sprialform();
        ArrayList<Integer> result = sf.spirallyTraverse(matrix);

        // Printing the spiral order
        System.out.println("Spiral order: " + result);

        sc.close(); // Closing the scanner
    }
}