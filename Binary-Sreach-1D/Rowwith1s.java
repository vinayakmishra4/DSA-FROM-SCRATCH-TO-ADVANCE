// Problem Statement: Given a binary matrix (containing only 0s and 1s), find the row with the maximum number of 1s.
import java.util.Scanner;

public class Rowwith1s
{
    // Method to find the index of the row with the maximum number of 1s in the matrix
    public int rowWithMax1s(int arr[][])
    {
        int maxRowIndex = -1; // Variable to store the index of the row with the maximum 1s found so far. Initialized to -1 to indicate no row found yet.
        int maxCount = 0; // Variable to store the maximum count of 1s found in any row so far.
        int n = arr.length; // Number of rows in the matrix
        int m = arr[0].length; // Number of columns in the matrix

        // Loop through each row of the matrix
        for (int i = 0; i < n; i++) {
            int count = 0; // Counter to keep track of number of 1s in the current row

            // Loop through each element of the current row
            for (int j = 0; j < m; j++) {
                // If the current element is 1, increment the count
                if (arr[i][j] == 1) {
                    count++;
                }
            }

            // After counting 1s in the current row, check if this count is greater than the maximum count found so far
            if (count > maxCount) {
                maxCount = count; // Update maxCount to the new maximum
                maxRowIndex = i; // Update maxRowIndex to the current row index
            }
        }
        // After checking all rows, return the index of the row with the maximum number of 1s
        // If no 1s are found in any row, maxRowIndex will remain -1
        return maxRowIndex;   
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter the number of rows and columns for the matrix
        System.out.println("Enter number of rows and columns:");
        int n = sc.nextInt(); // Number of rows
        int m = sc.nextInt(); // Number of columns

        int arr[][] = new int[n][m]; // Initialize the matrix with the given dimensions

        // Prompt the user to enter the elements of the matrix
        System.out.println("Enter the elements of the matrix (0s and 1s)");

        // Nested loops to read the matrix elements row-wise
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                arr[i][j] = sc.nextInt(); // Read each element (expected to be 0 or 1)
            }
        }

        // Create an object of Rowwith1s to call the instance method
        Rowwith1s obj = new Rowwith1s();

        // Call the method to find the row with the maximum number of 1s
        int result = obj.rowWithMax1s(arr);

        // Check the result and print appropriate message
        if (result != -1)
        {
            System.out.println("Row with maximum number of 1s is: " + result);
        }
        else
        {
            // If no 1s were found in any row, inform the user
            System.out.println("No 1s found in the matrix.");
        }
    }
}
