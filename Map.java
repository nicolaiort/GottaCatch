import java.util.Random;
public class Map
{
    private Spieler spieler;
    private int xSpieler;
    private int ySpieler;
    private int gebiet;
    private int[][] platte;
    private Random zufall;
    private DBGebiete db;
    private Thread thread1;
    private Fenster f;
    
    public Map(Spieler neuerspieler, Thread t, Fenster F)
    {
        spieler = neuerspieler;
        xSpieler = spieler.gibX();
        ySpieler = spieler.gibY();
        platte = new int[100][100];
        erstelleMap();
        zufall = new Random();
        db = new DBGebiete();
        thread1 = t;
        f=F;

    }

    public boolean laeuft(int x, int y)//überprüft Barrierefreiheit
    {
        if(x<0 || y<0){return false;}
        if(x>99 || y>99){return false;}
        if(platte[x][y] == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
        
    }
    public void schritt(int x, int y)
    {
        //xy Aktualisieren, Graphikaktualisierung, Gebiet abfragen und reagieren
        xSpieler = x;
        ySpieler = y;
        //hier: Bildaktualisierung()
        gebiet = platte[x][y];
        // System.out.println(gebiet);
        if(gebiet != 0 && gebiet !=1)
        {
            if(gebiet == 2)
            {
                spieler.alleHeilen();
            }
            //also größer als 2, also Pokemonspawngebiet
            if(gebiet > 2)
            {
                if(zufall.nextInt(db.gibwkeit(gebiet))==1)//berechnet Wahrscheinlichkeit von Kampf
                {
                    kampf();
                }
            }
        }
        
    }
    
    public void erstelleMap()
    {
        //Alles auf Gras:
        for(int i=0; i<100; i++)
        {
            for( int j=0; j<100; j++)
            {
                platte[j][i] = 3; 
            }
        }
        
        //Hohes Gras:

        for( int j=0; j<27; j++)//unten links
        {
            for(int i=85; i<100; i++)
            {
                platte[j][i] = 4; 
            }
        }

        for( int j=50; j<57; j++)//oben mitte
        {
            for(int i=0; i<10; i++)
            {
                platte[j][i] = 4; 
            }
        }

        for( int j=0; j<5; j++)//links mitte
        {
            for(int i=50; i<55; i++)
            {
                platte[j][i] = 4; 
            }
        }

        for( int j=78; j<85; j++)//rechts mitte
        {
            for(int i=35; i<55; i++)
            {
                platte[j][i] = 4; 
            }
        }//
        
        
        //Fluss:

        for( int j=47; j<53; j++)
        {
            for(int i=0; i<100; i++)
            {   
                platte[j][i] = 0;
            }
        }
        
        //Weg:
        for(int i=48; i<51; i++)
        {
            for( int j=25; j<75; j++)
            {
                platte[j][i] = 1;
            }
        }
         for(int i=10; i<90; i++)
        {
            for( int j=75; j<78; j++)
            {
                platte[j][i] = 1;
            }
        }
         for(int i=0; i<90; i++)
        {
            for( int j=25; j<28; j++)
            {
                platte[j][i] = 1;
            }
        }
        
         for(int i=5; i<8; i++)
        {
            for( int j=18; j<28; j++)
            {
                platte[j][i] = 1;
            }
        }
        
        //Heilungsgebiete:
         for(int i=4; i<9; i++)
        {
            for( int j=14; j<19; j++)
            {
                platte[j][i] = 2;
            }
        }
         for(int i=87; i<92; i++)
        {
            for( int j=74; j<79; j++)
            {
                platte[j][i] = 2;
            }
        }
    }
    
    public void ausgabe()
    {
         for(int i=0; i<100; i++)
        {
            for( int j=0; j<100; j++)
            {
                System.out.print(platte[i][j]);
            }
            System.out.println();
        }
    }
    
    public void kampf()
    {
        Datenbank db= new Datenbank();
        Pokemon gegner = db.randomPoke();
        spieler.setInfight(true);
        try{
            Kampf fight = new Kampf(gegner, spieler, this, thread1,f);
        }
        catch(InterruptedException nuchanne){};
    }
    
    public int[][] gibaM()
    {
        return platte;
    }
    

}
