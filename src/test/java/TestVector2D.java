
import org.junit.Assert;
import org.junit.Test;
import pl.game.utility.Vector2D;

import java.util.Random;

public class TestVector2D {

    @Test
    public void addVector2D() {
        Random rand = new Random();
        int x1 = rand.nextInt()%10;
        int y1 = rand.nextInt()%10;
        int x2 = rand.nextInt()%10;
        int y2 = rand.nextInt()%10;

        Vector2D a = new Vector2D(x1,y1);
        Vector2D b = new Vector2D(x2,y2);
        a.add(b);

        Assert.assertEquals( "Wektor A niepoprawna wartosc X" + a.getX(),x1+x2,a.getX());
        Assert.assertEquals("Wektor A niepoprawna wartosc Y " + a.getY(), y1+y2,a.getY());
        Assert.assertEquals( "Wektor B niepoprawna wartosc X "  + b.getX(),x2,b.getX());
        Assert.assertEquals("Wektor B niepoprawna wartosc Y"  + b.getY(), y2,b.getY());
    }
}
