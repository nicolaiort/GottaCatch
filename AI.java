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

    public void machmalangriff()
    {
        try
        {
            K.schadenrechner(0,mine);
        }
        catch(InterruptedException qwertz){}        
    }
}
