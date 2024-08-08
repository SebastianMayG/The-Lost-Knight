import greenfoot.*;
public class Player extends Actor
{
    public static int life = 6;
    //La vida del personaje, se refleja con los corazones en pantalla
    public static String folderName = "normal";
    //Esta variable nos ayuda a poder cambiar la ruta de las imágenes fácilmente
    public static boolean isAlive = true;
    //Ayuda a manejar a prohibir el movimiento del personaje cuando este muere
    public int lastKeyPressed;
        //right = 0, left = 1, up = 2, down = 3
    public static int damage= 0; 
    //Almacena el ataque en caso de tener espada
    public static int levelsCleared;
    //Almacena la cantidad de calabozos que ha superado
    static int direction;
    //Nos ayudará a identificar si el personaje "ve" a la derecha (0) o a la izquierda(4)
    private static int speed = 3;
    //La velocidad a la que se mueve el personaje
    private boolean hurtBox;
    //Ayuda a que se cree un objeto HurtBox solo una vez
    private boolean hitStun;
    //Ayuda a que reciba daño cada cierto tiempo
    private boolean isMoving;
    //Saber si el personaje se mueve nos ayuda a cambiar las imagenes mostradas
    private static GreenfootImage sprites[] = new GreenfootImage[14];
    //Arreglo que contiene los sprites del personaje en todas sus posiciones
    private static GreenfootImage death[] = new GreenfootImage[4];
    //Sprites de desaparición
    private int loopCount = 20;
    //Esta variable es interesante, nos ayuda a mantener un control para las "animaciones"
    private SimpleTimer shotTimer = new SimpleTimer();
    private SimpleTimer attackTimer = new SimpleTimer();
    private SimpleTimer stunTime = new SimpleTimer();
    //Ayuda a mantener el control del tiempo cuando el jugador tiene el arma "Staff"

    
    public Player()
    {   
        sprites[0] = new GreenfootImage("player/" +folderName + "/right.png");
        sprites[1] = new GreenfootImage("player/" +folderName + "/right1.png");
        sprites[2] = new GreenfootImage("player/" +folderName + "/right2.png");
        sprites[3] = new GreenfootImage("player/" +folderName + "/right3.png");
        sprites[4] = new GreenfootImage("player/" +folderName + "/left.png");
        sprites[5] = new GreenfootImage("player/" +folderName + "/left1.png");
        sprites[6] = new GreenfootImage("player/" +folderName + "/left2.png");
        sprites[7] = new GreenfootImage("player/" +folderName + "/left3.png");
        sprites[8] = new GreenfootImage("player/" +folderName + "/attack1R.png");
        sprites[9] = new GreenfootImage("player/" +folderName + "/attack2R.png");
        sprites[10] = new GreenfootImage("player/" +folderName + "/attack1L.png");
        sprites[11] = new GreenfootImage("player/" +folderName + "/attack2L.png");
        sprites[12] = new GreenfootImage("player/" +folderName + "/stunR.png");
        sprites[13] = new GreenfootImage("player/" +folderName + "/stunL.png");
        
        death[0] = new GreenfootImage("player/0.png");
        death[1] = new GreenfootImage("player/1.png");
        death[2] = new GreenfootImage("player/2.png");
        death[3] = new GreenfootImage("player/3.png");
        
        setImage(sprites[direction]);
        
    }
    
    //El segundo constructor ayuda a que al inicio los valores se reestablezcan
    public Player(int x)
    {
        direction = 0;
        loopCount = 20;
        folderName = "normal";
        damage = 0;
        life = 6;
        isAlive = true;
        speed = 3;
        levelsCleared = 0;
        sprites[0] = new GreenfootImage("player/" +folderName + "/right.png");
        sprites[1] = new GreenfootImage("player/" +folderName + "/right1.png");
        sprites[2] = new GreenfootImage("player/" +folderName + "/right2.png");
        sprites[3] = new GreenfootImage("player/" +folderName + "/right3.png");
        sprites[4] = new GreenfootImage("player/" +folderName + "/left.png");
        sprites[5] = new GreenfootImage("player/" +folderName + "/left1.png");
        sprites[6] = new GreenfootImage("player/" +folderName + "/left2.png");
        sprites[7] = new GreenfootImage("player/" +folderName + "/left3.png");
        sprites[8] = new GreenfootImage("player/" +folderName + "/attack1R.png");
        sprites[9] = new GreenfootImage("player/" +folderName + "/attack2R.png");
        sprites[10] = new GreenfootImage("player/" +folderName + "/attack1L.png");
        sprites[11] = new GreenfootImage("player/" +folderName + "/attack2L.png");
        sprites[12] = new GreenfootImage("player/" +folderName + "/stunR.png");
        sprites[13] = new GreenfootImage("player/" +folderName + "/stunL.png");
        
        death[0] = new GreenfootImage("player/0.png");
        death[1] = new GreenfootImage("player/1.png");
        death[2] = new GreenfootImage("player/2.png");
        death[3] = new GreenfootImage("player/3.png");
        
        setImage(sprites[direction]);        
    }
    
