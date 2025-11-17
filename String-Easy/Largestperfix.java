// This program finds the longest common prefix among a list of strings
// entered by the user using a straightforward iterative approach.
import java.util.Scanner;

class Largestperfix
{
    // Method to compute the longest common prefix among strings in the array
    public String longestCommonPrefix(String arr[])
    {
        // Start by assuming the first string as the prefix
        String prefix=arr[0];
        // Iterate through all other strings to shorten the prefix until it matches
        for(int i=1;i<arr.length;i++)
        {
            // While the current string does not start with the prefix, shorten the prefix
            while(arr[i].indexOf(prefix)!=0)
            {
                // Remove the last character from prefix
                prefix=prefix.substring(0,prefix.length()-1);
                // If prefix becomes empty, no common prefix exists
                if(prefix.isEmpty())
                {
                    return "";
                }
            }
        }
        return prefix;    
    }
    public static void main(String[] args)
    {
        // Taking input from the user
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of strings:");
        int n=sc.nextInt();
        String arr[]=new String[n];
        System.out.println("Enter the strings:");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.next();
        }
        // Create object and call the method to compute longest common prefix
        Largestperfix obj=new Largestperfix();
        String result=obj.longestCommonPrefix(arr);
        // Display the final result
        System.out.println("The longest common prefix is: "+result);    
    }    
}
