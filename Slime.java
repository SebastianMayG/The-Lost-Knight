import greenfoot.*;  
public class Slime extends Enemy
{   
    private int moveLoop = 0; //Ayuda a que el movimiento sea solo cada cierto tiempo
    public Slime()
    {
        super(2,6,1,"slime");
       
    }
    
    public void act()
    {
        start();
        switchImage();          
        setPlayer();
        hitStun();
        die(); 
        attackPlayer();
        randomMove();
    }
    
    public void randomMove()
    {   
        if(moveLoop == 0 && alive == true)
        {
            if ( Greenfoot.getRandomNumber(20) < 10)
            //genera un numero random del 0 al 19 si es menor que 10 se mueve a la derecha 
            {
                move(3);
            }
            else//si es mayor que 10 se mueve a la izquierda
            {
                move(-3);
            }
            if( Greenfoot.getRandomNumber(20) < 10)    
            {//genera un numero random del 0 al 19 si es menor que 10 hacia abajo
               setLocation(getX(),getY() + speed); 
            }
            else//si es mayor que 10 se mueve en y
            {
                setLocation(getX(),getY() - speed); 
            }
            moveLoop = 25;
        }
        moveLoop --;

    }
}