public class PerfectPower {
	
	public static int[] isPerfectPower(int n) 
	{

		int [] power = new int [2];
		if(n<=0 || prime(n)==0)
		{
			return null;
		}
		else
		{
			for(int i=2;i<Math.sqrt(n);i++)
			{
				
					int copy =n;
					int ok=0;
					int count =0;
					while(copy!=0 && ok==0)
					{
						if(copy%i==0)
						{
							count++;
							copy/=i;
						}
						else
						{
							ok=1;
						}
							
					}
					if(ok==0)
					{
						power[0]=i;
						power[1]=count;
						return power;
	        }
				}
		}
			
			return null;
		
		
	  }
	
	  public static int prime (int n)
	  {
		  int sum=0;
		  for(int i=2;i<=n/2;i++)
		  {
			  if(n%i==0)
			  {
				  sum++;
			  }
		  }
		  if(sum==0)
		  {
			  return 0;
		  }
		  else
		  {
			  return 1;
		  }
	  
	  }
}
	  
		  
			  
	