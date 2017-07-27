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
        spiele();
       
    }
    
    public void spiele()
    {
        f = new Fenster(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setFocusable(true);
        //test(f);
    }
/*    
    public void test(Frame f1)
    {
           
    {
        JDialog d = new JDialog(f1, true);
        //frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        d.setPreferredSize(new Dimension(400,100));
      
        d.setLayout (new GridLayout ());
      
        JTextField field1 = new JTextField(10);  
        d.getContentPane ().add (field1);
      
        JButton button = new JButton ("Auswählen");
        //button.addActionListener (new FooActionListener (field1, null)); //this));
        d.getContentPane ().add (button);
        d.pack ();
        d.setVisible (true);
        //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         while(fighter==null)
//         {
//             thread1.sleep(200);
//         }
//         frame.dispose();
    }
    }
*/
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
