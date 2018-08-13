
public class DuplicateEncoder {
	static String encode(String word){
		String duplicateword = null;
		int [] frequencies = new int [26];
		word.toLowerCase();
		for(int i='a';i<='z';i++)
		{
			for(int j=0;j<word.length();j++)
			{
				if(word.charAt(j)==i)
				{
					frequencies[i]++;
					
				}
			}
		}
		for(int i1=0;i1<word.length();i1++)
		{
			if(frequencies[word.charAt(i1)]>1)
			{
				duplicateword+=")";
			}
			else
			{
				duplicateword+="(";
			}
		}
    return duplicateword;
  }
}
