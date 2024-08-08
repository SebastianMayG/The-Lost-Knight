import greenfoot.*;
public class HurtBox extends Others
{
    public void act()
    {
        move();
        showHurtBox();
    }
    
    //Sirve para mostrar la imagen del hurt box
    public void showHurtBox()
    {
        if(Greenfoot.isKeyDown("0"))
        {
            setImage("player/hbox/1.png");
        }
        else
        {
            setImage("player/hbox/0.png");
        }
    }
    
    public void move()
    {
        Player player = getWorld().getObjects(Player.class).get(0);
        
        if(isTouching(Player.class))
        {
            setLocation(player.getX(), player.getY() + 19);
        }
    }
}
