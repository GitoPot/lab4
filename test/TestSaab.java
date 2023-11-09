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
    public void testGasAndBrake(){

      for (int i = 0; i < 130; i ++){
          saab.gas(1);
    }

    saab.gas(1);
    saab.brake(0.9);
    System.out.println(saab.currentSpeed);
    assertTrue(saab.currentSpeed<=saab.enginePower);

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

    @Test
    public void testGetEnginePower(){
        assertEquals(125.0, saab.getEnginePower());
    }

    @Test
    public void testSetColor(){
        saab.setColor(Color.pink);
        assertSame(Color.pink, saab.getColor());
    }

    @Test
    public void testMain(){//testar även turn funtionerna
        saab.move();
        saab.turnLeft();
        saab.move();
        saab.turnLeft();
        saab.move();
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        saab.move();
        assertTrue(saab.y==0 && saab.x==0);

    }

}
