import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class MainMenu extends World
{
    IndicatorMenu Indicator = new IndicatorMenu();
    private int opcion = 0; // 0 = jugar, 1 = Salir
    public MainMenu()
    {    
        super(800, 600, 1); 
        prepareWorld();
        Greenfoot.start();
    }
    
    private void prepareWorld()
    {
        addObject(new PlayBotton(), 400, 300);
        addObject(new ExitBotton(), 400, 370);
        addObject(Indicator,270,300);
    }
    
    public void act()
    {
     if (Greenfoot.isKeyDown("UP")) { opcion = 0;}
     if (Greenfoot.isKeyDown("DOWN")) { opcion = 1;}

     Indicator.setLocation( 270, 300 +(opcion*70));
     
     if(Greenfoot.isKeyDown("SPACE") || Greenfoot.isKeyDown("ENTER")){
         switch(opcion){
             case 0:
                 Greenfoot.setWorld(new Controls());
                 break;
             case 1:
                 Greenfoot.stop();
                 break;
         }
     }
    }
}
