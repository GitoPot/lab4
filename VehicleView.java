import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class VehicleView extends JFrame implements ModelUpdateListener{
    private static final int X = 800;
    private static final int Y = 800;
    private VehicleModel model;


    DrawPanel drawPanel;

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    private JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    private JLabel gasLabel = new JLabel("Amount of gas");

    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Turbo on");
    private JButton turboOffButton = new JButton("Turbo off");
    private JButton liftBedButton = new JButton("Higher Bed");
    private JButton lowerBedButton = new JButton("Lower Bed");

    private JButton startButton = new JButton("Start all");
    private JButton stopButton = new JButton("Stop all");

    private JButton addRandom = new JButton("Add random");
    private JButton deleteVehicle = new JButton("Delete one");

    // Constructor
    public VehicleView(String framename, VehicleModel model){

        this.model=model;
        this.drawPanel = new DrawPanel(X, Y-240, model);
        initComponents(framename);
    }

    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);



        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);


        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(addRandom, 3);
        controlPanel.add(brakeButton, 4);
        controlPanel.add(turboOffButton, 5);
        controlPanel.add(lowerBedButton, 6);
        controlPanel.add(deleteVehicle, 7);

        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);


        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actOnModelUpdate() {
        ArrayList<Vehicle> vehicles = model.getVehicles();
        for (Vehicle vehicle : vehicles){
            drawPanel.moveit(model.updateXPos(vehicle), model.updateYPos(vehicle), vehicle);
        }
        drawPanel.repaint();
    }

    public void addGasSpinnerListener(ChangeListener listener){
        gasSpinner.addChangeListener(listener);
    }
    public void addGasButtonActionListener(ActionListener listener){
       gasButton.addActionListener(listener);
    }

    public void addBrakeButtonActionListener(ActionListener listener){
        brakeButton.addActionListener(listener);
    }

    public void addTurboOnButtonActionListener(ActionListener listener){
        turboOnButton.addActionListener(listener);
    }

    public void addTurboOffButtonActionListener(ActionListener listener){
        turboOffButton.addActionListener(listener);
    }

    public void addLiftBedButtonActionListener(ActionListener listener){
        liftBedButton.addActionListener(listener);
    }

    public void addLowerBedButtonActionListener(ActionListener listener){
        lowerBedButton.addActionListener(listener);
    }

    public void addStartButtonActionListener(ActionListener listener){
        startButton.addActionListener(listener);
    }

    public void addStopButtonActionListener(ActionListener listener){
        stopButton.addActionListener(listener);
    }
    public void addRandomButtonActionListener(ActionListener listener){
        addRandom.addActionListener(listener);
    }
    public void addDeleteVehicleButtonActionListener(ActionListener listener){
        deleteVehicle.addActionListener(listener);
    }
}