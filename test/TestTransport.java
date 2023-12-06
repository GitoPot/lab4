import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestTransport {
    private Transport transport;
    private Saab95 saab;
    private Volvo240 volvo;
    private Scania scania;
    @Before
    public void init(){
        transport = new Transport(2);
        saab = new Saab95();
        volvo = new Volvo240();
        scania = new Scania();
    }

    @Test
    public void testAddVehicleToLoad(){
        transport.addVehicleToLoad(saab);
        List<Vehicle> vehicleLoad = transport.getVehicleLoad();
        transport.changeRamp();
        transport.addVehicleToLoad(volvo);
        transport.addVehicleToLoad(scania);
        transport.addVehicleToLoad(saab);


        assertTrue(vehicleLoad.size()==2);
    }
    @Test
    public void testRemoveVehicleFromLoad(){
        transport.changeRamp();
        transport.addVehicleToLoad(saab);
        transport.addVehicleToLoad(volvo);
        System.out.println(transport.getVehicleLoad());

        transport.changeRamp();
        transport.removeVehicleFromLoad();
        System.out.println(transport.getVehicleLoad());

        transport.changeRamp();
        transport.removeVehicleFromLoad();
        System.out.println(transport.getVehicleLoad());
        assertTrue(transport.getVehicleLoad().size()==1);
    }
    @Test
    public void testMovable(){//testar även turn funtionerna
        transport.changeRamp();
        transport.addVehicleToLoad(volvo);
        transport.changeRamp();
        transport.gas(1);
        transport.move();
        transport.turnLeft();
        transport.move();
        transport.turnLeft();
        transport.move();
        System.out.println("x "+transport.getX() +" y "+transport.getY());
        transport.turnRight();
        transport.turnRight();
        transport.turnRight();
        transport.move();
        transport.move();
        System.out.println("x "+transport.getX() +" y "+transport.getY());
        System.out.println("x "+volvo.getX() +" y "+volvo.getY());
        TestCase.assertTrue((transport.getY()== volvo.getY()) && (transport.getX()== volvo.getX()));
    }

    @Test
    public void testLoadLock(){
        volvo.setLoadedLocked();
        assertTrue(volvo.getLoadedLocked());
    }

}
