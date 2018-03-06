package MazeGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Monisha Verma.
 * KSU Programming Principles II
 */

public class Maze {

    private char direction;
    private int r;  // x position of the mouse
    private int c;  //y position of the mouse
    private boolean exitFound = false;
    int[][] arrMaze;
    //array to store the path of mouse
    int[][] showPathMaze;
    //array used to display current mouse position
    int[][] currentPosArr;

    public Maze(int[][] arrMaze) {
        this.arrMaze = arrMaze;
        r = arrMaze.length-1;
        c = 0;
        //copy arrMaze over to showPathMaze array
        showPathMaze = new int[arrMaze.length][arrMaze[0].length];
        for (int i = 0; i < arrMaze.length; i++){
            for (int j = 0; j < arrMaze[0].length; j++){
                showPathMaze[i][j] = arrMaze[i][j];
            }
        }
        //copy arrMaze over to currentPositionArr
        currentPosArr = new int[arrMaze.length][arrMaze[0].length];
        for (int i = 0; i < arrMaze.length; i++){
            for (int j = 0; j < arrMaze[0].length; j++){
                currentPosArr[i][j] = arrMaze[i][j];
            }
        }
        currentPosArr[r][c] = 4;
     }

    //Prints out the maze without solution
    public void displayMaze() {
        int row = arrMaze.length;
        int col = arrMaze[0].length;
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arrMaze[i][j]);
            }
            System.out.println();
        }
    }

    //displays the Maze with the path taken
    public void displayPath() {
        int row = showPathMaze.length;
        int col = showPathMaze[0].length;
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(showPathMaze[i][j]);
            }
            System.out.println();
        }
    }
    //prints the maze with the mouse current position labeled with a 4
    public void displayCurrentPos() {
        int row = currentPosArr.length;
        int col = currentPosArr[0].length;
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(currentPosArr[i][j]);
            }
            System.out.println();
        }
    }

    public boolean takeStep() {
        //complete the code here

        return isAnExit();
    }
    //method to move the mouse up or north
    public void moveNorth() {
        //complete the code here
        if (arrMaze[r-1][c] == 0) {
            currentPosArr[r][c] = arrMaze[r][c];
            showPathMaze[r][c] = 2;
            r--;
            currentPosArr[r][c] = 4;
            displayCurrentPos();
        } else {
            System.out.println("Cannot move north. Path is blocked");
        }
    }
    //method to move the mouse down or south
    public void moveSouth() {
        //complete the code here
        if (arrMaze[r+1][c] == 0) {
            currentPosArr[r][c] = arrMaze[r][c];
            showPathMaze[r][c] = 2;
            r++;
            currentPosArr[r][c] = 4;
            displayCurrentPos();
        } else {
            System.out.println("Cannot move south. Path is blocked");
        }
    }
    //method to move the mouse right or east
    public void moveEast() {
        //complete the code here
        if (arrMaze[r][c+1] == 0) {
            currentPosArr[r][c] = arrMaze[r][c];
            showPathMaze[r][c] = 2;
            c++;
            currentPosArr[r][c] = 4;
            displayCurrentPos();
        } else {
            System.out.println("Cannot move east. Path is blocked");
        }
    }
    //method to move the mouse left or west
    public void moveWest() {
        //complete the code here
        if (arrMaze[r][c-1] == 0) {
            currentPosArr[r][c] = arrMaze[r][c];
            showPathMaze[r][c] = 2;
            c--;
            currentPosArr[r][c] = 4;
            displayCurrentPos();
        } else {
            System.out.println("Cannot move west. Path is blocked");
        }
    }

    private boolean isAnExit() {
        //complete the code here
        return exitFound;
    }

    //finds the path without stopping at every step
    public void findExit() {
        //complete the code here
    }
    
    
    /**
     * 
     * logic:
     * goal: get the mouse the to end of maze
     * 1. get all indexes of possible paths in the maze
     * 2. favoring north and east, as that is exit, look, walk, keep a safety
     * 3. if path = dead end go back to safety. if path = open 3 steps
     * 		 add to possPath else go back to safety
     * 
     * @precondition none
     * @postcondition none
     * 
     * 
     * 
     * @return the arrayList of the best path to the exit
     */
    public ArrayList<String> scout() {
    	
 /*
  * logic:
  * goal: get the mouse the to end of maze
  * 1. get all indexes of possible paths in the maze
  * 2. favoring north and east, as that is exit, build open paths
  * check is curr step has multi paths
  * yes: step safety
  * 
  * 	take steps
  * check if new step has multi paths
  * 
  * 3. if path = dead end go back to safety. if path = open 3 steps
  * 		 add to possPath else go back to safety
  * else
  */
    	
    	
    	ArrayList <String> possPath = new ArrayList<String>();
    	ArrayList <String> path = new ArrayList<String>();
    	ArrayList <String> ones = new ArrayList<String>();
    	
    	
    	// pull out all the ones
    	for(int r = 0; r < arrMaze.length; r++) {
    		for(int c = 0; c < arrMaze[0].length; c++) {
    			
    			if(arrMaze[r][c] == 1) {
    				ones.add(Integer.toString(r) +"," +Integer.toString(c));
    				
    				
    			}
    		}
    		
    	}
    	System.out.println("checkpoint 1");
    	
    	int currX = r;
    	int currY = c;
    	
    	
    	for(int i = 0; i < 10 ; i++) {
    		
 
    		int openLength =0;
    		for(int l = 0; l< 3; l++) {
    			
    			openLength += openPaths(currX, currY, ones).length;
    		}
    		
    		
    		// if there is only two paths (back & forth)
    		if(openLength == 2) {
    			System.out.println("checkpoint 2");
    			

    			
    			ArrayList<String> buildResult = buildPath(currX, currY, ones);
    			possPath.addAll(buildResult);
    			
    		}else {
    			
    	

        		if(currX == Integer.parseInt(ones.get(i).substring(0, ones.get(i).charAt(','))) 
        				&& (currY + 1 == Integer.parseInt(ones.get(i).substring(ones.get(i).charAt(',') + 1))
        				|| (currY - 1 == Integer.parseInt(ones.get(i).substring(ones.get(i).charAt(',') + 1))))) {
        			
        			possPath.add(ones.get(i));
        			currX = Integer.parseInt(ones.get(i).substring(0, ones.get(i).charAt(',')));
        			currY = Integer.parseInt(ones.get(i).substring(ones.get(i).charAt(',') + 1));
        			
        		}
        		
        		if(currY == Integer.parseInt(ones.get(i).substring(ones.get(i).charAt(',') + 1))
        				&& (currX + 1 == Integer.parseInt(ones.get(i).substring(0, ones.get(i).charAt(',')))
        				|| (currX - 1 == Integer.parseInt(ones.get(i).substring(0, ones.get(i).charAt(',')))))) {
        			possPath.add(ones.get(i));
        			
        			//TODO if it hits any exit column the mouse is out
        			currX = Integer.parseInt(ones.get(i).substring(0, ones.get(i).charAt(',')));
        			currY = Integer.parseInt(ones.get(i).substring(ones.get(i).charAt(',') + 1));
        		}	
    				
    		}
    	}
    	
    	if(possPath.size() > 5) {
    		
    		for(int i =0; i < possPath.size(); i++) {
    			path.add(possPath.get(i));
    		}
    	}
    	
    	return path;
    }// closes scout
    
    
    /**
     * considers a path with only one direction
     * 
     * 
     * @param x is the current row position of the mouse
     * @param y is the current column position of the mouse
     * @param js
     * @param ones
     * 
     * @return the best path out of n cross-roads
     */
    private ArrayList<String> buildPath(int x, int y, ArrayList<String> ones) {
		/*logic
		 * 1. grab a safety spot safety spot in case of dead-end
		 * 2.dirPath as @param? to check where intersection indexes are
		 */
    	int xsafe = x;
    	int ysafe = y;
    	
    
    	ArrayList<String> output = new ArrayList<String>();
    	for(int t = 0; t< 4; t++) {
    		
    	ArrayList <String> possPath = new ArrayList<String>();
    		
    		
    		
        	for(int i = 0; i < 3; i++) {
        		
        		int onesX = Integer.parseInt(ones.get(i).substring(0, ones.get(i).charAt(',')));
        		int onesY = Integer.parseInt(ones.get(i).substring(ones.get(i).charAt(',') + 1));
        		
        		if(x == onesX && (y + 1 == onesY || y - 1 == onesY)) {
        			possPath.add(ones.get(i));
        			x = Integer.parseInt(ones.get(i).substring(0, ones.get(i).charAt(',')));
        			y = Integer.parseInt(ones.get(i).substring(ones.get(i).charAt(',') + 1));
        		}
        		
        		if(y == onesY && (x + 1 == onesX || (x - 1 == onesX))) {
        			possPath.add(ones.get(i));
        			x = Integer.parseInt(ones.get(i).substring(0, ones.get(i).charAt(',')));
        			y = Integer.parseInt(ones.get(i).substring(ones.get(i).charAt(',') + 1));
        		}
        		
    		
    	}
        output = possPath;
    
    	
	}
    		return output;
    }
    
    
    /**
     * Find open areas (paths) in each direction
     * 
     * 
     * @param x is the current position of mouse row
     * @param y is the current position of mouse column
     * 
     * @param ones is the arrayList of all possible 1's paths
     * 
     * @return open array where element 1 (e1) = North
     * 	e2 = South e3 = East e4= West
     */
	private int[] openPaths(int x, int y, ArrayList<String> ones) {
    	/*
    	 * Find the number of directions available.  
    	 */
		
		//open is an array specified in the method documentation above
    	int[] open = {0,0,0,0};
		
    	for(int i =0; i < ones.size(); i++) {
    		
    		
    		System.out.println("@param values! " +Integer.toString(y) +","+ Integer.toString(x +1));
    		System.out.println("ones arr! " + ones.get(i));
    		
    		System.out.println("if " + x+ " == " + Integer.parseInt(ones.get(i).substring(0, ones.get(i).charAt(','))));
    		
    		int onesX = Integer.parseInt(ones.get(i).substring(0, ones.get(i).charAt(',')));
    		int onesY = Integer.parseInt(ones.get(i).substring(ones.get(i).charAt(',') + 1));
    		
    		
    		//checking north to see if a step is open 
    		// if true switch the position to 1 meaning open
    		if(x == onesX && y+1 == onesY) {
    			open[0] = 1;
    		}

    		//checking south to see if a step is open
    		if(x  == onesX && y-1 == onesY ) {
    			open[1] = 1;
    		}
  
    		//checking east to see if a step is open
    		if(x +1  == onesX && y == onesY ) {
    			open[2] = 1;
    		}
    		
    		//checking west to see if a step is open
    		if(x-1  == onesX && y== onesY ) {
    			open[3] = 1;
    		}
    		
    	}
    	
		return open;
	}


}