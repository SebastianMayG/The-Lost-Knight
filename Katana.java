import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Katana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Katana extends Weapon
{
    public Katana()
    {
        super("katana", 3);
    }
    public void act()
    {
        switchImage();
        disappear();
    }
}
