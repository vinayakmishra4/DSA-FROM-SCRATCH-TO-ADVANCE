import java.util.Scanner;

public class Bubble_Sort
{
  public static void BeforeSort(int arr[])
  {
     for(int num:arr)
     {
       System.out.print(num + " ");
     }
  }

  public static void Bubble(int arr[])
  {
     int n=arr.length;
     boolean swaped;
     for(int i=0;i<n-1;i++)
     {
        swaped=false;
        for(int j=0;j<n-i-1;j++)
        {
            if(arr[j]>arr[j+1])
            {
              swap(arr, j, j+1);
              swaped=true;
            }
           
        }
        if(!swaped)
        {
          break;
        }
     }
  }

  public static void AfterSort(int arr[])
  {
     for(int num:arr)
     {
       System.out.print(num + " ");
     }
  }
  public static void swap(int arr[],int i,int j)
  {
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
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
     Bubble(arr);
     System.out.println("After sorting");
     AfterSort(arr);
   } 
}
