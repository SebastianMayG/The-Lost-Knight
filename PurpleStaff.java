import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PurpleStaff extends Weapon
{
    public PurpleStaff()
    {
        super("purpleStaff", 0);
    }
    
    public void act()
    {
        switchImage();
        disappear();
    }
}
