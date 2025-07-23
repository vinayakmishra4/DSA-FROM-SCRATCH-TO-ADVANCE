// WAP to remove the duplicate elment in the array
import java.util.Scanner;

class Remove
{
    public static int[] Remove(int arr[])
    {
        int n = arr.length;
        // Boolean array to mark duplicates
        boolean[] isDuplicate = new boolean[n];
        int count = 0;

        // Mark duplicates in the array
        for (int i = 0; i < n; i++) {
            if (!isDuplicate[i]) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] == arr[j]) {
                        isDuplicate[j] = true; // Mark duplicate element
                        count++; // Increment duplicate count
                    }
                }
            }
        }

        // Create new array to hold unique elements
        int[] temp = new int[n - count];
        int index = 0;

        // Copy unique elements to new array
        for (int i = 0; i < n; i++) {
            if (!isDuplicate[i]) {
                temp[index++] = arr[i];
            }
        }

        return temp;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the element of array");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int temp[]=Remove(arr);
        System.out.println("Array after removing duplicate element");
        for(int i=0;i<temp.length;i++)
        {
            System.out.print(temp[i]+" ");
        }
    }
}
