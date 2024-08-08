import greenfoot.*;  
public class BigDemon extends Enemy
{
    public BigDemon()
    {
        super(1,16,1,"bigDemon");
               
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
