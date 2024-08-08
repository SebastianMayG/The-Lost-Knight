import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HUD extends Others
{
    public static GreenfootImage hearts[] = new GreenfootImage[7];    
    
    public HUD()
    {
        hearts[0] = new GreenfootImage("hud/life1.png");
        hearts[1] = new GreenfootImage("hud/life2.png");
        hearts[2] = new GreenfootImage("hud/life3.png");
        hearts[3] = new GreenfootImage("hud/life4.png");
        hearts[4] = new GreenfootImage("hud/life5.png");
        hearts[5] = new GreenfootImage("hud/life6.png");
        hearts[6] = new GreenfootImage("hud/life7.png");
    }
    public void act()
    {
        checkImage();
        if(Player.life == 1)
            Sound.sounds[4].play();
    }
    
    public void checkImage()
    {
        if(getWorld().getObjects(Player.class).get(0) != null)
        {
        if (Player.life == 6 && getImage() != hearts[0])
        {
            setImage(hearts[0]);
        }
        else if (Player.life == 5 && getImage() != hearts[1])
        {
            setImage(hearts[1]);
        }
        else if (Player.life == 4 && getImage() != hearts[2])
        {
            setImage(hearts[2]);
        }
        else if (Player.life == 3 && getImage() != hearts[3])
        {
            setImage(hearts[3]);
        }
        else if (Player.life == 2 && getImage() != hearts[4])
        {
            setImage(hearts[4]);
        }
        else if (Player.life == 1 && getImage() != hearts[5])
        {
            setImage(hearts[5]);
        }
        else if (Player.life <= 0 && getImage() != hearts[6])
        {
            setImage(hearts[6]);
        }
        }
    }
    
    
}
