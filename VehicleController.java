import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleController {

    private VehicleView view;

    private VehicleModel model;


    public VehicleController(VehicleView vv, VehicleModel vm){
        this.view = vv;
        this.model = vm;
        addListeners();

    }
    private void addListeners(){
        view.addGasSpinnerListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                view.gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
        view.addGasButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas(view.gasAmount);
            }
        });
        view.addBrakeButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brake(view.gasAmount);
            }
        });
        view.addTurboOnButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.turboOn();
            }
        });
        view.addTurboOffButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.turboOff();
            }
        });
        view.addLiftBedButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.liftBed();
            }
        });
        view.addLowerBedButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.lowerBed();
            }
        });
        view.addStartButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.start();
            }
        });
        view.addStopButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.stop();
            }
        });
    }



}
