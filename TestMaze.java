package MazeGame;

import java.util.Scanner;

/**
 * Created by Monisha Verma
 */
public class TestMaze {
    public static void main(String[] args){

        int[][] mazeArray = {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
                {0,0,0,1,1,1,1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,1,1},
                {0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0},
                {0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

        Maze myMaze = new Maze(mazeArray);
//        boolean keepAsking = true;
//        Scanner scan = new Scanner(System.in);
//        String input = "";
//        myMaze.displayPath();
//        System.out.println("Maze Project---");
//
//        do {
//            System.out.println("W = Take a step north | S = Take a step south  | A = Take a step west | D = Take a step east| P = Show path | Q = Quit");
//            System.out.print("Enter command: ");
//            input = scan.nextLine();
//            input.trim();
//            input.toLowerCase();
//            if(input.equals("w")) {
//                keepAsking = !myMaze.takeStep();
//                System.out.println("moving north");
//                myMaze.moveNorth();
//            } else if (input.equals("s")) {
//                keepAsking = !myMaze.takeStep();
//                System.out.println("moving south");
//                myMaze.moveSouth();
//            } else if(input.equals("a")) {
//                keepAsking = !myMaze.takeStep();
//                System.out.println("moving west");
//                myMaze.moveWest();
//            } else if (input.equals("d")) {
//                keepAsking = !myMaze.takeStep();
//                myMaze.displayMaze();
//                System.out.println();
//                System.out.println("moving east");
//                myMaze.moveEast();
//            } else if(input.equals("p")) {
//                myMaze.findExit();
//                keepAsking = false;
//            } else if(input.equals("q")) {
//                keepAsking = false;
//            } else {
//                System.out.println("ERR: Invalid input");
//            }
//        } while(keepAsking);
//        System.out.println("Quitting program...");
//        scan.close();
        
       System.out.println( myMaze.scout());
    }
}
