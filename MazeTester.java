import java.util.*;
import java.io.*;

/**
 * MazeTester uses recursion to determine if a maze can be traversed.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class MazeTester
{
    /**
     * Creates a new maze, prints its original form, attempts to
     * solve it, and prints out its final form.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the file containing the maze: ");
        String filename = scan.nextLine();
        System.out.print("Please enter the starting x cordinate: ");
        int x = scan.nextInt();
        System.out.print("Please enter the starting y cordinate: ");
        int y = scan.nextInt();
        System.out.print("Please enter the ending x cordinate: ");
        int ex = scan.nextInt();
        System.out.print("Please enter the ending y cordinate: ");
        int ey = scan.nextInt();
        
        Maze labyrinth = new Maze(filename);
      
        System.out.println(labyrinth);
        
        MazeSolver solver = new MazeSolver(labyrinth, x, y,ex,ey);

        if (solver.traverse())
        	{
        	Stack<Position> s = labyrinth.path(x,y,ex,ey);
        	System.out.println(labyrinth);
            System.out.println("The maze was successfully traversed!");
        	while(!s.isEmpty())
        	{
        		System.out.println(s.peek().getx() + ", " + s.peek().gety() );
        		s.pop();
        	}
        	}
        else
            System.out.println("There is no possible path.");

       
    }
}