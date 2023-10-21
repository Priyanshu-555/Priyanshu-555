
class Suffle
{
   
    public static void main(String args[])
    {
    
        int arr[] = {1,2,3,4,5,6};
        int n =arr.length/2;
            
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]);
            System.out.print(arr[n+i]);     
        }
     
    }
}