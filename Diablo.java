import greenfoot.*; 
public class Diablo extends Enemy
{
    // variable que nos permite medir cada cuanto se hace el dash del diablo
    private int loopDash=200;
    private GreenfootImage current;
    //un array para setear los dash del diablo
    //protected GreenfootImage spritesDash[];
    protected GreenfootImage spritesL[] = 
    {
        new GreenfootImage("enemy/diabloL/0.png"), //0
        new GreenfootImage("enemy/diabloL/1.png"), //1
        new GreenfootImage("enemy/diabloL/2.png"), //2
        new GreenfootImage("enemy/diabloL/3.png"),  //3 
        new GreenfootImage("enemy/diabloL/4.png")    //4
    };
    protected GreenfootImage spritesDash[] = 
    {
        new GreenfootImage("enemy/diabloDash/0.png"),   //0 derecha
        new GreenfootImage("enemy/diabloDash/1.png"),   //1 derecha
        new GreenfootImage("enemy/diabloDashL/0.png"),  //2 izquierda
        new GreenfootImage("enemy/diabloDashL/1.png"),  //3 izquierda
    };
    
    
    protected boolean direction; //false = derecha, true = izquierda
    public Diablo()
    {

        super (0,70,1,"diablo");

    }
    
    public void act()
    {
        start();
        setPlayer();        
        switchImageDash();
        changeSpeed();
        loopDashDecrease();
        hitStun();
        start();
        die();
        followPlayer();
        attackPlayer();


    }
    //metedo que nos sirve para cambiar las imagenes
    public void switchImageDash()
    {
        if(alive==true)
        {
            //por default la velocidad es 0 y mostrara las imagenes del diablo
        if (speed==0)
        {
            if(life > 0 && hitted == false)
            {
            if( loopCount == 28 && player.getX()>=301)
            {
                direction = false;
                setImage(sprites[1]);
            }
            else if( loopCount == 21 && player.getX()>=301)
            {
                setImage(sprites[2]);
            }
            else if( loopCount == 14 && player.getX()>=301)
            {
                setImage(sprites[3]);
            }
            else if( loopCount == 7 && player.getX()>=301)
            {
                setImage(sprites[0]); 
            }

            if( loopCount == 28 && player.getX()<=300)
            {
                direction = true;
                setImage(spritesL[0]);
            }
            else if( loopCount == 21 && player.getX()<=300)
            {
                setImage(spritesL[1]);
            }
            else if( loopCount == 14 && player.getX()<=300)
            {
                setImage(spritesL[2]);
            }
            else if( loopCount == 7 && player.getX()<=300)
            {
                setImage(spritesL[3]);
            }
            loopCount--;
            
            //Reiniciamos el ciclo
            if(loopCount == 0)
                loopCount = 28;     
            }       
        }
        //si la velocidad es diferente que 0 se ejecuta lo siguiente
        else
        {
            if(life > 0 && hitted == false )
            {  
                //cuando el loopDash llega a 120 y si el personaje esta en x>=301
                //mostrara las imagenes del dash
              if(loopDash==120 && player.getX()>=301)
              {
                direction = false;
                setImage(spritesDash[0]);
              }
              //aqui nuevamente pero el loopDash debe ser 110 y se monstrara otro imagen del dash
              if(loopDash==110&& player.getX()>=301)
              {
                setImage(spritesDash[1]);
              }
              //cuando el loopDash llega a 20 monstrara en pantalla el dash0 
              //y la velocidad la cambia a 0 para que se detenta de perseguir
              if (loopDash==20&& player.getX()>=301)
              {
                setImage(spritesDash[0]);
                speed=0;
              }
              //de aqui hasta abajo es lo mismo
              //solo que va cambiar de dirrecion las imagenes si x<=300
                if(loopDash==120 && player.getX()<=300)
                {
                direction = true;
                setImage(spritesDash[2]);
              }
              if(loopDash==110&& player.getX()<=300)
              {
                setImage(spritesDash[3]);
              }
              if (loopDash==20&& player.getX()<=300)
              {
                setImage(spritesDash[2]);
                speed=0;
           
              }

            } 
        }
    }
}

    //metodo en donde el loopDash disminuira
    public void loopDashDecrease()
    {
        loopDash--;
        //si el loop llega a 0 se reinicia
        if(loopDash==0)
        {
            loopDash = 200;
        }
    }
    //cuando el loop llega a 121 se cambia de velocidad
    public void changeSpeed()
    {
        if(loopDash==121)
        {
            speed=3;
        }
    }
    
    public void hitStun()
    {        
        if(isTouching(Slash.class) && hitted == false)
        {
            //canMove = false;  //El diablo si se puede mover aunque le peguen
            current = new GreenfootImage(getImage());
            hitted = true;
            if(direction)
                setImage(spritesL[4]);
            else
                setImage(sprites[4]);
            life = life - Player.damage;
            timer.mark();
            //if (Player.direction == 0)
            //    setLocation(getX() + 8, getY());
            //else if (Player.direction == 4)
            //    setLocation(getX() - 8, getY());
        }
        if(isTouching(Orb.class) && hitted == false)
        {
            //canMove = false;
            current = new GreenfootImage(getImage());
            hitted = true;
            if(direction)
                setImage(spritesL[4]);
            else
                setImage(sprites[4]);
                
            if(Orb.type == "green")
                life= life-3;
            else if(Orb.type == "purple")
                life = life - 4;
        
            removeTouching(Orb.class);
            timer.mark();
        }        
        
        if(timer.millisElapsed() > 300 && hitted == true)
        {
            
            setImage(current);   //Reestablece los valores normales de las variables cuando pase
            //canMove = true;         //el tiempo establecido
            hitted = false;                    
            
            timer.mark();   
        }         
        
    }
}
