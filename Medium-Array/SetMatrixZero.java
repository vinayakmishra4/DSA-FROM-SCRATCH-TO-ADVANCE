// WAP to set matrix zero
import java.util.Scanner;

class SetMatrixZero {
    public static void setMatrixZeroes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        // Mark the rows and columns that need to be set to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Set cells to 0 based on marked rows and columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    mat[i][j] = 0;
                }
            }
        }
    }

    // Utility method to print the matrix
    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
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

        setMatrixZeroes(mat);

        System.out.println("Matrix after setting rows and columns to zero:");
        printMatrix(mat);

        sc.close();
    }
}
