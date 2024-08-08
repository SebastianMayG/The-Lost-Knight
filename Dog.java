import greenfoot.*;
public class Dog extends NPC
{
    String folderName = "dog"; //Almacena el nombre de la carpeta donde se encuentran los sprites
    static GreenfootImage sprites[] = new GreenfootImage[3];
    int loopCount = 28;
    public Dog()
    {
        for(int i=0; i<3; i++)
            sprites[i] = new GreenfootImage("enemy/" +folderName + "/" +Integer.toString(i) +".png");
        
        setImage(sprites[0]);
    }
    public void act()
    {
       switchImage(); 
    }
    public void switchImage()
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
            setImage(sprites[0]);
        }
        /*else if( loopCount == 7)
        {
            setImage(sprites[0]); 
        }*/
        loopCount--;
        //Reiniciamos el ciclo
        if(loopCount == 0)
            loopCount = 28;         
    }
}
