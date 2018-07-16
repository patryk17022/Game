
import org.junit.Assert;
import org.junit.Test;
import pl.game.utility.Vector2D;

public class TEST_vector2d_add {
    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        Vector2D a = new Vector2D(5,10);
        Vector2D b = new Vector2D(2,7);
        a.add(b);

        Assert.assertEquals( "Oczekiwane x dla a: 7\n Otrzymano x: " + a.getX(),7,a.getX());
        Assert.assertEquals("Oczekiwane y dla a: 7\n Otrzymano y: " + a.getY(), 17,a.getY());
        Assert.assertEquals( "Oczekiwane x dla b: 7\n Otrzymano x: " + b.getX(),2,b.getX());
        Assert.assertEquals("Oczekiwane y dla b: 7\n Otrzymano y: " + b.getY(), 7,b.getY());
    }
}
