import java.util.*;

/**
 * MazeSolver attempts to recursively traverse a Maze. The goal is to get from the
 * given starting position to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class MazeSolver
{
    private Maze maze;
    private int startX;
    private int startY;
    private int eX;
    private int eY;
    
    /**
     * Constructor for the MazeSolver class.
     */
    public MazeSolver(Maze maze, int x, int y, int ex, int ey)
    {
        this.maze = maze;
        startX = x;
        startY = y;
        eX = ex;
        eY = ey;
        if(!this.maze.validPosition(ex, ey))
        	System.out.println("Invalid endpoints");
        if(!this.maze.validPosition(x, y))
        	System.out.println("Invalid start point");
    }
    
    /**
     * Attempts to recursively traverse the maze. Inserts special
     * characters indicating locations that have been TRIED and that
     * eventually become part of the solution PATH.
     *
     * @param row row index of current location
     * @param column column index of current location
     * @return true if the maze has been solved
     */
    public boolean traverse()
    {
        boolean done = false;
        int row, column;
        Position pos = new Position(startX,startY);
        Deque<Position> stack = new LinkedList<Position>();
        stack.push(pos);
        
        while (!(done) && !stack.isEmpty())
        {
            pos = stack.pop();
            maze.tryPosition(pos.getx(),pos.gety());  // this cell has been tried
            if (pos.getx() == eX && pos.gety() == eY)
                done = true;  // the maze is solved
            else
            {
                push_new_pos(pos.getx() - 1,pos.gety(), stack); 
                push_new_pos(pos.getx() + 1,pos.gety(), stack);
                push_new_pos(pos.getx(),pos.gety() - 1, stack);
                push_new_pos(pos.getx(),pos.gety() + 1, stack); 
            }
        }

        return done;
    }
    
    /**
     * Push a new attempted move onto the stack
     * @param x represents x coordinate
     * @param y represents y coordinate
     * @param stack the working stack of moves within the grid
     * @return stack of moves within the grid
     */
    private void push_new_pos(int x, int y, 
                                         Deque<Position> stack)
    {
        Position npos = new Position();
        npos.setx(x);
        npos.sety(y);
        if (maze.validPosition(x,y))
            stack.push(npos);
    }
    
}