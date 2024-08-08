import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DungeonBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DungeonBoss extends Dungeon
{
    public DungeonBoss()
    {
        super();
        prepare();
    }
    
    public void prepare()
    {
        addObject(new Diablo(), 410, 123);
    }
}
