import java.util.ArrayList;

public class VehicleComposite {
    private ArrayList<Vehicle> vehicles;

    public VehicleComposite(){
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle car){
        vehicles.add(car);
    }

    public ArrayList<Vehicle> getVehicles(){
        return vehicles;
    }
    public int getSize(){
        return vehicles.size();
    }
    public void gas(double amount){
        for (Vehicle vehicle : vehicles){
            vehicle.gas(amount);
        }
    }
    public void brake(double amount){
        for (Vehicle vehicle : vehicles){
            vehicle.brake(amount);
        }
    }
    public void turboOn(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOn();;
            }
        }
    }
    public void turboOff(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }
    public void liftBed(){
        for(Vehicle vehicle : vehicles){
            if (vehicle instanceof  Scania){
                ((Scania) vehicle).changeGradiant(70);
            }
        }
    }
    public void lowerBed(){
        for(Vehicle vehicle : vehicles){
            if (vehicle instanceof  Scania){
                ((Scania) vehicle).changeGradiant(0);
            }
        }
    }
    public void start() {
        System.out.println("Fordonen har startats");
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }
    public void stop() {
        System.out.println("Fordonen har stoppats");
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }
    public void removeVehicle(){
        if (!vehicles.isEmpty()){
            vehicles.remove(vehicles.size()-1);

        }else{
            System.out.println("Det finns inga fordon att ta bort");
        }
    }
    public void moveAllVehicles(){
        for (Vehicle vehicle : vehicles) {

            vehicle.move();

        }
    }
}
