import java.awt.*;


public abstract class Cars implements Movable {

    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private final int loadSize;

    private boolean LoadedLocked;
    private boolean Started;

    protected double x;
    protected double y;
    private int direction;

    protected Cars(int carNrDoors, double carEnginePower, Color carColor, String carModelName, int carLoadSize) {
        nrDoors = carNrDoors;
        enginePower = carEnginePower;
        color = carColor;
        modelName = carModelName;
        loadSize = carLoadSize;
        x = 0;
        y = 0;
        stopEngine();
        LoadedLocked = false;
        Started = false;
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
        currentSpeed = 0.1;
        Started = true;
    }

    protected void stopEngine() {
        currentSpeed = 0;
        Started = false;
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

            System.out.println("Amount outside incrementSpeed range or the cars are not started");

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


        System.out.println("X: " + x);
        System.out.println("Y: " + y);
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
