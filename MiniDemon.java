import greenfoot.*;
public class MiniDemon extends Enemy
{
    public MiniDemon()
    {
        super(2,3,1,"miniDemon");
       
    }
    
    public void act()
    {
        start();
        switchImage();          
        setPlayer();
        hitStun();
        die(); 
        followPlayer();
        attackPlayer();
    }
}
