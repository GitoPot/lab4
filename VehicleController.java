import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class VehicleController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    VehicleView frame;
    // A list of vehicle, modify if needed
    ArrayList<Vehicle> vehicle = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        VehicleController cc = new VehicleController();

        cc.vehicle.add(new Volvo240());
        cc.vehicle.add(new Saab95());
        cc.vehicle.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new VehicleView("VehicleSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the Vehicle in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : vehicle) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(x, y, car);
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : vehicle) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : vehicle) {
            car.brake(brake);
        }
    }

    void turboOn() {

        for (Vehicle car : vehicle){
            if(car instanceof Saab95){

                ((Saab95) car).setTurboOn();;
            }
        }

    }

    void turboOff() {
        for (Vehicle car : vehicle){
            if(car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBed() {

        for(Vehicle car : vehicle){
            if (car instanceof  Scania){
                ((Scania) car).changeGradiant(70);
            }
        }

    }

    void lowerBed() {
        for(Vehicle car : vehicle){
            if (car instanceof  Scania){
                ((Scania) car).changeGradiant(0);
            }
        }
    }

    void start() {
        System.out.println("Fordonen har startats");
        for (Vehicle car : vehicle) {
            car.startEngine();
        }
    }

    void stop() {
        System.out.println("Fordonen har stoppats");
        for (Vehicle car : vehicle) {
            car.stopEngine();
        }
    }
}