    public void addHurtBox()
    {
        if(hurtBox == false)
        {
            getWorld().addObject(new HurtBox(), this.getX(), this.getY() + 19 );
            hurtBox = true;
        }
    }
    public void act()
    {
        addHurtBox(); //Solo se ejecuta al inicio
        checkImage();
        die();
        checkMove();
        checkCollision();
        attack();
        shoot();
    }
    
    public void attack()
    {
        //El ataque dura 18 frames, el método primero setea la velocidad en 0
        //para que no se pueda mover y que solo se ejecute la animación de ataque
        if (!folderName.equals("normal") && isAlive == true)
        {   
            //El condicional es para que la animacion de ataque ocurra sólo una vez cada
            //que se presiona el botón
            if(Greenfoot.isKeyDown("space") && speed > 0 && attackTimer.millisElapsed()>350)
            {
                speed = 0; //Así evitamos que se pueda mover mientras ataca
                loopCount = 18;
                
            }
            if(speed == 0)
            {
                if(direction == 0)
                {
                    if(loopCount == 18)
                    {
                        //Generamos un objeto Slash justo en donde estamos
                        if(damage > 0)
                            getWorld().addObject(new Slash(), getX(), getY());
                        
                        setImage(sprites[8]);
                    }
                    else if (loopCount == 12)
                    {
                        setImage(sprites[9]);
                    }
                    else if (loopCount == 6)
                    {
                        setImage(sprites[0]);
                    }
                }
                else if(direction == 4)
                {
                    if(loopCount == 18)
                    {
                        if(damage > 0)
                            getWorld().addObject(new Slash("L"), getX(), getY());
                        
                        setImage(sprites[10]);
                    }
                    else if (loopCount == 12)
                    {
                        setImage(sprites[11]);
                    }
                    else if (loopCount == 6)
                    {
                        setImage(sprites[4]);
                    }   
                }
                loopCount--;
                attackTimer.mark();
                //Una vez termina la animación, se regresa todo a sus valores normales
                if(loopCount == -1)
                {
                    //Retiramos el objeto de la clase slash que creamos al inicio de la animación
                    if(isTouching(Slash.class))
                        removeTouching(Slash.class);
                        
                    speed = 3;
                    loopCount = 20;
                }
            }
            }            
        }
    
    //Este método se encarga de manejar la acción de disparar cuando el personaje tiene el 
    //báculo ("Staff")
    public void shoot()
    {
        if(isAlive == true)
        {
        if(folderName == "staff") //Si el personaje tiene el báculo
        {
            if (Greenfoot.isKeyDown("space") && shotTimer.millisElapsed()>500)
            {
                //genera las bullet
                getWorld().addObject(new Orb(lastKeyPressed, "green"), getX(), getY());
                Sound.sounds[2].play();
                //la variable se va a reiniciar con el metodo mark()   
                shotTimer.mark();
            }            
        }
        else if(folderName == "purpleStaff") //Si el personaje tiene el báculo
        {
            if (Greenfoot.isKeyDown("space") && shotTimer.millisElapsed()>900)
            {
                //genera las bullet
                getWorld().addObject(new Orb(lastKeyPressed, "purple"), getX(), getY());
                Sound.sounds[7].play();
                //la variable se va a reiniciar con el metodo mark()   
                shotTimer.mark();
            }            
        }
        }
    }
        
