import java.util.List;

public class BrandGarage<T extends Cars> implements GenericGarage<T>{// Bara bilar med ett specifikt märke

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


    @Override
    public void collectCar(T car) {
        parent.collectCar(car);
    }
}
