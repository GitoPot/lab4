import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.*;

public class TestSaab {

    private Saab95 saab;



    @Before
    public void init(){
        saab = new Saab95();


    }

    @Test
    public void testCurrentSpeed(){
        saab.gas(1);
        assertTrue(saab.currentSpeed<=saab.enginePower);
        //
        saab.brake(0);
        System.out.println(saab.currentSpeed);
    }

    @Test
    public void testStartEngine(){
        saab.startEngine();
        double speed=saab.getCurrentSpeed();
        assertEquals(0.1, speed);
    }

    @Test
    public void testGetNrDoors(){
        int doors=saab.getNrDoors();
        assertEquals(2, doors);
    }

    @Test
    public void testGetSetColor(){
        Color color = saab.getColor();
        assertSame(color, Color.red);
    }

    @Test
    public void testTurbo(){
        saab.setTurboOn();
        saab.setTurboOff();
        assertFalse(saab.isTurboOn());
    }

    @Test
    public void testIncrementSpeed(){
        saab.incrementSpeed(1);
        assertTrue(saab.getCurrentSpeed()>=0.1);
    }

    @Test
    public void testDecrementSpeed(){
        saab.decrementSpeed(0);
    }


}
