import greenfoot.*;
public class fireBall extends Others
{
    private boolean shooted;
    private int x, y;
    private static GreenfootImage sprites[] = new GreenfootImage[2];
    private int loopCount=16;  
    
    public fireBall()
    {
        sprites[0] = new GreenfootImage("enemy/0.png");
        sprites[1] = new GreenfootImage("enemy/1.png");
        setImage(sprites[0]);
    }
    public void act()
    {
        checkDirection();
        shoot();
        switchImage();
    }
    public void checkDirection()
    {
        if (shooted == false && Player.isAlive ==true)
        {
            x = getWorld().getObjects(HurtBox.class).get(0).getX();
            y = getWorld().getObjects(HurtBox.class).get(0).getY();
            turnTowards(x, y);
            shooted = true;
        }
    }
    public void shoot()
    {
        if (shooted = true)
        {   
            move(4);
            if (isTouching(HurtBox.class))
            {
                getWorld().getObjects(Player.class).get(0).hitStun(1);
                getWorld().removeObject(this); 
            }
            else if (isTouching(Wall.class)|| isTouching(Transition.class))
            {
                getWorld().removeObject(this);
            }
            else if (isTouching(Slash.class) || isTouching(Orb.class))
            {
                getWorld().removeObject(this);
            }            
        }
    }
    public void switchImage()
        {
            if( loopCount == 16)
            {
                setImage(sprites[0]);
            }
            else if( loopCount == 8)
            {
                setImage(sprites[1]);
            }
            loopCount--;
            if(loopCount == 0)
            {
                 loopCount = 16;   
            }
          
    }
}
