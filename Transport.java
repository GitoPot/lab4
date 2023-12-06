import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Transport extends Vehicle{
    private boolean ramp;
    private List<Vehicle> vehicleLoad;

    private int maxLoad;

    public Transport(int maximumLoad){
        super(2,100, Color.yellow, "Jumper EH35L HDI", 2);
        ramp=false;
        maxLoad=maximumLoad;
        vehicleLoad = new ArrayList<Vehicle>();
    }

    @Override
    protected void incrementSpeed(double amount){
        if(!ramp){
            currentSpeed = Math.min(getCurrentSpeed() + amount, getEnginePower());
        }
    }
    @Override
    protected void decrementSpeed(double amount){
        if(currentSpeed <= amount){
            currentSpeed = 0;
        }else{
            currentSpeed = getCurrentSpeed() - amount;
        }
    }


    protected void changeRamp(){
        if (this.getCurrentSpeed() == 0 && !ramp){
            ramp = true;
        }else {
            ramp = false;
        }
    }
    public List<Vehicle> getVehicleLoad(){
        return vehicleLoad;
    }

    protected void addVehicleToLoad(Vehicle vehicle){
        //antag att Transporten bara kan lasta personbilar
        int loadSize = vehicle.getLoadSize();
        double diffX = this.getX()-vehicle.getX();
        double diffY = this.getY()-vehicle.getY();
        if ((Math.abs(diffX)<=5) && (Math.abs(diffY)<=5) && !vehicleLoad.contains(vehicle)) {
            // bilen måste vara inom en 5x5 kvadrat
            if (loadSize < 2 && this.getCurrentSpeed() == 0 && maxLoad > vehicleLoad.size() && ramp) {
                vehicleLoad.add(vehicle);
                vehicle.x=this.x;
                vehicle.y=this.y;
                if(!vehicle.getLoadedLocked()){vehicle.setLoadedLocked();}
            }
        }

    }

    public void removeVehicleFromLoad(){
        int index = vehicleLoad.size();
        Vehicle vehicle = vehicleLoad.get(index - 1);

        if ( this.getCurrentSpeed() == 0 && ramp && vehicle.getLoadedLocked()) {
            vehicleLoad.remove(vehicle);
            vehicle.setLoadedLocked();
        }
        else {
            System.out.println("Please put down the ramp and stop moving!");
        }
    }


    @Override
    public void move(){
        int direction = this.getDirection();
        if (direction==0){
            y=y+getCurrentSpeed();
        }
        else if(direction==2) {
            y=y-getCurrentSpeed();
        }

        else if (direction==1){
            x=x+getCurrentSpeed();
        }
        else if(direction==3) {
            x=x-getCurrentSpeed();

        }
        for (Vehicle vehicle : vehicleLoad) {
            vehicle.x = this.x;
            vehicle.y = this.y;
        }
    }

}
