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

    saab.gas(1);//(amount <= 1 && amount >= 0)
    saab.brake(0.9);//(amount <= 1 && amount >= 0)
    //Ska testa det som failar
    saab.gas(2);
    saab.brake(2);

    System.out.println(saab.getCurrentSpeed());
    assertTrue(saab.getCurrentSpeed()<=saab.getEnginePower());

  }

   @Test
   public void testGetModelName(){
        String name = "Saab95";
       assertEquals(saab.getModelName(), name);
   }

    @Test
    public void testStartEngine(){
        saab.startEngine();
        boolean started=saab.isStarted();
        assertTrue(started);
    }

    @Test
    public void testGetNrDoors(){
        int doors=saab.getNrDoors();
        assertEquals(2, doors);
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
    public void testGetColor(){
        Color color = saab.getColor();
        assertSame(color, Color.red);
    }
    @Test
    public void testSetColor(){
        saab.setColor(Color.pink);
        assertSame(Color.pink, saab.getColor());
    }

    @Test
    public void testMovable(){//testar även turn funtionerna
        saab.gas(1);
        saab.move();
        saab.turnLeft();
        saab.move();
        saab.turnLeft();
        saab.move();
        System.out.println("x "+saab.getX() +" y "+saab.getY());
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        saab.move();
        assertTrue(saab.getY()==0 && saab.getX()==0);

    }

}
