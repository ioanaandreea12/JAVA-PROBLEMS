
import java.util.HashMap;
import java.util.Map;

class MineSweeper {

    public static Map<String, Position> findMines(char[][] grid) {
    	Map<String,Position>  map = new HashMap<String,Position>();
    		for(int i=0;i<grid.length;i++)
    		{
    			for(int j=0;j<grid.length;j++)
    			{
    				if(grid[i][j]=='X')
    				{
    					Position p = new Position(i,j);
    					map.put("("+i+" "+","+j+" "+")",p);
    				}
    			}
    		}
    			
    			
    	return map;
    }

    public static boolean isIsolated(char[][] grid, Position minePos) {
      for(int i=0;i<grid.length;i++)
      {
    	  for(int j=0;j<grid.length;j++)
    	  {
    		  if((grid[i][j]=='X') && (i==minePos.getX()) &&(minePos.getY()==j))
    		  {
   			  if((grid[i][j]!='X')  && (grid[i][j]!='X')  && (grid[i][j]!='X') && (grid[i][j]!='X'))
   			  {
   				  return true;
   			  }
    		  }
    	  }
      }
        return false;
    }

    public static int disarmMines(char[][] grid, Map<String, Position> armedMines) {
    	int count=0;
      for(String i:armedMines.keySet())
      {
    	  if(isIsolated(grid,armedMines.get(i)))
    	  {
    		  armedMines.replace(i, armedMines.get(i));
    		  count++;
    		  
    	  }
      }
        return count;
    }
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please execute this program by"
                    + " providing the path to a game file,"
                    + " e.g. java MineSweeper ./game01.txt");
            System.exit(1);
        }

        char[][] grid = MineSweeperUtils.parseGrid(args[0]);
        System.out.println("Playing with grid: ");
        MineSweeperUtils.printGrid(grid);

        System.out.println("Searching mines ...");
        Map<String, Position> mines = findMines(grid);
        if(mines != null) {
            if(mines.isEmpty()) System.out.println("No mines found.");
            else System.out.println("Mines found at: " + mines.keySet());
        }

        System.out.println("\nDisarming mines ...");
        int disarmed = disarmMines(grid, mines);
        System.out.println(disarmed + " mines disarmed!");
        MineSweeperUtils.printGrid(grid, mines);
    }
}