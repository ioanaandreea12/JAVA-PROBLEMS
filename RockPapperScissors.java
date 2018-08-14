import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

class RockPaperScissors {

    /**
     * Returns if a given symbol is a valid symbol for the
     * game.
     * @param symbol the symbol to be checked
     * @return true if the given symbol is valid, false otherwise
     */
    public static boolean isValidSymbol(char symbol) {
        return symbol == 'R' || symbol == 'P' || symbol == 'S';
    }

    public static List<Matchup> parseMatchups(String[] args) {
    	ArrayList<Matchup> list = null;
      for(int i=0;i<args.length;i++)
      {
    	  if(args[i].length()==2 && isValidSymbol(args[i].charAt(0)) &&isValidSymbol(args[i].charAt(1)))
    			  {
    		  		Matchup player = new Matchup(args[i].charAt(0),args[i].charAt(1));
    		  		list.add(player);
    			  }
      }
        return list;
    }

    /**
     * Returns the outcome of a given matchup as String.
     *
     * @param match The matchup to be decided.
     * @return a String representation of the matchup result; R, P, S or DRAW
     * @throws IllegalArgumentException if the given matchup parameter is null
     */
    public static String decideOutcome(Matchup match) {
        if(match == null)
            throw new IllegalArgumentException("Given match must not be null!");

        String res = "" + match.getPlayerOne() + match.getPlayerTwo();

        if (res.equals("RP") || res.equals("PR")) return "P";
        if (res.equals("RS") || res.equals("SR")) return "R";
        if (res.equals("PS") || res.equals("SP")) return "S";

        return "DRAW";
    }

    public static Map<String, Integer> countOutcomes(List<Matchup> matches) {
    Hashtable<String,Integer> table = new Hashtable<String,Integer>();
    for(int i=0;i<matches.size();i++)
    {
    	if(table.contains(decideOutcome(matches.get(i))))
    	{
    		table.put(decideOutcome(matches.get(i)),table.get(decideOutcome((matches.get(i))))+1);
    		
    	}
    	else
    	{
    		table.put(decideOutcome(matches.get(i)),1);
    	}
    }
    int mostOutcomes =0;
    String s="";
    
    for(String name : table.keySet())
    {
    	if(mostOutcomes<table.get(name))
    	{
    		s=name;
    		mostOutcomes=table.get(name);
    	}
    }
   System.out.println("Most outcomes:"+ s);
    	
        return table;
    } 

    /**
     * Executes different functionality for the game RockPaperScissors.
     *
     * @param args A series of matchups encoded as pairs of single characters.
     * The series of matchups can be empty.
     */
    public static void main(String[] args) {
        List<Matchup> matches = parseMatchups(args);
        System.out.println(matches);
    
        if(matches != null) {
            System.out.println(matches.size() + " matches parsed.");

            System.out.println("\nCount outcomes per symbol...");
            Map<String, Integer> outcomesPerSymbol = countOutcomes(matches);
            System.out.println(outcomesPerSymbol);
        }
    }

}