import greenfoot.*;
public class Enemy extends Actor
{
    protected int speed;
    protected int life;
    protected int damage;
    protected String folderName; //Almacena el nombre de la carpeta donde se encuentran los sprites
    protected GreenfootImage sprites[];
    protected Player player; //Referencia al player
    protected int loopCount;
    protected int attackTimer; //Ayuda a que quite daño cada cierto tiempo
    protected boolean alive;
    protected boolean attacking; //Se activa cuando le baja vida al personaje
    protected boolean hitted; //True si es golpeado por alguna de las armas
    protected boolean canMove; //Ayuda a mantener quieto al enemigo por un tiempo antes de seguir el juego
    protected SimpleTimer timer = new SimpleTimer();
    
    public Enemy(int speed, int life, int damage, String folderName)
    {
        this.speed = speed;
        this.life = life;
        this.damage = damage;
        this.folderName = folderName;
        loopCount = 28;
        alive = true;
        hitted = false;
        canMove = false;
        //SimpleTimer timer = new SimpleTimer();
        sprites = new GreenfootImage[8];
        sprites[0] = new GreenfootImage("enemy/" +folderName +"/0.png");
        sprites[1] = new GreenfootImage("enemy/" +folderName +"/1.png");
        sprites[2] = new GreenfootImage("enemy/" +folderName +"/2.png");
        sprites[3] = new GreenfootImage("enemy/" +folderName +"/3.png");
        sprites[4] = new GreenfootImage("enemy/" +folderName +"/4.png");
        sprites[5] = new GreenfootImage("enemy/" +folderName +"/5.png");
        sprites[6] = new GreenfootImage("enemy/" +folderName +"/6.png");
        sprites[7] = new GreenfootImage("enemy/" +folderName +"/7.png");
        
        setImage(sprites[0]);
    }
        
    //Actualiza la referencia del player
    public void setPlayer()
    {
            player = (Player) getWorld().getObjects(Player.class).get(0);
    }
    
    //Hace que al inicio el enemigo no se pueda mover sino hasta después de un ciclo
    public void start()
    {
        if(canMove == false && life > 0)
        {
            if(loopCount==1)
            {
                canMove = true;
            }
        }
    }
    
    public void followPlayer()
    {
        if(canMove == true)
        {
            if(!player.equals(null) && Player.isAlive == true)
            {
                // Calcula la distancia entre el demonio y el caballero
                int dx = player.getX() - getX();
                int dy = player.getY() - getY();
                double distance = Math.sqrt(dx*dx + dy*dy);
        
                // Si la distancia es mayor que cero, mueve el demonio en la dirección del caballero
                if (distance > 0) 
                {
                    int movX = (int) Math.round(dx/distance * speed);
                    int movY = (int) Math.round(dy/distance * speed);
                    setLocation(getX()+movX, getY()+movY);
                }            
            }       
        }

    }
    
    public void switchImage()
    {
        if(life > 0 && hitted == false)
        {
            if( loopCount == 28)
            {
                setImage(sprites[1]);
            }
            else if( loopCount == 21)
            {
                setImage(sprites[2]);
            }
            else if( loopCount == 14)
            {
                setImage(sprites[3]);
            }
            else if( loopCount == 7)
            {
                setImage(sprites[0]); 
            }
            loopCount--;
            //Reiniciamos el ciclo
            if(loopCount == 0)
                loopCount = 28;     
        }        
    }
    
    //Genera una animación cuando el monstruo muere y lo elimina del mapa
    //Este método puede ser un poco problemático y causar problemas, por eso es que
    //en todos los enemigos, debe ir antes que los métodos que involucren movimiento
    //o acciones similares
    public void die()
    {
        if(life <= 0 && alive == true)
        {
            canMove = false;
            alive = false;
            loopCount = 9;
        }
        if(alive == false && this!= null)
        {
            if(loopCount == 9)
            {
                setImage(sprites[5]);
            }
            else if(loopCount == 6)
            {
                setImage(sprites[6]);
            }
            else if(loopCount == 3)
            {
                setImage(sprites[7]);
                Sound.sounds[6].play();
                    if(Greenfoot.getRandomNumber(30) == 0 )
                    {
                     getWorld().addObject(new Heart(),getX(),getY()+20);   
                    }
            }
            else if(loopCount == 0)
            {
                if(this != null)
                {
                    getWorld().removeObject(this);

                }   
            }
            loopCount--;
        }
    }
    
    //Se encarga del comportamiento del enemigo cuando es atacado por algún arma del jugador
    public void hitStun()
    {
        if(isTouching(Slash.class) && hitted == false)
        {
            canMove = false;
            hitted = true;
            setImage(sprites[4]);
            life = life - Player.damage;
            timer.mark();
            if (Player.direction == 0)
                setLocation(getX() + 8, getY());
            else if (Player.direction == 4)
                setLocation(getX() - 8, getY());
        }
        if(isTouching(Orb.class) && hitted == false)
        {
            canMove = false;
            hitted = true;
            setImage(sprites[4]);
            if(Orb.type == "green")
                life = life - 3;
            else if(Orb.type == "purple")
                life = life - 4;
        
            removeTouching(Orb.class);
            timer.mark();
        }        
        
        if(timer.millisElapsed() > 300 && hitted == true)
        {
            
            setImage(sprites[0]);   //Reestablece los valores normales de las variables cuando pase
            canMove = true;         //el tiempo establecido
            hitted = false;                    
            
            timer.mark();   
        }         
        
    }
    
    //Cuando toca la hurtBox del jugador, le hace daño cada 100 milisegundos
    public void attackPlayer()
    {
        if(life > 0 && isTouching(HurtBox.class) && attacking == false)
        {
            attacking = true;
            getWorld().getObjects(Player.class).get(0).hitStun(damage);
            attackTimer = 70;
        }
        
        if(attacking == true)
        {
            attackTimer--;
            if(attackTimer == 0)
            {
                attacking = false;
            }
        }    
    }
}