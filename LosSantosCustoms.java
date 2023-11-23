import java.util.ArrayList;
import java.util.List;

public class LosSantosCustoms implements GenericGarage<Cars>{
    private final HelperGarage<Cars> parent;  // Composition

    public LosSantosCustoms(int capacity){
        parent = new HelperGarage<Cars>(capacity);
    }


    @Override
    public void handInCar(Cars car) {
        parent.handInCar(car);        // Delegation
    }

    @Override
    public List<Cars> getGarageCars() {
        return parent.getGarageCars();
    }
    @Override
    public void collectCar(Cars car){
        parent.collectCar(car);
    }
}
