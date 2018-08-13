
import java.util.ArrayList;
import java.util.Arrays;

class GapInPrimes {
    
    public static long[] gap(int g, long m, long n) {
       long[] numbers = null ;
       for(long i=m;i<=n;i++)
       {
    	   if(prime(i)==1 && prime(i+g)==1)
    	   {
    		   numbers[0]=i;
    		   numbers[1]=i+g;
            return numbers;
    	   }
       }
       return null;
      
       
    }
    public static int prime(long i)
    
    {
    	int sum=0;
    	for(int i1=2;i1<Math.sqrt(i1);i1++)
    	{
    		if(i%i1==0)
    		{
    			sum++;
    		}
    	}
    	if(sum==0)
    	{
    		return 1;
    	}
    	else
    	{
    		return 0;
    	}
    }
    public static void main(String[] args)
    {
    	System.out.println(gap(2,100,110));
    }
}