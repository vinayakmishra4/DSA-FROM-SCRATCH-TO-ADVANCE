import java.util.Scanner;

class Missing
{
    public static int miselement(int arr[])
    {
        // Initialize the count of elements
        int n=arr.length;
        int sum=0;
        int s;
        // add all elements in the array
        for(int i=0;i<n;i++)
        {
            sum=sum+arr[i];
        }
        // sum of 1 to n 
        s = (n + 1) * (n + 2) / 2;
        // differenec between sum of 1 to n and sum of array elements
        int max=s-sum;
        return max;
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
        System.out.println("Missing element is "+miselement(arr));
    }
}