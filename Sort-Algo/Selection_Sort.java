import java.util.Scanner;

class Selection_Sort
{
  public static void BeforeSort(int arr[])
  {
     for(int num:arr)
     {
       System.out.print(num + " ");
     }
  }
  public static void Selection(int arr[])
  {
    for(int i=0;i<arr.length-1;i++)
    {
      int min=i;
      for(int j=i+1;j<arr.length;j++)
      {
        if(arr[j]<arr[min])
        {
           min=j;
        }
      }
      swap(arr,i,min);
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
  public static void main(String []args)
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
     Selection(arr);
     System.out.println("After sorting");
     AfterSort(arr);
  }
}
