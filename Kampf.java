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

    public Kampf(Pokemon en, Spieler pl, Map maeb) throws InterruptedException
    {
        runde=1;
        weiter=false;
        enemy=en;
        player=pl;
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
                ki.machmalangriff();
                runde=runde+1;
            }
            else
            {    
                if(fighter==null)
                {
                    fighterWaehlen();
                }
                angriffwaehlen();
                runde=runde+1;
            }
        while(runde==rundedavor)
        {
            Thread.sleep(200);
        }
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
        JFrame frame = new JFrame ("Angriff waelen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400,100));
      
        frame.setLayout (new GridLayout ());
      
        final JTextField field1 = new JTextField(10);  
        frame.getContentPane ().add (field1);
      
        JButton button = new JButton ("Auswählen");
        button.addActionListener (new FooActionListenerZwei (field1, this));
        frame.getContentPane ().add (button);
        frame.pack ();
        frame.setVisible (true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        while(weiter==false)
        {
            Thread.sleep(200);
        }
        frame.dispose();
    }
    
    public void angriffff(int angr) throws InterruptedException
    {
        weiter=true;
        System.out.println("Angriff wurde ausgewaelt");
        schadenausteilen(enemy, fighter.getattackstrength(angr));
        weiter=false;
    }
    
    public void auswahlfenster(String name) throws InterruptedException
    {
        JFrame frame = new JFrame (name);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400,100));
      
        frame.setLayout (new GridLayout ());
      
        final JTextField field1 = new JTextField(10);  
        frame.getContentPane ().add (field1);
      
        JButton button = new JButton ("Auswählen");
        button.addActionListener (new FooActionListener (field1, this));
        frame.getContentPane ().add (button);
        frame.pack ();
        frame.setVisible (true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        while(fighter==null)
        {
            Thread.sleep(200);
        }
        frame.dispose();
    }
    
    public void schadenausteilen(Pokemon getr, int sch) throws InterruptedException
    {
        int kp = getr.getdamaged(sch);
        System.out.println("Schaden wurde ausgeteilt");
        if(kp<2)
        {
            if(getr==enemy)
            {
                //maep.KampfIstZuEndeIhrMongos();
            }
            else
            {
                System.out.println("Dein Pokemon wurde besiegt, bitte waele ein neues");
                fighter=null;
                fighterWaehlen();
                while(fighter==null){Thread.sleep(200);}
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
   
    public void fangen(Ball b)
    {
        int ballstrength = b.staerkeGeben();
        int hp = enemy.getrelativehp();
        Random generator = new Random();
        int brozend = generator.nextInt(101);
        int gef = brozend + hp - ballstrength;
        if(gef<70)
        {
            player.AddPokemon(enemy);
            //maep.KampfIstZuEndeIhrMongos();
        }
    }
} 