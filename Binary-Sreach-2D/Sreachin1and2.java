// WAP to find the element in row wise and column wise sorted 2D array using binary search.
// This program searches for a given element in a 2D matrix that is sorted both row-wise and column-wise.
// The search is done efficiently using a binary search-like technique starting from the top-right corner.
import java.util.Scanner;
class Pair
{
        int x; int y;   // To store the coordinates (row, column) of the found element

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
}
class Sreachin1and2
{
    // Function to search for element 'x' in a row-wise and column-wise sorted 2D matrix.
    public static Pair search(int [][] matrix, int x)
    {
        int n = matrix.length;          // Number of rows
        int m = matrix[0].length;       // Number of columns
        int row = 0;                    // Start from the first row
        int col = m - 1;                // Start from the last column (top-right corner)
        while(row < n && col >= 0)      // Loop until we go out of matrix bounds
        {
            if(matrix[row][col] == x)   // If the current element matches the target
            {
                return new Pair(row, col);  // Return its position
            }
            else if(matrix[row][col] > x)  // If current element is greater than target
            {
                col--;                      // Move left (to smaller elements)
            }
            else                            // If current element is smaller than target
            {
                row++;                      // Move down (to larger elements)
            }
        }
        return new Pair(-1, -1);        // If not found, return (-1, -1)
	}
    // Main function to take input from the user and call the search function.
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows and columns:");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][] matrix = new int[n][m];    // Declare the 2D matrix

        // Take matrix input from user
        System.out.println("Enter matrix elements (sorted row-wise and column-wise):");
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter element to search:");
        int x = sc.nextInt();               // Element to search for

        Pair ans = search(matrix, x);       // Call search function

        // Display result
        if(ans.x == -1 && ans.y == -1)
        {
            System.out.println("Element not found");
        }
        else
        {
            System.out.println("Element found at: " + ans.x + " " + ans.y);
        }

        sc.close();    // Close scanner
    }

}