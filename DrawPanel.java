import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class DrawPanel extends JPanel{

    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();

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

        if (vehicle instanceof Volvo240){
            volvoPoint.x = x;
            volvoPoint.y = y;
        } else if (vehicle instanceof Saab95) {
            saabPoint.x = x;
            saabPoint.y = y;
        } else if (vehicle instanceof Scania){
            scaniaPoint.x = x;
            scaniaPoint.y = y;
        }

    }

    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

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
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
    }
}
