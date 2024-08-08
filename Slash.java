import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Slash extends Others
{
    static GreenfootImage slash[] = new GreenfootImage[3];
    int loopCount = 18;
    public Slash()
    {
        slash[0] = new GreenfootImage("weapon/0.png");
        slash[1] = new GreenfootImage("weapon/1.png");
        slash[2] = new GreenfootImage("weapon/2.png");
        
        setImage(slash[0]);
    }
    
    //El segundo método constructor es para cuando se ataca por la izquierda
    public Slash(String l)
    {
        slash[0] = new GreenfootImage("weapon/0L.png");
        slash[1] = new GreenfootImage("weapon/1L.png");
        slash[2] = new GreenfootImage("weapon/2L.png");
        
        setImage(slash[0]);
    }
    
    public void act()
    {
        switchImage();
    }
    
    public void switchImage()
    {
        if(loopCount == 18)
        {
            setImage(slash[0]);
            Sound.sounds[1].play();
        }
        else if(loopCount == 12)
        {
            setImage(slash[1]);
        }
        if(loopCount == 6)
        {
            setImage(slash[2]);
        }
        if(loopCount == 0)
        {
            getWorld().removeObject(this);
        }
        loopCount--;
        
    }
    
}
