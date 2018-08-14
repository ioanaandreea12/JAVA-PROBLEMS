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
