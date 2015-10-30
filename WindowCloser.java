import kareltherobot.*;
/**
 * Write a description of class WindowCloser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WindowCloser extends Robot implements Directions,Closer
{
    private int x;

    public WindowCloser(int st, int ave, Direction dir, int beeps)
    {
        // call to the superclass constructor
        super(st, ave, dir, beeps);
    }

    public boolean leftIsClear()//returns true if there is no wall to the left of the robot
    {
        boolean result = true;
        turnLeft();
        if (frontIsClear()){
            result=true;
        }
        else{
            result=false;
        }
        turnRight();
        return result;
    }

    public void moveToNextWindow()//
    {
        if(frontIsClear()){
            move();
        }
        else
            turnRight();
    }

    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }

    public void closeWindow()
    {
        if (leftIsClear())
        {
            putBeeper();
        }
    }

    public void work()
    {
        putBeeper();
        move();
        while (!nextToABeeper())
        {
            closeWindow();
            moveToNextWindow();

            if (nextToABeeper())
        {
            pickBeeper();
            break;
        }
        }
    }
}
