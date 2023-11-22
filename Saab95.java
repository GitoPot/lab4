import java.awt.*;

public class Saab95 extends Cars{
    private boolean turboOn;
    public Saab95(){
        super(2, 125, Color.red, "Saab95", 1);
	    turboOn = false;
        y=100;
    }
    public void setTurboOn(){
	    turboOn = true;
        System.out.println("TURBO IS ON");
    }
    public void setTurboOff(){
	    turboOn = false;
        System.out.println("TURBO IS Off");
    }
    public boolean isTurboOn(){
        return turboOn;
    }

    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    @Override
    protected void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if(currentSpeed>getEnginePower()){
            currentSpeed = getEnginePower();
        }
    }

    @Override
    protected void decrementSpeed(double amount){
        if(currentSpeed <= speedFactor() * amount){
            currentSpeed = 0;
        }else{
            currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        }
    }

}
