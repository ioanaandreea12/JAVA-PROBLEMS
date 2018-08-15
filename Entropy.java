import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Entropy {
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
		public static double [] normalise(int [] c)
		{
			double [] p = new double [c.length];
			double sum=0;
			for(int i=0;i<c.length;i++)
			{
				sum+=c[i];
			}
			for(int i=0;i<c.length;i++)
			{
				p[i]=c[i]/sum;
			}
			return p;
		}
		//c)
		public static double entropyOf(double[] d)
		{
			double entropy =0;
			for(int i=0;i<d.length;i++)
			{
				entropy-= d[i]*Math.log(d[i]);
			}
			return entropy;
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
		public static void main (String[] args)
		{
			String hello = args[0];
			String world = args [1];
			
			System.out.println("Character Probabilities in hello: "+normalise(charCount(hello)).toString());
			double [] entropyhello = new double [charCount(hello).length];
			double [] entropyworld = new double [charCount(world).length];
			for(int i=0;i<charCount(hello).length;i++)
			{
				entropyhello[i]=charCount(hello)[i];
				
			}
			for(int i=0;i<charCount(hello).length;i++)
			{
				entropyworld[i]=charCount(world)[i];
				
			}
			
			System.out.println("Entropy of hello:"+entropyOf(entropyhello));
			System.out.println("Entropy of world:"+ entropyOf(entropyworld));
			
			
			
			
		}
}
