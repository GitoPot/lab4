import java.util.ArrayList;

public class VehicleModel {
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public VehicleModel(){
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }
    public void gas(int amount){
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }
    public void brake(int amount){
        double brake = ((double) amount) /100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }
    public void turboOn() {

        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOn();;
            }
        }

    }
    void turboOff() {
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }
    void liftBed() {

        for(Vehicle vehicle : vehicles){
            if (vehicle instanceof  Scania){
                ((Scania) vehicle).changeGradiant(70);
            }
        }

    }
    void lowerBed() {
        for(Vehicle vehicle : vehicles){
            if (vehicle instanceof  Scania){
                ((Scania) vehicle).changeGradiant(0);
            }
        }
    }

    void start() {
        System.out.println("Fordonen har startats");
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    void stop() {
        System.out.println("Fordonen har stoppats");
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }
    void updateVehiclePosition(Vehicle vehicle){
        vehicle.move();
    }
    public int updateXPos(Vehicle vehicle){
        return (int) Math.round(vehicle.getX());
    }
    int updateYPos(Vehicle vehicle){
        return (int) Math.round(vehicle.getY());
    }



}
