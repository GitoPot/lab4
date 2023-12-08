import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VehicleModel {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Point> PointList;

    private Random random;
    private final TimerListener timerListener;

    private final int delay = 50;
    private Timer timer = new Timer(delay, new VehicleModel.TimerListener());

    public VehicleModel(){
        this.random = new Random();
        PointList = new ArrayList<>();
        vehicles = new ArrayList<>();
        this.timer.start();
        timerListener = new TimerListener();
    }

    public ArrayList<Vehicle> getVehicles(){
        return vehicles;
    }

    public ArrayList<Point> getPointList(){
        return PointList;
    }

    public void addVehicle(Vehicle vehicle){
        if (vehicles.size() < 10){// lägg inte till mer än 10 fordon
            vehicles.add(vehicle);
            PointList.add(new Point());
        }else{
            System.out.println("För många fordon aktiva samtidigt");
        }
    }
    public void gas(int amount){
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }
    public void brake(int amount){
        double brake = ((double) amount) /100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }
    public void turboOn() {

        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOn();;
            }
        }

    }
    void turboOff() {
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }
    void liftBed() {

        for(Vehicle vehicle : vehicles){
            if (vehicle instanceof  Scania){
                ((Scania) vehicle).changeGradiant(70);
            }
        }

    }
    void lowerBed() {
        for(Vehicle vehicle : vehicles){
            if (vehicle instanceof  Scania){
                ((Scania) vehicle).changeGradiant(0);
            }
        }
    }

    void start() {
        System.out.println("Fordonen har startats");
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    void stop() {
        System.out.println("Fordonen har stoppats");
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
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
        if (!vehicles.isEmpty()){
            vehicles.remove(vehicles.size()-1);
            PointList.remove(vehicles.size()-1);
        }else{
            System.out.println("Det finns inga fordon att ta bort");
        }
    }
    void updateVehiclePosition(Vehicle vehicle){
        vehicle.move();
    }
    public int updateXPos(Vehicle vehicle){
        return (int) Math.round(vehicle.getX());
    }
    int updateYPos(Vehicle vehicle){
        return (int) Math.round(vehicle.getY());
    }


    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {

                updateVehiclePosition(vehicle);
                //view.drawPanel.moveit(x, y, vehicle);
                //view.drawPanel.repaint();
                //NOTIFY LISTENER

                //ActOnModelUpdate
            }
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
