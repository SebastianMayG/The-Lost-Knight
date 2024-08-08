import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Wall extends Objects
{
    public void act()
    {
        removeOrbs();
    }
    
    public void removeOrbs()
    {
        if(isTouching(Orb.class))
        {
            removeTouching(Orb.class);
        }
    }
}
