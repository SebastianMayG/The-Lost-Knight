import greenfoot.*;
public class DragonR extends Enemy
{
    private int timeSinceLastAttack = 0;//comenzando en el frame 0
    private SimpleTimer shotTimer = new SimpleTimer();
    
    public DragonR()
    {
        super(0,8,0, "dragonR");
    }
    
    public void act()
    {
        start();
        switchImage();          
        setPlayer();
        hitStun();
        die();
        shoot();
        timeSinceLastAttack++;//se van aumentanto los "frames"
    }

    private void shoot() 
    { 
        if (timeSinceLastAttack >= 190 && alive == true)
        {
            //genera las bolas de fuego
            getWorld().addObject(new fireBall(), getX(), getY());
            Sound.sounds[5].play();
            //la variable se va a reiniciar con el metodo mark()   
            shotTimer.mark();
            timeSinceLastAttack = 0;//variable para que reinicie desde que ataco la ultima vez
         }  
    }
}
