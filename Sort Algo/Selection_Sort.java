class Selection_Sort
{
  public static void Selection(int arr[])
  {
    for(int i=0;i<arr.length()-1;i++)
    {
      int min=i;
      for(int j=i+1;j<arr.length()-;j++)
      {
        if(arr[j]<arr[min])
        {
           min=j;
        }
      }
      swap(i,j)
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
    
  }
}
