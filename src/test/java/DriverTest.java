import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;



public class DriverTest {
    public DriverTest() {
    }

    @Test
    public void testSquareRoot(){
        Assert.assertEquals(2.0,Driver.findsquareRoot(4),0);
        Assert.assertEquals(1.0,Driver.findsquareRoot(1),0);
        Assert.assertEquals(0.0,Driver.findsquareRoot(0),0);

        assertNotEquals(0,Driver.findsquareRoot(4),0);
        assertNotEquals(4,Driver.findsquareRoot(15),0);
    }

    @Test
    public void testFactorial(){
        Assert.assertEquals(2.0,Driver.findfactorial(2),0.5);
        Assert.assertEquals(6.0,Driver.findfactorial(3),0.5);
        Assert.assertEquals(1.0,Driver.findfactorial(0),0.5);

        assertNotEquals(0,Driver.findfactorial(0),0.5);
        assertNotEquals(0,Driver.findfactorial(1),0.5);

    }

    @Test
    public void testlog(){
        Assert.assertEquals(2.39,Driver.findlog(10),0.1);
        Assert.assertEquals(0.69,Driver.findlog(1),0.1);
        Assert.assertEquals(0.0,Driver.findlog(0),0.0);

        assertNotEquals(1,Driver.findlog(0),0);
        assertNotEquals(1,Driver.findlog(10),0);

    }

    @Test
    public void testPower(){
        Assert.assertEquals(1.0,Driver.findpower(1,1),0.01);
        Assert.assertEquals(0.0,Driver.findpower(0,1),0.01);
        Assert.assertEquals(1.0,Driver.findpower(5,0),0.01);
        Assert.assertEquals(1.0,Driver.findpower(0,0),0.01);


        assertNotEquals(0.0,Driver.findpower(5,0),0.01);
        assertNotEquals(1.0,Driver.findpower(0,5),0.01);
        assertNotEquals(0.0,Driver.findpower(0,0),0.01);


    }
}