import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestGarage {
    private Saab95 saab;
    private Saab95 saab2;
    private Volvo240 volvo;
    private Scania scania;
    private BrandGarage<Saab95> saabGarage;
    private BrandGarage<Volvo240> volvoGarage;
    private LosSantosCustoms losSantos;
    @Before
    public void init(){
        saab = new Saab95();
        volvo = new Volvo240();
        saabGarage = new BrandGarage<Saab95>(5);
        losSantos = new LosSantosCustoms(10);
        scania = new Scania();
        saab2 = new Saab95();
    }

    @Test
    public void testSaabGarageHandInVehicle(){ //Om testaren testar att lämna in en volvo i saabgaraget, kommer hen få ett compile fel.
        saabGarage.handInVehicle(saab);
        saabGarage.handInVehicle(saab);
        assertTrue(saabGarage.getGarageVehicle().size()==1);
    }

    @Test
    public void testLosSantosCustomsHanInVehicle(){
        losSantos.handInVehicle(volvo);
        losSantos.handInVehicle(saab);
        losSantos.handInVehicle(volvo);
        assertTrue(losSantos.getGarageVehicle().size()==2);
    }


    @Test
    public void testSaabCollectVehicle(){
        saabGarage.handInVehicle(saab);
        saabGarage.handInVehicle(saab2);
        saabGarage.handInVehicle(saab2);
        saabGarage.collectVehicle(saab2);
        assertTrue(saabGarage.getGarageVehicle().size()==1);

    }
}
