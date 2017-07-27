
import java.util.Random;
public class Datenbank
{
   private static int wasserAp = 5;
   private static int feuerAp = 6;
   private static int pflanzeAp = 4;
   private static int wasserHp = 45;
   private static int feuerHp = 38;
   private static int pflanzeHp = 50;
   private Random r= new Random(100);
   private static Attack tackle = new Attack(5,"Tackle");
   
   public Datenbank()
   {
    Attack tackle = new Attack (8,"tackle"); 
   }
   
   public Pokemon randomPoke()
  {
    if(r.nextInt(3)==1)
    {
     return erzeugeWasser();
    }
    else if (r.nextInt(3)==2)
   {
       return erzeugeFeuer();
   }
    else
   {
       return erzeugePflanze();  
   }
  }
 
   public Pokemon erzeugeWasser()
   {
    Pokemon welli = new Pokemon ("Welli",1,wasserHp,wasserAp,tackle);
    welli.gibTypAus();
    return welli;
   }
    
   public Pokemon erzeugeFeuer()
   {
    Pokemon flammi = new Pokemon ("Flammi",2,feuerHp,feuerAp,tackle) ;
    flammi.gibTypAus();
    return flammi;
  }
   
   public Pokemon erzeugePflanze()
   {
    Pokemon imuab = new Pokemon ("Imuab",3,pflanzeHp,pflanzeAp,tackle) ;
    imuab.gibTypAus();
    return imuab;
   }
    


}
