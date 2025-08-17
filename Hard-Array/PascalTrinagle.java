// WAP to print Pascal's Triangle
import java.util.ArrayList;
import java.util.Scanner;

class PascalTrinagle
{
    public static ArrayList<Integer> nthRowOfPascalTriangle(int n)
    {
        // Adjust to 0-indexed internally
        int rowIndex = n - 1; 
        ArrayList<Integer> row = new ArrayList<>();
        int number = 1;
        for (int k = 0; k <= rowIndex; k++)
        {
            row.add(number);
            number = number * (rowIndex - k) / (k + 1);
        }
        return row;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows for Pascal's Triangle: ");
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int number = 1; // First element in each row is always 1
            System.out.print(" ".repeat(n - i - 1)); // Print leading spaces
            
            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1); // Calculate next number in the row
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}