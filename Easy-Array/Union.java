import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Union 
{
    public static ArrayList<Integer> findUnion(int[] a, int[] b) 
    {
       ArrayList<Integer> temp = new ArrayList<Integer>();
       for(int i=0;i<a.length;i++)
       {
         temp.add(a[i]);
       }
       for(int i=0;i<b.length;i++)
       {
         temp.add(b[i]);
       }
       HashSet<Integer> cars = new HashSet<Integer>();
       for(int i=0;i<temp.size();i++)
       {
         cars.add(temp.get(i));
       }
       ArrayList<Integer> result = new ArrayList<Integer>(cars);
       return result;
    }
    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);
       System.out.println("Size of Array one");
       int n=sc.nextInt();
       int a[]=new int[n];
       System.out.println("Enter the elements of array");
       for(int i=0;i<n;i++)
       {
        a[i]=sc.nextInt();
       }
       System.out.println("Size of Second Array");
       int m=sc.nextInt();
       int b[]=new int[m];
       System.out.println("Enter the elements of array");
       for(int i=0;i<m;i++)
       {
         b[i]=sc.nextInt();
       }
       ArrayList<Integer> result = findUnion(a,b);
       System.out.println("Union of two array is "+result);

    }
}
