
public class LuthAlgorithm {
	  public static boolean validate(String n)
	  {
		 if(n.length()%2==0) 
		 {
			 for(int i=0;i<n.length();i++)
			 {
				 if(i%2==0)
				 {
				 n.replace( n.charAt( i),(char)((n.charAt(i) -'0')*2));
				 
				 }
			 }
			 for(int j=0;j<n.length();j++)
			 {
				 if((n.charAt(j)-'0')>9)
				 {
					 n.replace(n.charAt(j), (char)(sum(j)));
				 }
			 }
			 int sum=0;
			 for(int i=0;i<n.length();i++)
			 {
				 sum+=(n.charAt(i)-'0');
			 }
			 if(sum%10==0)
			 {
				 return true;
			 }
			 else
			 {
				 return false;
			 }
		 }

	  
	  else
	  {
			 if(n.length()%2!=0) 
			 {
				 for(int i=0;i<n.length();i++)
				 {
					 if(i%2==1)
					 {
					 n.replace( n.charAt( i),(char)((n.charAt(i) -'0')*2));
					 
					 }
				 }
				 for(int j=0;j<n.length();j++)
				 {
					 if((n.charAt(j)-'0')>9)
					 {
						 n.replace(n.charAt(j), (char)(sum(j)));
					 }
				 }
				 int sum=0;
				 for(int i=0;i<n.length();i++)
				 {
					 sum+=(n.charAt(i)-'0');
				 }
				 if(sum%10==0)
				 {
					 return true;
				 }
				 else
				 {
					 return false;
				 }
			 }
			return false;

		  }
}
	  public static int sum(int n)
	  {
		  int sum=0;
		  while(n!=0)
		  {
			  sum+=n%10;
			  n/=10;
		  }
		return sum;
		  
	  }

}
