import java.util.List;

public class BrandGarage<T extends Vehicle> implements GenericGarage<T>{

    private final HelperGarage<T> parent; // Composition

    public BrandGarage(int capacity){
        parent = new HelperGarage<T>(capacity);//Deligerar
    }

    @Override
    public void handInVehicle(T vehicle) {
        parent.handInVehicle(vehicle); //Deligerar
    }
    @Override
    public List<T> getGarageVehicle(){
        return parent.getGarageVehicle(); // deligerar
    }


    @Override
    public void collectVehicle(T vehicle) {
        parent.collectVehicle(vehicle);
    }
}
