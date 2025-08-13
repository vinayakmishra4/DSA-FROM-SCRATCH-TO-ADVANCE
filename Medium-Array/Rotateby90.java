// WAP to rotate Matrix by 90 degree clockwise

import java.util.Scanner;

class Rotateby90
{
    static void rotate(int mat[][])
    {
        int n = mat.length;
        int m = mat[0].length;
        int temp[][] = new int[n][m];
        for (int i = 0; i < n; i++)
        {
             for (int j = 0; j < m; j++)
             {
                temp[j][n - i - 1] = mat[i][j];
             }
        }
    }

    public static void printMatrix(int[][] mat)
    {
        for (int[] row : mat)
        {
            for (int val : row)
            {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows in the matrix: ");
        int m = sc.nextInt();

        System.out.print("Enter the number of columns in the matrix: ");
        int n = sc.nextInt();

        int[][] mat = new int[m][n];

        System.out.println("Enter the elements of the matrix: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Original Matrix:");
        printMatrix(mat);

        rotate(mat);

        System.out.println("Matrix after setting rows and columns to zero:");
        printMatrix(mat);
    }
}