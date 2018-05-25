import java.util.*;
import java.io.*;

/**
 * Maze represents a maze of characters. The goal is to get from the
 * top left corner to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class Maze
{
    private static final int TRIED = 2;
    private static final int PATH = 3;

    private int numberRows, numberColumns;
    private int[][] grid;
    private Position[] success;
    private int successCount = 0;

    /**
     * Constructor for the Maze class. Loads a maze from the given file.  
     * Throws a FileNotFoundException if the given file is not found.
     *
     * @param filename the name of the file to load
     * @throws FileNotFoundException if the given file is not found
     */
    public Maze(String filename) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File(filename));
        numberRows = scan.nextInt();
        numberColumns = scan.nextInt();
        
        grid = new int[numberRows][numberColumns];
        success = new Position[numberRows*numberColumns];
        for (int i = 0; i < numberRows; i++)
            for (int j = 0; j < numberColumns; j++)
                grid[i][j] = scan.nextInt();
    }
        
    /**
     * Marks the specified position in the maze as TRIED
     *
     * @param row the index of the row to try
     * @param col the index of the column to try 
     */
    public void tryPosition(int row, int col)
    {
        grid[row][col] = TRIED;
    }
    
    /**
     * Return the number of rows in this maze
     *
     * @return the number of rows in this maze
     */
    public int getRows()
    {
        return grid.length;
    }
    
    /**
     * Return the number of columns in this maze
     *
     * @return the number of columns in this maze
     */
    public int getColumns()
    {
        return grid[0].length;
    }
    
    /**
     * Marks a given position in the maze as part of the PATH
     *
     * @param row the index of the row to mark as part of the PATH
     * @param col the index of the column to mark as part of the PATH 
     */
    public void markPath(int row, int col)
    {
        grid[row][col] = PATH;
    }

    /**
     * Determines if a specific location is valid. A valid location
     * is one that is on the grid, is not blocked, and has not been TRIED.
     *
     * @param row the row to be checked
     * @param column the column to be checked
     * @return true if the location is valid    
     */
    public boolean validPosition(int row, int column)
    {
        boolean result = false;
 
        // check if cell is in the bounds of the matrix 
        if (row >= 0 && row < grid.length &&
            column >= 0 && column < grid[row].length)
        
            //  check if cell is not blocked and not previously tried 
            if (grid[row][column] == 1)
                result = true;
        return result;
    }
    
    public Stack<Position> path(int sX, int sY, int eX, int eY)
    {
    	Stack<Position> S = new Stack<>();
    	S.push(new Position(sX,sY));
    	grid[S.peek().getx()][S.peek().gety()] = 3;
    	int left = -1;
    	int right = -1;
    	int below = -1;
    	int above = -1;
    	while(!S.isEmpty() && grid[eX][eY]!=3)
    	{
    		if(S.peek().getx()-1 >=0)
    		left = grid[S.peek().getx()-1][S.peek().gety()];
    		if(S.peek().getx()+1 < numberRows)
    		right = grid[S.peek().getx()+1][S.peek().gety()];
    		if(S.peek().gety()+1 < numberColumns)
    		below = grid[S.peek().getx()][S.peek().gety()+1];
    		if(S.peek().gety()-1 >=0)
    		above = grid[S.peek().getx()][S.peek().gety()-1];
    		
    		if(left == 2)
    		{grid[S.peek().getx()-1][S.peek().gety()] =3; S.push(new Position(S.peek().getx()-1,S.peek().gety()));}
    		else if(right == 2)
    		{grid[S.peek().getx()+1][S.peek().gety()] =3; S.push(new Position(S.peek().getx()+1,S.peek().gety()));}
    		else if(below == 2)
    		{grid[S.peek().getx()][S.peek().gety()+1] =3; S.push(new Position(S.peek().getx(),S.peek().gety()+1));}
    		else if(above == 2)
    		{grid[S.peek().getx()][S.peek().gety()-1] =3; S.push(new Position(S.peek().getx(),S.peek().gety()-1));}
    		else if (stuck(S.peek(), left, right, above, below))
    		{grid[S.peek().getx()][S.peek().gety()]= 4 ; S.pop();}
    		else
    		{grid[S.peek().getx()][S.peek().gety()] = 4;S.pop();}
    		
    		left =-1;
    		right = -1;
    		below = -1;
    		above = -1;
    		
    	}
    	return S;
    		
    }
    
    private boolean stuck(Position c, int left, int right, int above, int below)
    {
    	if(left != 2 && right !=2 && above != 2 && below !=2)
    		return true;
    	return false;
    }
 

    /**
     * Returns the maze as a string.
     * 
     * @return a string representation of the maze
     */
    public String toString()
    {
        String result = "\n";

        for (int row=0; row < grid.length; row++)
        {
            for (int column=0; column < grid[row].length; column++)
                result += grid[row][column] + "";
            result += "\n";
        }
        
        return result;
    }
}