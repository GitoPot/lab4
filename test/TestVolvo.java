import org.junit.Before;
import org.junit.Test;


import java.awt.*;

import static junit.framework.TestCase.*;
public class TestVolvo {
    private Volvo240 volvo;
    @Before
    public void init(){
        volvo = new Volvo240();
    }
    @Test
    public void testGasAndBrake(){

        for (int i = 0; i < 130; i ++){
            volvo.gas(1);
        }

        volvo.gas(1);
        volvo.brake(0.9);
        System.out.println(volvo.getCurrentSpeed());
        assertTrue(volvo.getCurrentSpeed()<=volvo.getEnginePower());

    }

    @Test
    public void testDecrementSpeed(){
        System.out.println(volvo.getCurrentSpeed());
        volvo.decrementSpeed(100);
        assertTrue(0 == volvo.getCurrentSpeed());//går ej med assertEquals
    }

    @Test
    public void testMovable(){//testar även turn funtionerna
        volvo.move();
        volvo.turnLeft();
        volvo.move();
        volvo.turnLeft();
        volvo.move();
        System.out.println("x "+volvo.x +" y "+volvo.y);
        volvo.turnRight();
        volvo.turnRight();
        volvo.turnRight();
        volvo.move();
        assertTrue(volvo.y==0 && volvo.x==0);

    }

    @Test
    public void testGetModelName(){
        String name = "Volvo240";
        assertEquals(volvo.getModelName(), name);
    }

    @Test
    public void testStartEngine(){
        volvo.startEngine();
        double speed=volvo.getCurrentSpeed();
        assertEquals(0.1, speed);
    }

    @Test
    public void testGetNrDoors(){
        assertEquals(4, volvo.getNrDoors());
    }

    @Test
    public void testGetSetColor(){
        Color color = volvo.getColor();
        assertSame(color, Color.black);
    }
    @Test
    public void testSetColor(){
        volvo.setColor(Color.pink);
        assertSame(Color.pink, volvo.getColor());

    }
}
