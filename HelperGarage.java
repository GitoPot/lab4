import java.util.ArrayList;
import java.util.List;

public class HelperGarage<T> implements GenericGarage<T>{


    private int garageCapacity;
    private List<T> garageCars;

    public HelperGarage(int capacity){
        garageCars = new ArrayList<T>();
        garageCapacity = capacity;
    }
    @Override
    public List<T> getGarageCars(){
        return garageCars;
    }
    @Override
    public void handInCar(T car) {
        if(garageCars.size()<garageCapacity && !garageCars.contains(car)){
            garageCars.add(car);
        }
        else {
            System.out.println("The car is already in the garage");
        }

    }

    @Override
    public void collectCar(T car){
        if (garageCars.contains(car)){
            garageCars.remove(car);
        }
        else {
            System.out.println("The car is not in the garage");
        }

    }




}
