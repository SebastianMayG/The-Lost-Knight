import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; //Nos permite manipular las listas

public class Door extends Others
{
    boolean isLevelCompleted;
    boolean finished; //Hace que el método openDoor() se ejecute solo una vez
    public void act()
    {
        checkStage();
        openDoor();
    }
    
    //Examina si quedan enemigos en la zona
    //En caso de haber acabado con todos, abre la puerta y genera un transportador
    public void checkStage()
    {
        //Declaramos una lista de objetos que guardará los enemigos en el nivel
        if(isLevelCompleted == false)
        {
            ArrayList <Enemy> EnemyList = new ArrayList<Enemy>(getWorld().getObjects(Enemy.class));
            if (EnemyList.size() == 0) //El método size es de la librería ArrayList
            {
                isLevelCompleted = true;
            }
        }
    }
    //Cuando se han eliminado todos los monstruos, se genera el transportador para
    //cambiar de nivel
    public void openDoor()
    {
        if(isLevelCompleted == true && finished == false )
        {
            finished = true;
            setImage("doorOpen.png");
            getWorld().addObject(new Teleporter(), getX(), getY());
        }
    }
}