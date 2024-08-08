import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dungeon12 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dungeon1 extends Dungeon
{
    /**
     * Constructor for objects of class Dungeon12.
     * 
     */
    public Dungeon1()
    {
        super();
        prepare();
    }
    
    public void prepare()
    {
        addObject(new Slime(), 177, 292);
        addObject(new Slime(), 380, 154);
        addObject(new Slime(), 627, 267);
    }
}