    //Este método se encarga del movimiento del personaje y del control de animaciones
    //Primero evalúa que la velocidad no sea 0, osea que el personaje se pueda mover,
    //luego, si alguna de las flechas direccionales es presionada, la variable loopCount
    //disminuirá, llevando así el control de nuestras animaciones
    //Después, evalúa y genera acciones para cada flecha direccional
    public void checkMove()
    {
       if (speed == 3 && isAlive == true)
       {
           if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down"))
           {
              //loopCount--;
              Sound.sounds[8].play();
              isMoving = true; 
              if(Greenfoot.isKeyDown("right"))
              {
                   direction = 0;
                   move(speed);
                   lastKeyPressed=0;
                   if( loopCount == 20)
                   {
                       setImage(sprites[1]);
                   }
                   else if( loopCount == 15)
                   {
                       setImage(sprites[2]);
                   }
                   else if( loopCount == 10)
                   {
                       setImage(sprites[3]);
                   }
                   else if( loopCount == 5)
                   {
                      setImage(sprites[0]); 
                   }
              }
              else if(Greenfoot.isKeyDown("left"))
              {
                   direction = 4;
                   move(-speed);
                   lastKeyPressed=1;
                   if( loopCount == 20)
                   {
                       setImage(sprites[5]);
                   }
                   else if(loopCount == 15)
                   {
                       setImage(sprites[6]);
                   }
                   else if(loopCount == 10)
                   {
                       setImage(sprites[7]);
                   }
                   else if(loopCount == 5)
                   {
                       setImage(sprites[4]); 
                   }                  
              }
              else if(Greenfoot.isKeyDown("up"))//Como no tenemos sprites hacia arriba o hacia abajo
              //debemos considerar hacia qué lado mira el personaje para saber qué animaciones poner
              {
                  setLocation(getX(), getY() - speed);
                  lastKeyPressed=2;
                  if(direction == 0)//Si está viendo a la derecha
                  {
                       if( loopCount == 20)
                       {
                           setImage(sprites[1]);
                       }
                       else if( loopCount == 15)
                       {
                           setImage(sprites[2]);
                       }
                       else if( loopCount == 10)
                       {
                           setImage(sprites[3]);
                       }
                       else if( loopCount == 5)
                       {
                          setImage(sprites[0]); 
                       }                      
                  }
                  else if(direction == 4)//Si está viendo a la izquierda
                  {
                       if( loopCount == 20)
                       {
                           setImage(sprites[5]);
                       }
                       else if( loopCount == 15)
                       {
                           setImage(sprites[6]);
                       }
                       else if( loopCount == 10)
                       {
                           setImage(sprites[7]);
                       }
                       else if( loopCount == 5)
                       {
                          setImage(sprites[4]); 
                       }                                            
                  }
              }
              else if(Greenfoot.isKeyDown("down"))
              {
                  lastKeyPressed=3;
                  setLocation(getX(), getY() + speed);
                  if(direction == 0)//Si está viendo a la derecha
                  {
                       if( loopCount == 20)
                       {
                           setImage(sprites[1]);
                       }
                       else if( loopCount == 15)
                       {
                           setImage(sprites[2]);
                       }
                       else if( loopCount == 10)
                       {
                           setImage(sprites[3]);
                       }
                       else if( loopCount == 5)
                       {
                          setImage(sprites[0]); 
                       }                      
                  }
                  else if(direction == 4)//Si está viendo a la izquierda
                  {
                       if( loopCount == 20)
                       {
                           setImage(sprites[5]);
                       }
                       else if( loopCount == 15)
                       {
                           setImage(sprites[6]);
                       }
                       else if( loopCount == 10)
                       {
                           setImage(sprites[7]);
                       }
                       else if( loopCount == 5)
                       {
                          setImage(sprites[4]); 
                       }                                            
                  }
                  
              }
              loopCount--;
              //Reiniciamos el ciclo
              if(loopCount == 0)
                  loopCount = 20;           
            }
           else //cuando no se presiona ninguna tecla de movimiento
           {
               isMoving = false;
               loopCount = 20;
               setImage(sprites[direction]);
           }
       }
    }
    
    //Se encarga de la animación cuando el personaje recibe daño
    public void hitStun(int damage)
    {
        speed = 1;
        life = life - damage;
        if(direction == 0)
            setImage(sprites[12]);
        else if(direction == 4)
            setImage(sprites[13]);
        
        
        if(stunTime.millisElapsed()>30)
        {
            speed = 3;
            stunTime.mark();
        }
    }
    
    public void die()
    {
        if(life <= 0 && isAlive == true)
        {
            speed = 0;
            isAlive = false;
            loopCount = 12;
        }
        if(isAlive == false && loopCount >= 0)
        {
            if(loopCount == 12)
            {
                setImage(death[0]);
            }
            else if(loopCount == 8)
            {
                setImage(death[1]);
            }
            else if(loopCount == 4)
            {
                setImage(death[2]);
            }
            else if(loopCount == 0)
            {
                setImage(death[3]);
                getWorld().removeObject(getWorld().getObjects(HurtBox.class).get(0));
                getWorld().addObject(new Transition("GameOver"), 400, 300);
            }
            loopCount--;
        }    
    }
    
