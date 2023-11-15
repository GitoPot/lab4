import java.util.ArrayList;
import java.util.List;

public class BrandGarage<T> implements GenericGarage<T>{// Bara ett slags märkes bilar

    private final HelperGarage<T> parent; // Composition

    public BrandGarage(int capacity){
        parent = new HelperGarage<T>(capacity);//Deligerar
    }

    @Override
    public void handInCar(T car) {
        parent.handInCar(car); //Deligerar
    }
    @Override
    public List<T> getGarageCars(){
        return parent.getGarageCars(); // deligerar
    }
}
