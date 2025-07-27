import java.util.Scanner;

class Move0 
{
    public static int[] moveZeros(int n, int[] arr) {
        int j = 0;
        // Move all non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[j++] = arr[i];
            }
        }
        // Fill the rest with zeros
        while (j < n) {
            arr[j++] = 0;
        }
        return arr;
    }
   public static void main(String[] args) 
   {
      Scanner sc=new Scanner(System.in);
       System.out.println("Size of Array");
       int n=sc.nextInt();
       int arr[]=new int[n];
       System.out.println("Enter the elements of array");
       for(int i=0;i<n;i++)
       {
        arr[i]=sc.nextInt();
       }
       System.out.println("Move all Zeros to the End");
       int temp[]=moveZeros(n, arr);
       for(int i=0;i<n;i++)
       {
        System.out.print(temp[i]+" ");
       }
   }    
}
