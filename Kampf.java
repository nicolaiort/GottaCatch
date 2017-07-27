import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Random;

public class Kampf
{

    private Pokemon enemy;
    private Pokemon fighter;
    private AI ki;
    private Spieler player;
    private Map maep;
    private int runde;
    public boolean weiter;
    private Thread thread1;
    private Fenster f1;
    
    public Kampf(Pokemon en, Spieler pl, Map maeb, Thread t, Fenster f) throws InterruptedException
    {
        runde=1;
        f1=f;
        weiter=false;
        enemy=en;
        player=pl;
        thread1 = t;
        ki=new AI(enemy,this);
        maep=maeb;
        fighter=null;
        rundebeginnen();
    }
    
    public void rundebeginnen() throws InterruptedException
    {
        int rundedavor=runde;
        if((runde % 2) == 0)
            {
                System.out.println("Das wilde Pokemon greift an");
                runde=runde+1;
                ki.machmalangriff();                
            }
            else
            {    
                if(fighter==null)
                {
                    System.out.println("Waehle ein Pokemon für den Kampf");
                    fighterWaehlen();
                }
                System.out.println("Wähle eine Attacke");
                System.out.println("0 = Angriff, 1 = Fangen");
                runde=runde+1;
                angriffwaehlen();
            }
        // while(runde==rundedavor)
        // {
            // thread1.sleep(200);
        // }
    }
    
    public void fighterWaehlen() throws InterruptedException
    {
        //Spieler soll pokemon ausgeben, mit zahl die die stelle in der Liste angibt
        player.allePokemonGeben();
        //Jetzt duerfen Jbuttons gebastelt werden YAY! :)
        auswahlfenster("Pokemon auswählen");
    }
    
    public void fighterSetzen(String fi) throws InterruptedException
    {
        int y = Integer.parseInt(fi);
        fighter= player.gibPokemon(y);
        fighter.givestats();
    }
    
    public void angriffwaehlen() throws InterruptedException
    {
        JDialog d = new JDialog(f1, true);
        //frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        d.setPreferredSize(new Dimension(400,100));
      
        d.setLayout (new GridLayout ());
      
        JTextField field1 = new JTextField(10);  
        d.getContentPane ().add (field1);
      
        JButton button = new JButton ("Auswählen");
        button.addActionListener (new FooActionListenerZwei (field1, this, d));
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
    
    public void angriffff(int angr) throws InterruptedException
    {       
        if(angr == 0)
        {
            weiter=true;
            System.out.println("Angriff wurde ausgewaehlt");
            schadenausteilen(enemy, fighter.getattackstrength(angr));
            weiter=false;
        }
        else
        {
            fangen(angr-1);
        }
    }
    
    
    public void auswahlfenster(String name) throws InterruptedException
    {
        JDialog d = new JDialog(f1, true);
        //frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        d.setPreferredSize(new Dimension(400,100));
      
        d.setLayout (new GridLayout ());
      
        JTextField field1 = new JTextField(10);  
        d.getContentPane ().add (field1);
      
        JButton button = new JButton ("Auswählen");
        button.addActionListener (new FooActionListener (field1, this, d));
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
    
//     public void auswahlfenster(String name) throws InterruptedException
//     {
//         JFrame frame = new JFrame (name);
//         frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
//         frame.setPreferredSize(new Dimension(400,100));
//       
//         frame.setLayout (new GridLayout ());
//       
//         final JTextField field1 = new JTextField(10);  
//         frame.getContentPane ().add (field1);
//       
//         JButton button = new JButton ("Auswählen");
//         button.addActionListener (new FooActionListener (field1, this));
//         frame.getContentPane ().add (button);
//         frame.pack ();
//         frame.setVisible (true);
//         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         while(fighter==null)
//         {
//             thread1.sleep(200);
//         }
//         frame.dispose();
//     }
    
    public void schadenausteilen(Pokemon getr, int sch) throws InterruptedException
    {
        int kp = getr.getdamaged(sch);
        System.out.println(sch + " Schaden wurde ausgeteilt");
        if(kp<2)
        {
            if(getr==enemy)
            {
                player.setInfight(false);
                System.out.print('\u000C');
                System.out.println("Wildes Pokemon besiegt");
                player.inventar();
            }
            else
            {
                System.out.println("Dein Pokemon wurde besiegt, bitte waehle ein neues");
                fighter=null;
                fighterWaehlen();
                while(fighter==null){thread1.sleep(200);}
                rundebeginnen();
            }
        }
        else{rundebeginnen();}
    }
    
    public void schadenrechner(int attack, Pokemon attacker) throws InterruptedException
    {
        int rawdmg=attacker.getattackstrength(attack);
        Random generator = new Random();
        int brozend = generator.nextInt(21) -10; 
        int ramdmg =(int)(rawdmg - rawdmg * 0.01 * brozend);
        if(attacker==enemy)
        {
            schadenausteilen(fighter,ramdmg);
        }
        else
        {
            schadenausteilen(enemy,ramdmg);
        }
    }
   
    public void fangen(int ID)
    {
        Ball b = (Ball) player.gibItem(ID);
        int ballstrength = b.staerkeGeben();
        int hp = enemy.getrelativehp();
        Random generator = new Random();
        int brozend = generator.nextInt(101);
        int gef = brozend + hp - ballstrength;
        player.DeleteItem(ID);
        if(gef<70)
        {
            player.AddPokemon(enemy);
            player.setInfight(false);
            System.out.print('\u000C');
            System.out.println("Das wilde Pokemon wurde gefangen:");
            enemy.givestats();
            player.inventar();
        }
    }
} 