import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VehicleModel {
    private VehicleComposite composite;
    private ArrayList<Point> PointList;

    private Random random;
    private final TimerListener timerListener;

    private final int delay = 50;
    private Timer timer = new Timer(delay, new VehicleModel.TimerListener());

    public VehicleModel(){
        this.random = new Random();
        PointList = new ArrayList<>();
        composite = new VehicleComposite();
        this.timer.start();
        timerListener = new TimerListener();
    }

    public ArrayList<Vehicle> getVehicles(){
        return composite.getVehicles();
    }

    public ArrayList<Point> getPointList(){
        return PointList;
    }

    public void addVehicle(Vehicle vehicle){
        if (composite.getSize() <= 10){// lägg inte till mer än 10 fordon
            composite.addVehicle(vehicle);
            PointList.add(new Point());
        }else{
            System.out.println("För många fordon aktiva samtidigt");
        }
    }
    public void gas(int amount){
        double gas = ((double) amount) / 100;
        composite.gas(gas);
    }
    public void brake(int amount){
        double brake = ((double) amount) /100;
        composite.brake(brake);
    }
    public void turboOn() {
        composite.turboOn();
    }
    void turboOff() {
        composite.turboOff();
    }
    void liftBed() {
        composite.liftBed();
    }
    void lowerBed() {
        composite.lowerBed();
    }

    public void start() {
        composite.start();
    }

    void stop() {
        composite.stop();
    }
    void addVehicle(){
        switch (random.nextInt(3) + 1){
        case 1:
            addVehicle(new Volvo240());
            break;
        case 2:
            addVehicle(new Saab95());
            break;
        case 3:
            addVehicle(new Scania());
            break;
        }
    }
    void removeVehicle(){
        composite.removeVehicle();
        PointList.remove(composite.getSize()-1);
    }

    public int updateXPos(Vehicle vehicle){
        return (int) Math.round(vehicle.getX());
    }
    int updateYPos(Vehicle vehicle){
        return (int) Math.round(vehicle.getY());
    }


    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            composite.moveAllVehicles();
            notifyListeners();
        }
    }
    private List<ModelUpdateListener> listeners = new ArrayList<>();
    private void notifyListeners(){
        for (ModelUpdateListener l : listeners)
            l.actOnModelUpdate();
    }


    public void addListener(ModelUpdateListener l){
        listeners.add(l);
    }

}
