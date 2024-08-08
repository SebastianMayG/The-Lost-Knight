import greenfoot.*; 

public class RustySword extends Weapon
{
    public RustySword()
    {
        super("rustySword", 2);
    }
    
    public void act()
    {
        switchImage();
        disappear();
    } 
}
