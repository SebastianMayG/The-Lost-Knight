import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Heart extends Others
{

    public void act()
    {
        touchingHeart();
    }
    public void touchingHeart()
    {       
        if (isTouching(HurtBox.class) &&  this!= null)
        {
            if(Player.life <= 6 && this!= null)
            {
                Player.life++;
                Sound.sounds[9].play();
                getWorld().removeObject(this);
            }
            else if(Player.life > 6 && this!= null)
            {
                Sound.sounds[9].play();
                getWorld().removeObject(this);
            }
        }
    }
}
    
