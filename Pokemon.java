
import java.util.LinkedList;
public class Pokemon
{
    public String name;
    public int typ;
    public LinkedList Attack;
    public int hp;
    public int maxHp;
    public int ap;
    public Pokemon(String newName, int newTyp, int maximalHp, int newAp, Attack pokeattack)
    {
      name = newName;
      typ=newTyp;
      Attack = new LinkedList();
      Attack.add(pokeattack);
      hp=maximalHp;
      maxHp=maximalHp;
      ap=newAp;
    }

  public int getdamaged(int damage)
  {
    hp= hp-damage;
    return hp;
  }
  public int getattackstrength(int attack)
  {
   int as= ((Attack)Attack.get(attack)).getstrength()+ap;
   System.out.println("Tackle");
   return as;
  
  }
  public void maxheal()
  {
    hp=maxHp;
  }
  public void givestats()
  {
    if(hp<=2)
    {
     System.out.println("Name: "+name+", Angriffspunkte: "+ap+", Lebenspunkte: "+hp);
    }
  }
  public int getrelativehp()
  {
    int relativehp= (int)(hp/maxHp*100);
    return relativehp;
  }
  public void gibTypAus()
  {
   System.out.println(typ); 
  }
}// Dienste


