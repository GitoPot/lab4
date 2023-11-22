import java.awt.*;

public class Scania extends Cars{

    private double gradiant;


    public Scania(){
        super(2,100, Color.BLUE, "Scania", 2);
        gradiant=0;
        x=200;
    }

    @Override
    protected void incrementSpeed(double amount){
        if(gradiant == 0){
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


    protected void changeGradiant(double newGradiant){
        if (this.getCurrentSpeed() == 0 && newGradiant<=70 && newGradiant>=0){
            gradiant=newGradiant;
        }
    }
    public double getGradiant(){
        return gradiant;
    }
}

