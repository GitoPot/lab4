import java.awt.*;

public class Transport extends Cars{
    private boolean ramp;
    private Object[] carLoad;

    private int maxLoad;

    public Transport(){
        super(2,100, Color.yellow, "Jumper EH35L HDI", 2);
        ramp=false;
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
    public boolean getRamp(){
        return ramp;
    }

    public Object[] getCarLoad(){ return carLoad; }

    protected Object addCarToLoad(Object Car){

    }
}
