import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public abstract class Weapon extends Actor
{
    public String name;
    public int damage;
    
    protected GreenfootImage sprites[] = new GreenfootImage[4];
    protected boolean disappear;
    protected int loopCount= 36;
    
    public Weapon(String name, int damage)
    {
        this.name = name;
        this.damage = damage;
        
        sprites[0] = new GreenfootImage("weapon/" +name +"/0.png");
        sprites[1] = new GreenfootImage("weapon/" +name +"/1.png");
        sprites[2] = new GreenfootImage("weapon/" +name +"/2.png");
        sprites[3] = new GreenfootImage("weapon/" +name +"/3.png");
        
        setImage(sprites[0]);
    }
    
    public void switchImage()
    {
        if(disappear == false)
        {
            if( loopCount == 36)
            {
                setImage(sprites[0]);
            }
            else if( loopCount == 27)
            {
                setImage(sprites[1]);
            }
            else if( loopCount == 18)
            {
                setImage(sprites[2]);
            }
            else if( loopCount == 9)
            {
                setImage(sprites[1]); 
            }
            loopCount--;
            //Reiniciamos el ciclo
            if(loopCount == 0)
                loopCount = 36;    
        }  
    }
    
    //El objeto es removido cuando toca a el jugador
    public void disappear()
    {
        if (disappear == false && isTouching(HurtBox.class))
        {
            loopCount = 6;
            disappear = true;
            Sound.sounds[0].play();
            setImage(sprites[3]);
        }
        if(disappear == true)
        {
            loopCount--;
            if(loopCount == 0)
            {
               getWorld().removeObject(this);
               Player.folderName = name;
               Player.damage = damage;
            }            
        }
    }    
}
