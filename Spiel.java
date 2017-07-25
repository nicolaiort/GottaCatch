import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Spiel
{
    private Spieler p;
    private Map m;
    private Thread thread1;
    public Spiel()
    {
        p=new Spieler("penis",new Pokemon("Pickachu",2,50,10,new Attack(10, "tackle")));
        m = new Map(p,thread1);
        p.mapSetzen(m);
        spiele();
        gameloop();
    }
    
        public void spiele()
    {
        Fenster spiel = new Fenster(p,m);
        spiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spiel.setVisible(true);
        spiel.setFocusable(true);
    }
    
    public void wait(int ms)
    {
        try
        {
            thread1.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            //
        }
    }

    public void gameloop()
    {
        while(p.returnInfight()==false)
        {
            p.refresh();
            wait(100);
            
        }
        
    }
}
