import java.util.Scanner;

public class maxConsecBits 
{
    public int ConsctiveBits(int[] arr) 
    {
        int len=arr.length;
        int count =0;
        for(int i=0;i<len;i++)
        {
            int temp=1;
            for(int j=i+1;j<len;j++)
            {
                 if(arr[i]==arr[j])
               { 
                temp++;
                i=j;
              } 
              else {            

               break; 
                  
              }
                
                 }          
                 
               if (temp > count) 
                count = temp;
        }
        
          return count;
        }
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
        maxConsecBits obj=new maxConsecBits();
        System.out.println("Maximum consecutive bits are "+obj.ConsctiveBits(arr));
    }
}
