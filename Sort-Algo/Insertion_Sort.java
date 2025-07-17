import java.util.Scanner;

public class Insertion_Sort 
{
    public static void BeforeSort(int arr[])
    {
      for(int num:arr)
      {
        System.out.print(num + " ");
      }
    }
    public static void Insertion(int arr[])
    {
      for(int i=1;i<arr.length;i++)
      {
        int temp=arr[i];
        int j=i-1;
        while(j>=0 && arr[j]>temp)
        {
           arr[j+1] = arr[j];
            j--;
        }
        arr[j+1]=temp;
      }
    }
    public static void AfterSort(int arr[])
    {
      for(int num:arr)
      {
        System.out.print(num + " ");
      }
    }
    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the size of array");
       int n=sc.nextInt();
       int arr[]=new int[n];
       System.out.println("Enter the number of elements in arr");
       for(int i=0;i<n;i++)
       {
         arr[i]=sc.nextInt();
       }
       System.out.println("Before sorting");
       BeforeSort(arr);
       System.out.println();
       Insertion(arr);
       System.out.println("After sorting");
       AfterSort(arr);
    }
}
