
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CompareTriplets {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) 
    {
       ArrayList<Integer> c  = null;
        HashMap<String,Integer>  map = new HashMap<String,Integer>();
        if((a.get(0)<b.get(0)))
        {
                map.put("B",1);
        }
        else
        {
           if((a.get(0)>b.get(0)))
           {
                 map.put("A",1);
           }

        }
        for(int i=1;i<a.size();i++)
        {
                for(int j=1;j<b.size();j++)
                {
                    if((a.get(i)<b.get(j)) && (i==j))
                       {
                                map.put("B",map.get("B")+1);
                       }
                    
                    if((a.get(i)>b.get(j)) && (i==j))
                       {
                                map.put("A",map.get("A")+1);
                       }
                    
                }

}
        if(map.get("A")>map.get("B"))
        {
            c.add(map.get("A"));
            c.add(map.get("B"));
        }
        else
        {
}              
        if(map.get("A")<map.get("B"))
        {
            c.add(map.get("B"));
            c.add(map.get("A"));
        }
        return c;
  }

    

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
          
           
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
