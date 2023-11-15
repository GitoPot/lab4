import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestGarage {
    private Saab95 saab;
    private Volvo240 volvo;
    private BrandGarage<Saab95> saabGarage;
    private BrandGarage<Volvo240> volvoGarage;
    private LosSantosCustoms losSantos;
    @Before
    public void init(){
        saab = new Saab95();
        volvo = new Volvo240();
        saabGarage = new BrandGarage<>(5);
        losSantos = new LosSantosCustoms(10);

    }

    @Test
    public void testSaabGarage(){ //Om testaren testar att lämna in en volvo i saabgaraget, kommer hen få ett compile fel.
        saabGarage.handInCar(saab);
        assertTrue(saabGarage.getGarageCars().size()==1);
    }
}
