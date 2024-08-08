import greenfoot.*;  
import greenfoot.GreenfootImage;
public class Staff extends Weapon
{  
    public Staff()
    {
        super("staff", 0);
    }
    
    public void act()
    {
        switchImage();
        disappear();
    }    
}
