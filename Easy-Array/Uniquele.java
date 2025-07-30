// WAP to find the unique element in an array
import java.util.Scanner;

class Uniquele
{
     // Method to find the unique element in the array
     public int findUnique(int[] arr)
     {
        int n=arr.length;
        int count;

        // Iterate through each element in the array
        for(int i=0;i<n;i++)
        {
            int num=arr[i];
            count=0;

            // Count how many times the current element appears in the array
            for(int j=0;j<n;j++)
            {
                if(arr[j]==num)
                {
                    count++;
                }
            }

            // If the element appears only once, return it
            if(count==1)
            {
                return num;
            }
        }

        // If no unique element is found, return -1
        return -1;
     }

    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);

       // Ask the user for the size of the array
       System.out.println("Size of Array");
       int n=sc.nextInt();

       int arr[]=new int[n];

       // Prompt the user to enter the elements of the array
       System.out.println("Enter the elements of array");
       for(int i=0;i<n;i++)
       {
        arr[i]=sc.nextInt();
       }

       // Create an object of the Uniquele class
       Uniquele u=new Uniquele();

       // Call the method to find the unique element
       int result=u.findUnique(arr);

       // Display the result
       if(result==-1)
       {
        System.out.println("No unique element found");
       }
       else
       {
         System.out.println("Unique element is "+result);
       }
    }
}