import greenfoot.*; 
//Puede ser verde o morado, cambiando su comportamiento
public class Orb extends Others
{
    final int lastKeyPressed;
    static int lastKeyPressed2;
    public static String type;
    //Es una variable final para que no se cambie aún cuando el personaje se siga moviendo
    
    public Orb(int key, String type)
    {
        this.type = type;
        lastKeyPressed = key;
        lastKeyPressed2 = key;
        if(type == "green")
        {
            setImage("weapon/orbG.png");            
        }
        else if(type == "purple")
        {
            setImage("weapon/orbP.png");
        }
    }    
    
    public void act()
    {
        shoot();
    }
    
    //Método que se encarga del movimiento de tiro del orbe
    public void shoot()
    {
        if(type == "green")
        {
            if(lastKeyPressed == 0)
            {
                // el 8 indica la velocidad de la bala
                setLocation(getX()+8, getY());
                //La clase Enemy la inicalizamos a una variable luego y toca una bala va ser !=null
                Enemy e =(Enemy) getOneIntersectingObject(Enemy.class);
                if(e != null)
                {
                    //getWorld().removeObject(this);
                }
                else if (getX()>795)
                {
                // Remueve a la bala si no le da y lo remueve al borde del mapa
                   getWorld().removeObject(this); 
                }     
            }
            else if(lastKeyPressed == 1)
            {
                setLocation(getX()-8, getY());
                Enemy e =(Enemy) getOneIntersectingObject(Enemy.class);
                if(e != null)
                {
                    //getWorld().removeObject(this);
                }
                else if (getX()<5)
                {
                   getWorld().removeObject(this); 
                }              
            }
            else if(lastKeyPressed == 2)
            {      
                setLocation(getX(), getY()-8);
                Enemy e =(Enemy) getOneIntersectingObject(Enemy.class);
                if(e != null)
                {
                    //getWorld().removeObject(this);
                }
                else if (getY()<5)
                {
                    getWorld().removeObject(this); 
                }     
            }
            else if(lastKeyPressed == 3)
            {
                setLocation(getX(), getY()+8);
                Enemy e =(Enemy) getOneIntersectingObject(Enemy.class);
                if(e != null)
                {
                    //getWorld().removeObject(this);
                }
                else if (getY()>595)
                {
                   getWorld().removeObject(this); 
                }            
            }    
        }
        else if(type == "purple")
        {
            if( Greenfoot.isKeyDown("right"))
            {
                lastKeyPressed2 = 0;
                // el 8 indica la velocidad de la bala
                setLocation(getX()+8, getY());
                //La clase Enemy la inicalizamos a una variable luego y toca una bala va ser !=null
                Enemy e =(Enemy) getOneIntersectingObject(Enemy.class);
                if(e != null)
                {
                    //getWorld().removeObject(this);
                }
                else if (getX()>795)
                {
                // Remueve a la bala si no le da y lo remueve al borde del mapa
                   getWorld().removeObject(this); 
                }     
            }
            else if( Greenfoot.isKeyDown("left"))
            {
                lastKeyPressed2 = 1;
                setLocation(getX()-8, getY());
                Enemy e =(Enemy) getOneIntersectingObject(Enemy.class);
                if(e != null)
                {
                    //getWorld().removeObject(this);
                }
                else if (getX()<5)
                {
                   getWorld().removeObject(this); 
                }              
            }
            else if( Greenfoot.isKeyDown("up"))
            {    
                lastKeyPressed2 = 2;
                setLocation(getX(), getY()-8);
                Enemy e =(Enemy) getOneIntersectingObject(Enemy.class);
                if(e != null)
                {
                    //getWorld().removeObject(this);
                }
                else if (getY()<5)
                {
                    getWorld().removeObject(this); 
                }     
            }
            else if( Greenfoot.isKeyDown("down"))
            {
                lastKeyPressed2 = 3;
                setLocation(getX(), getY()+8);
                Enemy e =(Enemy) getOneIntersectingObject(Enemy.class);
                if(e != null)
                {
                    //getWorld().removeObject(this);
                }
                else if (getY()>595)
                {
                   getWorld().removeObject(this); 
                }            
            }
            else if(lastKeyPressed2 == 0)
            {
                // el 8 indica la velocidad de la bala
                setLocation(getX()+8, getY());
                //La clase Enemy la inicalizamos a una variable luego y toca una bala va ser !=null
                Enemy e =(Enemy) getOneIntersectingObject(Enemy.class);
                if(e != null)
                {
                    //getWorld().removeObject(this);
                }
                else if (getX()>795)
                {
                // Remueve a la bala si no le da y lo remueve al borde del mapa
                   getWorld().removeObject(this); 
                }     
            }
            else if(lastKeyPressed2 == 1)
            {
                setLocation(getX()-8, getY());
                Enemy e =(Enemy) getOneIntersectingObject(Enemy.class);
                if(e != null)
                {
                    //getWorld().removeObject(this);
                }
                else if (getX()<5)
                {
                   getWorld().removeObject(this); 
                }              
            }
            else if(lastKeyPressed2 == 2)
            {      
                setLocation(getX(), getY()-8);
                Enemy e =(Enemy) getOneIntersectingObject(Enemy.class);
                if(e != null)
                {
                    //getWorld().removeObject(this);
                }
                else if (getY()<5)
                {
                    getWorld().removeObject(this); 
                }     
            }
            else if(lastKeyPressed2 == 3)
            {
                setLocation(getX(), getY()+8);
                Enemy e =(Enemy) getOneIntersectingObject(Enemy.class);
                if(e != null)
                {
                    //getWorld().removeObject(this);
                }
                else if (getY()>595)
                {
                   getWorld().removeObject(this); 
                }            
            }            
        }

    }
}
