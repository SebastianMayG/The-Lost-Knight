import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dungeon2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dungeon2 extends Dungeon
{

    /**
     * Constructor for objects of class Dungeon2.
     * 
     */
    public Dungeon2()
    {
        super();
        prepare();
    }
    
    public void prepare()
    {
        addObject(new DragonR(), 114, 136);
        addObject(new DragonL(), 693, 149);
        addObject(new MiniDemon(), 267, 138);
        addObject(new MiniDemon(), 498, 129);
    }
}
