import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//Una imagen totalmente negra que cambia su transparencia para dar la ilusión de transición
public class Transition extends Others
{
    private int loopFadeOut = 0;
    private int loopFadeIn = 255;
    private GreenfootImage fade = new GreenfootImage("black.png");
    private String name = "";
    private boolean fadeOut; //false si es fade de salida y true si es de entrada
    
    public Transition()
    {
        setImage(fade);
    }
    
    public Transition(String name)
    {
        this.name = name;
    }
    public void act()
    {   
        transition();
    }
    
    public void transition()
    {
        if(name != "")
        {
            switch(name)
            {
                case "GameOver":
                    if(loopFadeOut == 0)
                    {
                        setImage(fade);
                    }
                    if(loopFadeOut <= 255)
                    {
                        getImage().setTransparency(loopFadeOut);
                        loopFadeOut++;
                    }
                    if(loopFadeOut > 255)
                    {
                        Greenfoot.setWorld(new GameOver());
                    }
                    break;
                case "Start":
                    if(loopFadeOut == 0)
                    {
                        setImage(fade);
                    }
                    if(loopFadeOut <= 255)
                    {
                        getImage().setTransparency(loopFadeOut);
                        loopFadeOut++;
                    }
                    if(loopFadeOut > 255)
                    {
                        Greenfoot.setWorld(new MainForest());
                    }
                
            }
        }
        else if(name == "" && this != null)
        {
            if(loopFadeIn == 255)
            {
                //setImage(fade);
            }
            if(loopFadeIn >= 0)
            {
                getImage().setTransparency(loopFadeIn);
                loopFadeIn = loopFadeIn-2;
            }
            if(loopFadeIn <= 0)
            {
                getWorld().removeObject(this);
            }    
        }   
        }
}
