import java.util.LinkedList;

public class Spieler
{
    private String Name;
    private int xPos;
    private int yPos;
    private boolean fight;
    private LinkedList<Item> Items;
    private LinkedList<Pokemon> Pokemons;
    private boolean laufen;
    private Map map;
    
    public Spieler(String NameNeu ,Pokemon StartPokemon)
    {
        xPos = 0;
        yPos = 0;
        fight = false;
        Name = NameNeu;
        Items = new LinkedList<Item>();
        Pokemons = new LinkedList<Pokemon>();
        AddPokemon(StartPokemon);
        laufen = true;
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

    public void addItem(Item Item, int ID)
    {
        if(Items.get(ID)==null)
        {
            Items.add(ID, Item);
        }
        else
        {
            Item i = (Item)Items.get(ID);
            //i.erhoeheAnzahl();
        }
    }

    public boolean DeleteItem(int ID)
    {
        if(Items.get(ID) != null)
        {
            // ((Item)Items.get(ID)).senke();
            return true;
        }
        return false;
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
        return (Pokemon)Pokemons.get(i);
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
                    System.out.println("rechts");
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
                    System.out.println("links");
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
                    System.out.println("Oben");
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
                    System.out.println("Unten");
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
            ((Pokemon)Pokemons.get(i)).maxheal();
        }
    }
    
    public void allePokemonGeben()
    {
        for(int i=0; i < Pokemons.size(); i++)
        {
            System.out.println(i);
            Pokemon p =(Pokemon)(Pokemons.get(i));
            p.givestats();
        }
    }

}
