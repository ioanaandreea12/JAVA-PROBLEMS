import java.util.HashMap;

public class Divergence{
	//a)
	public static int [] charCount(String s)
	{
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		s.toLowerCase();
		int [] length = new int [26];
		for(int i=0;i<s.length();i++)
		{
			if(map.containsKey(s.charAt(i))==true)
					{
								map.put(s.charAt(i), map.get(s.charAt(i))+1);
					}
			else
			{
				map.put(s.charAt(i), 1);
			}
		}
		int j=0;
		for(int i='a';i<='z';i++)
		{
			for(Character c : map.keySet())
			{
				if(c==i)
				{
					length[j]=map.get(c);
				}
			}
		}
		
		return length;
		
	}
	//b)
	public static double[] normalise(int[] c) 
	{
		double sum=0;
		double[] normalise = new double [c.length];
		for(int i=0;i<c.length;i++)
		{
			sum+=c[i];
		}
		for(int i=0;i<c.length;i++)
		{
			normalise[i]=c[i]/sum;
		}
		return normalise;
		
	}
	//c)
	public static double kld (double[] p , double[] q)
	{
		double kld =0;
		for(int i=0;i<p.length;i++)
		{
			kld+=p[i]*Math.log(p[i]/q[i]);
		}
		return kld;
	}
	//d)
	 public static int[][] charCountArray(String a[])
	 {
		 int [][] b = new int [a.length][26];
		 int [] valuescolumn = new int [a.length];
		
		 for(int i='a';i<='z';i++)
		 {
			 int ok = 0;
			 int j=0;
			 while(ok==0 && j<a.length)
			 {
				 if(isValid((char) (i+'0'),a[j]) ==false)
				 {
					 ok=1;
				 }
				 j++;
			 }
			 int k=0;
			 if(ok==0)
			 {
				 for(int i1=0;i1<a.length;i1++)
				 {
					 b[i1][k] = countOccurencies((char) (i+'0'),a[i1]);
					 
					 k++;
				 }
			 }
		 }
		 for(int round =0;round<a.length;round++)
		 {
			 int [] array = new int [26];
			 int position =0; 
			 for(int k1=0;k1<b.length;k1++)
			 {
				array[position] = b[round][k1];
				position++;
			 }
			 sort(array);
			 position=0;
			 for(int k2=0;k2<b.length;k2++)
			 {
				 b[round][k2]=array[position];
				 position++;
			 }
		 }
		 return b;
		 
	 }
	 public static boolean isValid(char a, String s)
	 {
		 for(int i=0;i<s.length();i++)
		 {
			 if(a==s.charAt(i))
			 {
				 return true;
			 }
		 }
		 return false;
	 }
	 public static  int countOccurencies ( char a,String s)
	 {
		 int count =0;
		 for(int i=0;i<s.length();i++)
		 {
			 if(a==s.charAt(i))
			 {
				 count++;
			 }
		 }
		 return count;
	 }
	 public static int [] sort ( int [] array)
	 {
		 for(int i=0;i<array.length;i++)
		 {
			 for(int j=i;j<array.length-1;j++)
			 {
				 if(array[j]<array[i])
				 {
					 int aux =  array[j];
					 array[j] =array[i];
					 array[i]=aux;
				 }
			 }
		 }
		 return array;
	 }
	
	//e)
	public static void main(String[] args)
	{
		String cbbaa = args[0];
		String bbbccd = args[1];
		System.out.println("Counting cbbaa :"+charCount(cbbaa).toString());
		System.out.println("Symbol probabilities in cbbaaa"+ normalise(charCount(cbbaa)).toString());
		System.out.println("Shared Symbol Count :"+charCountArray(args));
		System.out.println("Symbol probabilities in bbbccd :"+normalise(charCount(bbbccd)).toString() );
	
		double [] cbbaadouble = new double [charCount(cbbaa).length];
		double [] bbbcddouble = new double [charCount(bbbccd).length];
		for(int i=0;i<cbbaadouble.length;i++)
		{
			cbbaadouble[i]=charCount(cbbaa)[i];
		}
		for(int i=0;i<bbbcddouble.length;i++)
		{
			bbbcddouble[i]=charCount(bbbccd)[i];
		}
		
		System.out.println("Divergence PQ:"+(kld(cbbaadouble,bbbcddouble)+" "));
	}
}