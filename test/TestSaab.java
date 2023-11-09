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

        for (int i = 0; i < 99; i ++){
            saab.brake(1);
        }




        assertTrue(saab.currentSpeed<=saab.enginePower);
        System.out.println(saab.currentSpeed);
        //saab.brake(1);
        //System.out.println(saab.currentSpeed);
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


}
