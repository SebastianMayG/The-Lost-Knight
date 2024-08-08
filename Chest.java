import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Chest extends Others
{
    protected GreenfootImage sprites[] = new GreenfootImage[3];
    protected boolean disappear;
    protected int loopCount= 6;
    protected String weapon = ""; //Sirve para especificar si queremos que aparezca un arma específica
    public Chest()
    {
        String name="chest";
        sprites[0] = new GreenfootImage("object/" +name +"/0.png");
        sprites[1] = new GreenfootImage("object/" +name +"/1.png");
        sprites[2] = new GreenfootImage("object/" +name +"/2.png");
        setImage(sprites[0]);
    }
    
    //El segundo constructor ayuda a generar esos cofres con objetos específicos
    public Chest(String weapon)
    {
        String name="chest";
        this.weapon = weapon;
        sprites[0] = new GreenfootImage("object/" +name +"/0.png");
        sprites[1] = new GreenfootImage("object/" +name +"/1.png");
        sprites[2] = new GreenfootImage("object/" +name +"/2.png");
        setImage(sprites[0]);
    }    
    
    public void act()
    {
        switchImage();
        openChest();
    }
    //metodo para cambiar la imagen del cofre cuando es tocado por el Player
    public void switchImage()
    {
      if(isTouching(Player.class))
      {
        if( loopCount == 6)
            {
                setImage(sprites[0]);
            }
        if( loopCount == 4)
            {
                setImage(sprites[1]);
            }
        if( loopCount == 1)
            {
            setImage(sprites[2]);
            Sound.sounds[3].play();
            }
            loopCount--;
      }
    }
    //metodo para desaparecer el cofre
    public void disappear()
    {
        if (disappear == false && isTouching(Player.class))
        {
           
            disappear = true;
            
        }
        if(disappear == true)
        {
            if(loopCount == 0)
            {
               getWorld().removeObject(this);
               //Player.folderName = name;
            }            
        }
    } 
    //metodo cuando se abre el cofre 
    public void openChest()
    {       
        //si toca al jugador se realiza lo siguiente
         if(isTouching(Player.class) && weapon == "")
      {
          //Cuando el loopCount del cofre llega a 0
          //Es decir cuando su ultima imagen se ejecute
          // se ejecutara el if
        if (loopCount==0)
        {
            // se Crea una varibale entera que sera un numero del 0 al 20
            int probability=Greenfoot.getRandomNumber(20);
            //Consideramos las siguientes probabilidades:
            //Katana    15%
            //Staff     15%
            //PurpleStaff 25%
            //GoldenSword 10% 
            //Heart     25%
            //RustySword 10%
              // Creamos una varibale que se igualara a las coordenadas X y Y
              // para que cuando se abra el cofre y saque el arma sera arriba del cofre
            int newY = getY()-60;
            int newX = getX()+30;
            if(probability < 3)
            {
                getWorld().addObject(new Katana(),newX + 30, newY); 
            }
            else if(probability >= 3 && probability < 6)
            {
                getWorld().addObject(new Staff(),newX + 30, newY); 
            }
            else if(probability >= 6 && probability < 11)
            {
                getWorld().addObject(new PurpleStaff(),newX + 30, newY); 
            }
            else if(probability >= 11 && probability < 13)
            {
                getWorld().addObject(new GoldenSword(),newX + 30, newY); 
            }else if(probability >= 13 && probability < 18)
            {
                getWorld().addObject(new Heart(),newX + 30, newY); 
            }
            else if(probability >= 18 && probability < 20)
            {
                getWorld().addObject(new RustySword(),newX + 30, newY); 
            }
            //Usamos el metodo de borrar de la clase Objets para borrar el cofre
            disappear();
      }
    }
    //Caso especial para el evento en la sala 3
    else if((isTouching(Player.class) && weapon != ""))
    {
            if(loopCount == 0)
            {
                switch(weapon)
                {
                     case "Katana":
                         getWorld().addObject(new Katana(),getX() - 30,getY() - 60);
                         break;
                     case "Staff":
                         getWorld().addObject(new Staff(),getX() + 30,getY() - 60);
                         break;
                }
            }
            disappear();        
    }
    }

}


