
import java.util.Map;
import java.util.HashMap;
import java.util.List;

class BattleShips {

    public static char fireShot(char[][] grid, Position shot) {
        for(int i=0;i<grid.length;i++)
        {
        	for(int j=0;j<grid.length;j++)
        	{
        		if((i==shot.getX()) && (j==shot.getY()) && (grid[i][j]!='#'))
        				{
        					System.out.println("("+i+","+j+")"+":"+"Hit"+grid[i][j]);
        					return grid[i][j];
        				}
        	}
        }
        System.out.println("("+shot.getX()+","+shot.getY()+")"+":"+"Hit"+grid[shot.getX()][shot.getY()]);
        return '#';
    }

    public static Map<Character, Integer> findShips(char[][] grid) {
    	 Map<Character,Integer> map =new HashMap<Character,Integer>();
    	 	for(int i=0;i<grid.length;i++)
    	 	{
    	 		for(int j=0;j<grid.length;j++)
    	 		{
    	 			if(map.containsKey(grid[i][j]))
    	 			{
    	 				map.put(grid[i][j], map.get(grid[i][j])+1);
    	 			}
    	 			else
    	 			{
    	 				map.put(grid[i][j], 1);
    	 			}
    	 		}
    	 	}
    	 	return map;
    //Implement me;
    }

    public static List<Character> fireShots(char[][] grid, List<Position> shots) {
    		List<Character> list = null;
    		for(int i=0;i<shots.size();i++)
    		{
    			for(int j=0;j<grid.length;j++)
    			{
    				for(int k=0;k<grid.length;k++)
    				{
    					if(grid[i][j]!='#' && shots.get(i).getX()==i && shots.get(i).getY()==j)
    					{
    						list.add(grid[i][j]);
    						System.out.println("("+i+","+j+")"+":"+"Hit"+grid[i][j]);
    					}
    					else
    					{
    						 System.out.println("("+i+","+j+")"+":"+"Hit"+grid[i][j]);
    					}
    				}
    			}
    		}
    		
        return list;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please execute this program by"
                    + " providing the path to a game file,"
                    + " e.g. java BattleShips ./game01.txt");
            System.exit(1);
        }

        char[][] grid = BattleShipsUtils.parseGrid(args[0]);

        System.out.println("Playing with grid: ");
        BattleShipsUtils.printGrid(grid);

        Position centreShot = new Position(grid.length / 2,
                                           grid.length / 2);
        System.out.println("\nFiring Shot at centre " +
                            centreShot.toString() + " ...");
        fireShot(grid, centreShot);

        System.out.println("\nGenerating shots ...");
        List<Position> shots = BattleShipsUtils.generateShots(grid.length,
                                    grid.length * 2);
        System.out.println("Shots: " + shots);

        System.out.println("\nFinding Ships ...");
        Map<Character, Integer> ships = findShips(grid);
    	if(ships != null) {
           for (Character ship : ships.keySet())
             System.out.println(ship + " has size " + ships.get(ship));
    	}

        System.out.println("\nFiring shots ...");
    	if(shots != null) {
            List<Character> destroyedShips = fireShots(grid, shots);
    	    if (destroyedShips != null && !destroyedShips.isEmpty()) {
    	        System.out.println("Destroyed ships: ");
    	        for(char ship : destroyedShips)
    	            System.out.println(ship);
    	    }
    	}
    }
}