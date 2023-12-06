import java.util.ArrayList;
import java.util.List;

public class HelperGarage<T> implements GenericGarage<T>{


    private int garageCapacity;
    private List<T> garageVehicle;

    public HelperGarage(int capacity){
        garageVehicle = new ArrayList<T>();
        garageCapacity = capacity;
    }
    @Override
    public List<T> getGarageVehicle(){
        return garageVehicle;
    }
    @Override
    public void handInVehicle(T vehicle) {
        if(garageVehicle.size()<garageCapacity && !garageVehicle.contains(vehicle)){
            garageVehicle.add(vehicle);
        }
        else {
            System.out.println("The Vehicle is already in the garage");
        }

    }

    @Override
    public void collectVehicle(T vehicle){
        if (garageVehicle.contains(vehicle)){
            garageVehicle.remove(vehicle);
        }
        else {
            System.out.println("The vehicle is not in the garage");
        }

    }




}
