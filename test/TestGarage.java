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
    public void testSaabGarageHandInCar(){ //Om testaren testar att lämna in en volvo i saabgaraget, kommer hen få ett compile fel.
        saabGarage.handInCar(saab);
        saabGarage.handInCar(saab);
        assertTrue(saabGarage.getGarageCars().size()==1);
    }

    @Test
    public void testLosSantosCustomsHanInCar(){
        losSantos.handInCar(volvo);
        losSantos.handInCar(saab);
        losSantos.handInCar(volvo);
        assertTrue(losSantos.getGarageCars().size()==2);
    }


    @Test
    public void testSaabCollectCar(){
        saabGarage.handInCar(saab);
        saabGarage.handInCar(saab2);
        saabGarage.handInCar(saab2);
        saabGarage.collectCar(saab2);
        assertTrue(saabGarage.getGarageCars().size()==1);

    }
}
