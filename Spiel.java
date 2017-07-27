import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Spiel extends Thread
{
    private Spieler p;
    private Fenster f;
    
    public Spiel(String name)
    {
        p=new Spieler(name,new Pokemon("Pickachu",4,50,10,new Attack(10, "tackle")));
        Map m = new Map(p,this,f);
        p.mapSetzen(m);
        System.out.print('\u000C');
        spiele();
       
    }
    
    public void spiele()
    {
        f = new Fenster(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setFocusable(true);
    }

    public void run()
    {
        while(true)
        {
        while(p.returnInfight()==false)
        {
            p.refresh();     
            try
            {
                sleep(200);
            }
            catch(InterruptedException ex)
            {
           
            }        
        }
    }
    }
}
