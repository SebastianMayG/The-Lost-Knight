import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoldenSword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoldenSword extends Weapon
{
    public GoldenSword()
    {
        super("goldenSword", 4);
    }
    
    public void act()
    {
        switchImage();
        disappear();
    }
}
