import java.awt.*;


public abstract class Vehicle implements Movable {

    private final int nrDoors; // Number of doors on the Vehicle
    private final double enginePower; // Engine power of the Vehicle
    protected double currentSpeed; // The current speed of the Vehicle
    private Color color; // Color of the Vehicle
    private final String modelName; // The Vehicle model name
    private final int loadSize;

    private boolean LoadedLocked;
    private boolean Started;

    protected double x;
    protected double y;
    private int direction;

    protected Vehicle(int vehicleNrDoors, double vehicleEnginePower, Color vehicleColor, String vehicleModelName, int vehicleLoadSize) {
        nrDoors = vehicleNrDoors;
        enginePower = vehicleEnginePower;
        color = vehicleColor;
        modelName = vehicleModelName;
        loadSize = vehicleLoadSize;
        x = 0;
        y = 0;
        stopEngine();
        LoadedLocked = false;
        Started = false;
        direction = 1;
    }


    public String getModelName() {
        return modelName;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    protected void startEngine() {
        Started = true;
    }

    protected void stopEngine() {
        currentSpeed = 0;
        Started = false;
    }
    public boolean isStarted(){
        return Started;
    }


    public int getLoadSize() {
        return loadSize;
    }

    abstract protected void incrementSpeed(double amount);

    abstract protected void decrementSpeed(double amount);


    public void gas(double amount) {
        if (amount <= 1 && amount >= 0 && Started) {
            incrementSpeed(amount);
        } else {

            System.out.println("Amount outside incrementSpeed range or the Vehicle are not started");

        }

    }

    protected void brake(double amount) {
        if (amount <= 1 && amount >= 0) {
            decrementSpeed(amount);
        } else {
            System.out.println("Amount outside decrementSpeed range");
        }

    }

    @Override
    public void move() {
        if (!getLoadedLocked()) {
            if (direction == 0) {
                y = y + currentSpeed;
            } else if (direction == 2) {
                y = y - currentSpeed;
            } else if (direction == 1) {
                x = x + currentSpeed;
            } else if (direction == 3) {
                x = x - currentSpeed;
            }
        }else{System.out.println("Din bil är fastspänd på en transportbil");}

    }

    @Override
    public void turnLeft() {
        direction = direction - 1;
        if (direction < 0) {
            direction = direction + 4;
        }

    }

    @Override
    public void turnRight() {
        direction = direction + 1;
        if (direction > 3) {
            direction = direction - 4;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    protected void setLoadedLocked() { //låser en bil som är lastad på en transportbil.
        if(loadSize>1)
            {System.out.println("Du får inte lasta en lastbil på en Transportbil");
        }else{LoadedLocked = !LoadedLocked;}
    }

    public boolean getLoadedLocked() {return LoadedLocked;}
}
