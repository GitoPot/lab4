import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;


public class DrawPanel extends JPanel{

    private final VehicleModel model;
    private ArrayList<Point> points;

    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    void moveit(int x, int y, Vehicle vehicle){
        if (x < 0){
            vehicle.stopEngine(); vehicle.startEngine(); vehicle.x=0; vehicle.turnLeft(); vehicle.turnLeft();
        }
        else if (x > 700){
            vehicle.stopEngine(); vehicle.startEngine(); vehicle.x=700; vehicle.turnLeft(); vehicle.turnLeft();
        }
        else if (y < 0){
            vehicle.turnLeft(); vehicle.turnLeft(); vehicle.y=0; vehicle.stopEngine(); vehicle.startEngine();
        }
        else if (y > 500){
            vehicle.turnLeft(); vehicle.turnLeft(); vehicle.y=500; vehicle.stopEngine(); vehicle.startEngine();
        }

        points.get(model.getVehicles().indexOf(vehicle)).x = x;
        points.get(model.getVehicles().indexOf(vehicle)).y = model.getVehicles().indexOf(vehicle)*100;


    }

    public DrawPanel(int x, int y, VehicleModel model) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.model = model;
        this.points = model.getPointList();

        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Vehicle vehicle : model.getVehicles()) {

            if (vehicle instanceof Volvo240) {
                g.drawImage(volvoImage, points.get(model.getVehicles().indexOf(vehicle)).x,
                        points.get(model.getVehicles().indexOf(vehicle)).y, null);

            } else if (vehicle instanceof Saab95) {
                g.drawImage(saabImage, points.get(model.getVehicles().indexOf(vehicle)).x,
                        points.get(model.getVehicles().indexOf(vehicle)).y, null);

            } else if (vehicle instanceof Scania) {
                g.drawImage(scaniaImage, points.get(model.getVehicles().indexOf(vehicle)).x,
                        points.get(model.getVehicles().indexOf(vehicle)).y, null);
            }
        }
    }
}
