import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.assertTrue;
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
        assertTrue(speed==0.1);
    }

    @Test
    public void testGetNrDoors(){
        int doors=saab.getNrDoors();
        assertTrue(doors==2);
    }

    @Test
    public void testGetSetColor(){
        Color color = saab.getColor();
        assertTrue(color == Color.red);
    }

    @Test
    public void testGetEnginePower(){
        double enginePower = saab.getEnginePower();
        assertTrue(125 == enginePower);
    }

    @Test
    public void testTurbo(){
        saab.setTurboOn();
        saab.setTurboOff();
        saab.setTurboOn();
        assertTrue(saab.isTurboOn());
    }


}
