import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VehicleModel {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private final TimerListener timerListener;

    private final int delay = 50;
    private Timer timer = new Timer(delay, new VehicleModel.TimerListener());

    public VehicleModel(){
        vehicles = new ArrayList<>();
        this.timer.start();
        timerListener = new TimerListener();
    }

    public ArrayList<Vehicle> getVehicles(){
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
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
