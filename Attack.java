
public class Attack
{
    public int strength;
    String name;
    public Attack(int newStregth, String n)
    {
     strength= newStregth;
     name=n;
    }
    public int getstrength()
    {
     return strength;
    }
    public void ausgabe()
    {
        System.out.println("Name: "+name+ " Stärke: " +strength);
    }

}
