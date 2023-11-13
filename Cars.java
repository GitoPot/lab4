import java.awt.*;

public abstract class Cars implements Movable{

    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private int loadSize;

    private double x;
    private double y;
    private int direction;

    protected Cars(int carNrDoors, double carEnginePower, Color carColor, String carModelName, int carLoadSize){
        nrDoors = carNrDoors;
        enginePower = carEnginePower;
        color = carColor;
        modelName = carModelName;
        loadSize=carLoadSize;
        x=0;
        y=0;
        stopEngine();
    }


    public String getModelName(){ return modelName;}
    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    protected void startEngine(){
        currentSpeed = 0.1;
    }

    protected void stopEngine(){
        currentSpeed = 0;
    }

    public int getLoadSize(){
        return loadSize;
    }

    abstract protected void incrementSpeed(double amount);
    abstract protected void decrementSpeed(double amount);


    public void gas(double amount){
        if (amount <= 1 && amount >= 0){
            incrementSpeed(amount);
        }
        else{

            System.out.println("Amount outside incrementSpeed range");

        }

    }
    protected void brake(double amount){
        if (amount <= 1 && amount >= 0){
            decrementSpeed(amount);
        }
        else{
            System.out.println("Amount outside decrementSpeed range");
        }

    }

    @Override
    public void move() {
        if (direction%2==0) {
            if (direction==0){
                y=y+currentSpeed;
            }
            else {
                y=y-currentSpeed;
            }
        }
        else {
            if (direction==1){
                x=x+currentSpeed;
            }
            else {
                x=x-currentSpeed;
            }
        }

        System.out.println("X: "+x);
        System.out.println("Y: "+y);
    }

    @Override
    public void turnLeft() {
        direction= direction-1;
        if (direction<0){
            direction=direction+4;
        }

    }

    @Override
    public void turnRight() {
        direction= direction+1;
        if (direction>3){
            direction=direction-4;
        }
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
}
