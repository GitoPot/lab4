import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math.*;

public class Transport extends Cars{
    private boolean ramp;
    private List<Cars> carLoad;

    private int maxLoad;

    public Transport(int maximumLoad){
        super(2,100, Color.yellow, "Jumper EH35L HDI", 2);
        ramp=false;
        maxLoad=maximumLoad;
        carLoad = new ArrayList<Cars>();
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
    public List<Cars> getCarLoad(){
        return carLoad;
    }

    protected void addCarToLoad(Cars Car){ //antag att Transporten bara kan lasta personbilar
        int loadSize = Car.getLoadSize();
        double diffX = this.getX()-Car.getX();
        double diffY = this.getY()-Car.getY();
        if ((Math.abs(diffX)<=5) && (Math.abs(diffY)<=5) && !carLoad.contains(Car)) {// bilen måste vara inom en 5x5 kvadrat
            if (loadSize < 2 && this.getCurrentSpeed() == 0 && maxLoad > carLoad.size() && ramp) {
                carLoad.add(Car);
                Car.x=this.x;
                Car.y=this.y;
                if(!Car.getLoadedLocked()){Car.setLoadedLocked();}
            }
        }

    }

    public void removeCarFromLoad(){
        int index = carLoad.size();
        Cars car = carLoad.get(index - 1);

        if ( this.getCurrentSpeed() == 0 && ramp && car.getLoadedLocked()) {
            carLoad.remove(car);
            car.setLoadedLocked();
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
        for (Cars cars : carLoad) {
            cars.x = this.x;
            cars.y = this.y;
        }
    }

}//Transport
