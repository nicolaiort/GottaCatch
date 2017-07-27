import java.util.Random;
public class AI
{
    
    private Pokemon mine;
    private Kampf K;
    public AI(Pokemon m, Kampf Ka)
    {
        mine=m;
        K=Ka;
    }

    // Dienste
    public void machmalangriff()
    {
        Random generator = new Random();
        int dmg = generator.nextInt(5)+1;
        
        try
        {
            K.schadenrechner(0,mine);
        }
        catch(InterruptedException qwertz){}
        
    }
}
