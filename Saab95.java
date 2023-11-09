import java.awt.*;

public class Saab95 extends Cars{
    private boolean turboOn;
    public Saab95(){
        super(2, 125, Color.red, "Saab95");
	    turboOn = false;
    }
    public void setTurboOn(){
	    turboOn = true;
    }
    public void setTurboOff(){
	    turboOn = false;
    }//används ej
    public boolean isTurboOn(){
        return turboOn;
    }

    private double speedFactor(){//public?
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    @Override
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if(currentSpeed>enginePower){
            currentSpeed = enginePower;
        }
    }

    @Override
    public void decrementSpeed(double amount){
        if(currentSpeed <= speedFactor() * amount){
            currentSpeed = 0;
        }else{
            currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        }
    }

}
