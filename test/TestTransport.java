import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    public void testAddCardToLoad(){
        transport.addCarToLoad(saab);
        List<Cars> carLoad = transport.getCarLoad();
        transport.changeRamp();
        transport.addCarToLoad(volvo);
        transport.addCarToLoad(scania);
        transport.addCarToLoad(saab);


        assertTrue(carLoad.size()==2);
    }
    @Test
    public void testRemoveCarFromLoad(){
        transport.changeRamp();
        transport.addCarToLoad(saab);
        transport.addCarToLoad(volvo);
        System.out.println(transport.getCarLoad());

        transport.changeRamp();
        transport.removeCarFromLoad();
        System.out.println(transport.getCarLoad());

        transport.changeRamp();
        transport.removeCarFromLoad();
        System.out.println(transport.getCarLoad());
        assertTrue(transport.getCarLoad().size()==1);
    }
    @Test
    public void testMovable(){//testar även turn funtionerna
        transport.changeRamp();
        transport.addCarToLoad(volvo);
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
