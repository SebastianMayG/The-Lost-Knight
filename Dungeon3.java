import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dungeon3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dungeon3 extends Dungeon
{

    /**
     * Constructor for objects of class Dungeon3.
     * 
     */
    public Dungeon3()
    {
        super();
        prepare();
    }
    
    public void prepare()
    {
        addObject(new BigDemon(), 402, 111);
        addObject(new Event(), 20, 20);
    }
}
