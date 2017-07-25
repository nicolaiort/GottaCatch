
public class DBGebiete
{
    
    public DBGebiete()
    {

    }
    
    public int gibwkeit(int gebietszahl)//Wkeit, dass ein Pokemon gespawnt wird, Wert zuwischen 0 und 10, je kleiner desto wahrscheinlicher, bis auf 0
    {
        if(gebietszahl == 3)//Gras
        {
            return 8;
        }
        if(gebietszahl == 4)//HohesGras
        {
            return 4;
        }
        return 0;
    }

}
