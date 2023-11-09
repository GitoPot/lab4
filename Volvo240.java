import java.awt.*;

public class Volvo240 extends Cars {

    private final static double trimFactor = 1.25;


    public Volvo240() {
        super(4, 100, Color.black, "Volvo240");
    }

    private double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }


    @Override
    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        if(currentSpeed>enginePower){
            currentSpeed = enginePower;
        }
    }

    @Override
    public void decrementSpeed(double amount) {
        if(currentSpeed <= amount){
            currentSpeed = 0;
        }else{
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        }
    }
}




    // TODO fix this method according to lab pm


    // TODO fix this method according to lab pm



