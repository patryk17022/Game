
import org.junit.Assert;
import org.junit.Test;
import pl.game.utility.Vector2D;

public class TEST_vector2d_add {
    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        Vector2D a = new Vector2D(5,10);
        Vector2D b = new Vector2D(2,7);
        a.add(b);

        Assert.assertEquals( "Oczekiwane x: 7\n Otrzymano x: " + a.getX(),7,a.getX());
        Assert.assertEquals("Oczekiwane y: 7\n Otrzymano y: " + a.getY(), 17,a.getY());
    }
}
