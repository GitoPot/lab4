import java.awt.*;

public class Transport extends Cars{
    private double gradiant;

    public Transport(){
        super(2,100, Color.yellow, "Jumper EH35L HDI");
        gradiant=0;
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
