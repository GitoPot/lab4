import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.*;

public class TestScania {

        private Scania scan;

        @Before
        public void init(){
            scan = new Scania();
        }

        @Test
        public void testGasAndBrake(){

            for (int i = 0; i < 130; i ++){
                scan.gas(1);
            }

            scan.gas(1);//(amount <= 1 && amount >= 0)
            scan.brake(0.9);//(amount <= 1 && amount >= 0)
            //Ska testa det som failar
            scan.gas(2);
            scan.brake(2);

            System.out.println(scan.getCurrentSpeed());
            assertTrue(scan.getCurrentSpeed()<=scan.getEnginePower());

        }

        @Test
        public void testGetModelName(){
            String name = "ScaniaTruck";
            assertEquals(scan.getModelName(), name);
        }

        @Test
        public void testStartEngine(){
            scan.startEngine();
            double speed=scan.getCurrentSpeed();
            assertEquals(0.1, speed);
        }

        @Test
        public void testGetNrDoors(){
            int doors=scan.getNrDoors();
            assertEquals(2, doors);//byt siffra
        }

        @Test
        public void testGetEnginePower(){
            assertEquals(125.0, scan.getEnginePower());//byt siffra
        }
        @Test
        public void testGetColor(){
            Color color = scan.getColor();
            assertSame(color, Color.red);//byt färg
        }
        @Test
        public void testSetColor(){
            scan.setColor(Color.pink);
            assertSame(Color.pink, scan.getColor());
        }

        @Test
        public void testMovable(){//testar även turn funtionerna
            scan.move();
            scan.turnLeft();
            scan.move();
            scan.turnLeft();
            scan.move();
            System.out.println("x "+scan.x +" y "+scan.y);
            scan.turnRight();
            scan.turnRight();
            scan.turnRight();
            scan.move();
            assertTrue(scan.y==0 && scan.x==0);

        }

}
