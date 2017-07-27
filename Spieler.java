import java.util.LinkedList;

public class Spieler
{
    private String Name;
    private int xPos;
    private int yPos;
    private boolean fight;
    private LinkedList<Ball> Items;
    private LinkedList<Pokemon> Pokemons;
    private boolean laufen;
    private Map map;
    
    public Spieler(String NameNeu ,Pokemon StartPokemon)
    {
        xPos = 0;
        yPos = 0;
        fight = false;
        Name = NameNeu;
        Items = new LinkedList<Ball>();
        addItem(new Ball(10,"Pokeball",10),1);
        Pokemons = new LinkedList<Pokemon>();
        AddPokemon(StartPokemon);
        laufen = true;
        inventar();
    }
    
    public void mapSetzen(Map m)
    {
        map=m;
    }

    public int gibX()
    {
        return xPos;
    }

    public int gibY()
    {
        return yPos;
    }

    public void AddPokemon(Pokemon Pokemon)
    {
        Pokemons.add(Pokemon);
    }

    public int PokemonAnzahl()
    {
        return Pokemons.size();
    }

    public int ItemsAnzahl()
    {
        return Items.size();
    }

    public void addItem(Ball Item, int ID)
    {
        if(Items.size()<ID)
        {
            Items.add(Item);
        }
        else
        {
            Item i =Items.get(ID);
            i.erhoeheAnzahl();
        }
    }

        public boolean Itemvorhanden(int ID)
    {
        if(Items.get(ID) != null)
        {
            return true;
        }
        return false;
    }
    
    public void DeleteItem(int ID)
    {
        (Items.get(ID)).senke();
    }

    public void setInfight(boolean b)
    {
        fight = b;    
    }

    public boolean returnInfight()
    {
        return fight;
    }

    public Pokemon gibPokemon(int i)
    {
        return Pokemons.get(i);
    }
    
    public Ball gibItem(int i)
    {
        return Items.get(i);
    }

    public void refresh()
    {
        laufen=true;
    }

    public void nachRechts(boolean b)
    {
        if(laufen==true)
        {
            if(b==true)
            {

                if(map.laeuft(xPos+1,yPos))
                {
                    // System.out.println("rechts");
                    xPos=xPos+1;
                    map.schritt(xPos,yPos);
                    laufen=false;  
                }

            }
        }
    }

    public void nachLinks(boolean b)
    {
        if(laufen==true)
        {
            if(b==true)
            {

                if(map.laeuft(xPos-1,yPos))
                {
                    // System.out.println("links");
                    xPos=xPos-1;
                    map.schritt(xPos,yPos);
                    laufen=false;    
                }

            }
        }
    }

    public void nachOben(boolean b)
    {
        if(laufen==true)
        {
            if(b==true)
            {

                if(map.laeuft(xPos,yPos-1))
                {
                    // System.out.println("Oben");
                    yPos=yPos-1;
                    map.schritt(xPos,yPos);
                    laufen=false;      
                }

            }
        }
    }

    public void nachUnten(boolean b)
    {
        if(laufen==true)
        {
            if(b==true)
            {

                if(map.laeuft(xPos,yPos+1))
                {
                    // System.out.println("Unten");
                    yPos=yPos+1;
                    map.schritt(xPos,yPos);
                    laufen=false;       
                }

            }
        }
    }

    public void alleHeilen()
    {
        for(int i=0; i < Pokemons.size(); i++)
        {
            (Pokemons.get(i)).maxheal();
        }
        addItem(new Ball(10,"Pokeball",1),0);
        System.out.print('\u000C');
        System.out.println("Alle deine Pokemons wurden geheilt und du hast einen Pokeball bekommen");
        inventar();
    }
    
    public void allePokemonGeben()
    {
        for(int i=0; i < Pokemons.size(); i++)
        {
            System.out.println(i);
            Pokemon p =(Pokemons.get(i));
            p.givestats();
        }
    }
    
    public void alleItemGeben()
    {
        for(int i=0; i < Items.size(); i++)
        {
            System.out.println(i);
            Ball p =(Items.get(i));
            p.givestats();
        }
    }
    
    public void inventar()
    {
        System.out.println("");
        System.out.println("Pokemons:");
        allePokemonGeben();
        System.out.println("");
        System.out.println("Items:");
        alleItemGeben();
        
    }
}
