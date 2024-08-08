import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Controls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controls extends World
{
    private int loopCount = 0;
    public Controls()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
    }
    
    public void act()
    {
        loopCount++;
        if(loopCount > 10 && (Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space")))
        {
            addObject(new Transition("Start"), 400, 300);
            Greenfoot.playSound("start.wav");
        }
    }
}
