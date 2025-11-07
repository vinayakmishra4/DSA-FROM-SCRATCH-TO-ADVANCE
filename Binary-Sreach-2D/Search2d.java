import java.util.Scanner;

// Search for an element in a 2D matrix where each row and each column is sorted in ascending order.
public class Search2d
{
    // Binary Search in a 2D matrix
    public static boolean matSearch(int mat[][], int x)
    {
        int n=mat.length;  // Number of rows in the matrix
        int m=mat[0].length;  // Number of columns in the matrix
        
        // We treat the 2D matrix as a 1D sorted array of size n*m for binary search
        int low=0;  // Starting index of the 1D representation
        int high=n*m-1;  // Ending index of the 1D representation
        
        // Binary search loop runs while the search space is valid
        while(low<=high)
        {
            int mid=(low+high)/2;  // Middle index of the current search space
            
            // Convert the 1D mid index back to 2D matrix indices
            int r=mid/m;  // Row index in the matrix
            int c=mid%m;  // Column index in the matrix
            
            // Check if the element at (r, c) is equal to the target x
            if(mat[r][c]==x)
            {
                return true;  // Element found, return true
            }
            else if(mat[r][c]<x)
            {
                // If the element at (r, c) is less than x,
                // discard the left half by moving low to mid + 1
                low=mid+1;
            }
            else
            {
                // If the element at (r, c) is greater than x,
                // discard the right half by moving high to mid - 1
                high=mid-1;
            }
        }
        // Element not found in the matrix, return false
        return false;
    }
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);  // Scanner object to take input from user
        
        System.out.println("Enter the number of rows and columns:");
        int n=sc.nextInt();  // Number of rows input by user
        int m=sc.nextInt();  // Number of columns input by user
        
        int mat[][]=new int[n][m];  // Declare a 2D array (matrix) of size n x m
        
        System.out.println("Enter the elements of the matrix:");
        // Nested loops to take input of each element of the matrix
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                mat[i][j]=sc.nextInt();  // Input element at position (i, j)
            }
        }  
        
        System.out.println("Enter the element to be searched:");
        int x=sc.nextInt();  // Element to search in the matrix
        
        // Call the matSearch function to check if x exists in the matrix
        boolean result=matSearch(mat,x);
        
        // Output the result based on the boolean returned
        if(result)
        {
            System.out.println("Element found in the matrix.");
        }
        else
        {
            System.out.println("Element not found in the matrix.");
        } 
        
        sc.close();  // Close the scanner to prevent resource leak
    }
}
