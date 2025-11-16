
import java.util.Scanner;

class Largestoddnumber
{
   public String largestOddNumber(String num)
   {
        for(int i=num.length()-1;i>=0;i--)
        {
            char ch=num.charAt(i);
            if((ch-'0')%2!=0)
            {
                return num.substring(0,i+1);
            }
        }
        return "";
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        String num=sc.next();  
        Largestoddnumber obj=new Largestoddnumber();
        String result=obj.largestOddNumber(num);
        System.out.println("The largest odd number is: "+result);  
    }    
}
