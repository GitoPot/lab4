import java.util.ArrayList;
import java.util.List;

public class LosSantosCustoms implements GenericGarage<Vehicle>{
    private final HelperGarage<Vehicle> parent;  // Composition

    public LosSantosCustoms(int capacity){
        parent = new HelperGarage<Vehicle>(capacity);
    }


    @Override
    public void handInVehicle(Vehicle vehicle) {
        parent.handInVehicle(vehicle);        // Delegation
    }

    @Override
    public List<Vehicle> getGarageVehicle() {
        return parent.getGarageVehicle();
    }
    @Override
    public void collectVehicle(Vehicle vehicle){
        parent.collectVehicle(vehicle);
    }
}
