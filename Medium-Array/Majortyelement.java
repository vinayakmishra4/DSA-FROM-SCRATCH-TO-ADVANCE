import java.util.Scanner;

class Majortyelement
{
    public static int majorityElement(int arr[])
    {
        // Step 1: Find the candidate
        int candidate = -1, count = 0;

        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Verify if the candidate is really the majority
        int countVerify = 0;
        for (int num : arr) {
            if (num == candidate) {
                countVerify++;
            }
        }

        return (countVerify > arr.length / 2) ? candidate : -1;

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
       int result = majorityElement(arr);
       if(result==-1)
       {
        System.out.println("No Majority Element");
       }
       else
       {
        System.out.println("Majority Element is "+result);
       }
    }
}