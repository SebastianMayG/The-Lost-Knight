import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DungeonRandom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DungeonRandom extends Dungeon
{
    final static GreenfootImage imagen1 = new GreenfootImage("Dungeon03.png");
    final static GreenfootImage imagen2 = new GreenfootImage("Dungeon02.png");
    final static GreenfootImage imagen3 = new GreenfootImage("dungeonSlime.png");
    
    public DungeonRandom()
    {
        super();
        //setBckgrnd();
        prepare();
        setBckgrnd();
        
    }
    //Hace que haya diferentes fondos
    public void setBckgrnd()
    {
        int number = Greenfoot.getRandomNumber(5);
        if(number < 2)
        {
            setBackground(imagen1);
        }
        else if(number >= 2 && number <= 3)
        {
            setBackground(imagen2);
        }
        else if(number == 4)
        {
            setBackground(imagen3);
        }
    }
    
    public void prepare()
    {
        int spawnSlimesL = Greenfoot.getRandomNumber(10); //Cuadrante izquierdo
        int spawnSlimesR = Greenfoot.getRandomNumber(10); //Cuadrante derecho
        int spawnMiniDemon = Greenfoot.getRandomNumber(10);
        int spawnDragon1 = Greenfoot.getRandomNumber(10); //Cuadrante superior izquierda
        int spawnDragon2 = Greenfoot.getRandomNumber(10); //Cuadrante superior derecha
        int spawnDragon3 = Greenfoot.getRandomNumber(10); //Cuadrante inferior izquierda
        int spawnDragon4 = Greenfoot.getRandomNumber(10); //Cuadrante inferior derecha
        int spawnBigDemon = Greenfoot.getRandomNumber(10);
        int spawnChest = Greenfoot.getRandomNumber(10);
        if(spawnSlimesL < 9)
        {               //Coordenadas en X y Y dentro de su respectivo cuadrante
            addObject(new Slime(), getRandomNumber(101,245),getRandomNumber(250,404));
        }
        if(spawnSlimesL < 7)
        {               //Coordenadas en X y Y dentro de su respectivo cuadrante
            addObject(new Slime(), getRandomNumber(101,245),getRandomNumber(250,404));
        }
        if(spawnSlimesR < 9)
        {               //Coordenadas en X y Y dentro de su respectivo cuadrante
            addObject(new Slime(), getRandomNumber(555,700),getRandomNumber(250,404));
        }
        if(spawnSlimesR < 7)
        {               //Coordenadas en X y Y dentro de su respectivo cuadrante
            addObject(new Slime(), getRandomNumber(555,700),getRandomNumber(250,404));
        }
        
        if(spawnMiniDemon < 9)
        {
            addObject(new MiniDemon(), getRandomNumber(200,605), getRandomNumber(96,250));
        }
        if(spawnMiniDemon < 6)
        {
            addObject(new MiniDemon(), getRandomNumber(200,605), getRandomNumber(96,250));
        }
        if(spawnMiniDemon < 1)
        {
            addObject(new MiniDemon(), getRandomNumber(200,605), getRandomNumber(96,250));
        }
        
        if(spawnDragon1 < 5)
        {
            addObject(new DragonR(), getRandomNumber(101,200),getRandomNumber(96,250));
        }
        if(spawnDragon2 < 5)
        {
            addObject(new DragonL(), getRandomNumber(605,700),getRandomNumber(96,250));
        }
        if(spawnDragon3 < 5)
        {
            addObject(new DragonR(), getRandomNumber(101,200),getRandomNumber(404,540));
        }
        if(spawnDragon4 < 5)
        {
            addObject(new DragonL(), getRandomNumber(605,700),getRandomNumber(404,540));
        }
        
        if(spawnBigDemon < 8)
        {
            addObject(new BigDemon(), getRandomNumber(200,605), getRandomNumber(96,250));
        }
        if(spawnBigDemon < 2)
        {
            addObject(new BigDemon(), getRandomNumber(200,605), getRandomNumber(96,250));
        }
        
        if(spawnChest < 8)
        {
            addObject(new Chest(), 594, 513);
        }
    }
    
    //Método para generar un número al azar entre dos números límites
    public int getRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
}