    //Hace que no atraviese los objetos y NPC's
    public void checkCollision()
    {
        if(getOneIntersectingObject(Objects.class)!= null || getOneIntersectingObject(NPC.class)!= null)
        {
            if(Greenfoot.isKeyDown("right"))
            {
               move(-speed); 
            }
            else if(Greenfoot.isKeyDown("left"))
            {
               move(speed); 
            }
            else if(Greenfoot.isKeyDown("up"))
            {
               setLocation(getX(),getY()+speed); 
            }
            else if(Greenfoot.isKeyDown("down"))
            {
               setLocation(getX(),getY() - speed); 
            }
        }
    }
    
    //Cambia los sprites dependiendo del arma que tenga
    public void checkImage()
    {
        if(folderName == "normal" && !sprites[0].equals("player/" +folderName + "/right.png"))
        {
            sprites[0] = new GreenfootImage("player/" +folderName + "/right.png");
            sprites[1] = new GreenfootImage("player/" +folderName + "/right1.png");
            sprites[2] = new GreenfootImage("player/" +folderName + "/right2.png");
            sprites[3] = new GreenfootImage("player/" +folderName + "/right3.png");
            sprites[4] = new GreenfootImage("player/" +folderName + "/left.png");
            sprites[5] = new GreenfootImage("player/" +folderName + "/left1.png");
            sprites[6] = new GreenfootImage("player/" +folderName + "/left2.png");
            sprites[7] = new GreenfootImage("player/" +folderName + "/left3.png");
            sprites[8] = new GreenfootImage("player/" +folderName + "/attack1R.png");
            sprites[9] = new GreenfootImage("player/" +folderName + "/attack2R.png");
            sprites[10] = new GreenfootImage("player/" +folderName + "/attack1L.png");
            sprites[11] = new GreenfootImage("player/" +folderName + "/attack2L.png");
            sprites[12] = new GreenfootImage("player/" +folderName + "/stunR.png");
            sprites[13] = new GreenfootImage("player/" +folderName + "/stunL.png");
        }        
        if(folderName == "rustySword" && !sprites[0].equals("player/" +folderName + "/right.png"))
        {
            sprites[0] = new GreenfootImage("player/" +folderName + "/right.png");
            sprites[1] = new GreenfootImage("player/" +folderName + "/right1.png");
            sprites[2] = new GreenfootImage("player/" +folderName + "/right2.png");
            sprites[3] = new GreenfootImage("player/" +folderName + "/right3.png");
            sprites[4] = new GreenfootImage("player/" +folderName + "/left.png");
            sprites[5] = new GreenfootImage("player/" +folderName + "/left1.png");
            sprites[6] = new GreenfootImage("player/" +folderName + "/left2.png");
            sprites[7] = new GreenfootImage("player/" +folderName + "/left3.png");
            sprites[8] = new GreenfootImage("player/" +folderName + "/attack1R.png");
            sprites[9] = new GreenfootImage("player/" +folderName + "/attack2R.png");
            sprites[10] = new GreenfootImage("player/" +folderName + "/attack1L.png");
            sprites[11] = new GreenfootImage("player/" +folderName + "/attack2L.png");
            sprites[12] = new GreenfootImage("player/" +folderName + "/stunR.png");
            sprites[13] = new GreenfootImage("player/" +folderName + "/stunL.png");
        }
        if(folderName == "staff" && !sprites[0].equals("player/" +folderName + "/right.png"))
        {
            sprites[0] = new GreenfootImage("player/" +folderName + "/right.png");
            sprites[1] = new GreenfootImage("player/" +folderName + "/right1.png");
            sprites[2] = new GreenfootImage("player/" +folderName + "/right2.png");
            sprites[3] = new GreenfootImage("player/" +folderName + "/right3.png");
            sprites[4] = new GreenfootImage("player/" +folderName + "/left.png");
            sprites[5] = new GreenfootImage("player/" +folderName + "/left1.png");
            sprites[6] = new GreenfootImage("player/" +folderName + "/left2.png");
            sprites[7] = new GreenfootImage("player/" +folderName + "/left3.png");
            sprites[8] = new GreenfootImage("player/" +folderName + "/attack1R.png");
            sprites[9] = new GreenfootImage("player/" +folderName + "/attack2R.png");
            sprites[10] = new GreenfootImage("player/" +folderName + "/attack1L.png");
            sprites[11] = new GreenfootImage("player/" +folderName + "/attack2L.png");
            sprites[12] = new GreenfootImage("player/" +folderName + "/stunR.png");
            sprites[13] = new GreenfootImage("player/" +folderName + "/stunL.png");
        }
        if(folderName == "purpleStaff" && !sprites[0].equals("player/" +folderName + "/right.png"))
        {
            sprites[0] = new GreenfootImage("player/" +folderName + "/right.png");
            sprites[1] = new GreenfootImage("player/" +folderName + "/right1.png");
            sprites[2] = new GreenfootImage("player/" +folderName + "/right2.png");
            sprites[3] = new GreenfootImage("player/" +folderName + "/right3.png");
            sprites[4] = new GreenfootImage("player/" +folderName + "/left.png");
            sprites[5] = new GreenfootImage("player/" +folderName + "/left1.png");
            sprites[6] = new GreenfootImage("player/" +folderName + "/left2.png");
            sprites[7] = new GreenfootImage("player/" +folderName + "/left3.png");
            sprites[8] = new GreenfootImage("player/" +folderName + "/attack1R.png");
            sprites[9] = new GreenfootImage("player/" +folderName + "/attack2R.png");
            sprites[10] = new GreenfootImage("player/" +folderName + "/attack1L.png");
            sprites[11] = new GreenfootImage("player/" +folderName + "/attack2L.png");
            sprites[12] = new GreenfootImage("player/" +folderName + "/stunR.png");
            sprites[13] = new GreenfootImage("player/" +folderName + "/stunL.png");
        }
        if(folderName == "goldenSword" && !sprites[0].equals("player/" +folderName + "/right.png"))
        {
            sprites[0] = new GreenfootImage("player/" +folderName + "/right.png");
            sprites[1] = new GreenfootImage("player/" +folderName + "/right1.png");
            sprites[2] = new GreenfootImage("player/" +folderName + "/right2.png");
            sprites[3] = new GreenfootImage("player/" +folderName + "/right3.png");
            sprites[4] = new GreenfootImage("player/" +folderName + "/left.png");
            sprites[5] = new GreenfootImage("player/" +folderName + "/left1.png");
            sprites[6] = new GreenfootImage("player/" +folderName + "/left2.png");
            sprites[7] = new GreenfootImage("player/" +folderName + "/left3.png");
            sprites[8] = new GreenfootImage("player/" +folderName + "/attack1R.png");
            sprites[9] = new GreenfootImage("player/" +folderName + "/attack2R.png");
            sprites[10] = new GreenfootImage("player/" +folderName + "/attack1L.png");
            sprites[11] = new GreenfootImage("player/" +folderName + "/attack2L.png");
            sprites[12] = new GreenfootImage("player/" +folderName + "/stunR.png");
            sprites[13] = new GreenfootImage("player/" +folderName + "/stunL.png");
        }      
        
        if(folderName == "katana" && !sprites[0].equals("player/" +folderName + "/right.png"))
        {
            sprites[0] = new GreenfootImage("player/" +folderName + "/right.png");
            sprites[1] = new GreenfootImage("player/" +folderName + "/right1.png");
            sprites[2] = new GreenfootImage("player/" +folderName + "/right2.png");
            sprites[3] = new GreenfootImage("player/" +folderName + "/right3.png");
            sprites[4] = new GreenfootImage("player/" +folderName + "/left.png");
            sprites[5] = new GreenfootImage("player/" +folderName + "/left1.png");
            sprites[6] = new GreenfootImage("player/" +folderName + "/left2.png");
            sprites[7] = new GreenfootImage("player/" +folderName + "/left3.png");
            sprites[8] = new GreenfootImage("player/" +folderName + "/attack1R.png");
            sprites[9] = new GreenfootImage("player/" +folderName + "/attack2R.png");
            sprites[10] = new GreenfootImage("player/" +folderName + "/attack1L.png");
            sprites[11] = new GreenfootImage("player/" +folderName + "/attack2L.png");
            sprites[12] = new GreenfootImage("player/" +folderName + "/stunR.png");
            sprites[13] = new GreenfootImage("player/" +folderName + "/stunL.png");
        }
    }
     
}
