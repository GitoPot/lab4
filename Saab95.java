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
        if(currentSpeed <= amount){
            currentSpeed = 0;
        }else{
            currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        }
    }


    public static void main(String[] args) {
        Saab95 car = new Saab95();
        //double speed = car.currentSpeed;
        System.out.println(car.getColor());
        car.setTurboOn();
        if (car.turboOn){
            System.out.println("OwO");//owo
        }
        car.startEngine();
        car.turnLeft();
        car.move();
        car.turnRight();
        car.move();
        car.turnRight();
        car.move();
    }
}
