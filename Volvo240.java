import java.awt.*;

public class Volvo240 extends Vehicle {

    private final static double trimFactor = 1.25;


    public Volvo240() {
        super(4, 100, Color.black, "Volvo240", 1);
    }

    private double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }


    @Override
    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());

    }

    @Override
    protected void decrementSpeed(double amount) {
        if(currentSpeed <= speedFactor() * amount){
            currentSpeed = 0;
        }else{
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        }
    }

}





