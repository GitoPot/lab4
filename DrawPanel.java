import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the Vehicle images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    // To keep track of a singel vehicle position
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();

    // TODO: Make this genereal for all vehicle
    void moveit(int x, int y, Vehicle vehicle){
        if (x < 0){vehicle.stopEngine(); vehicle.startEngine(); vehicle.x=0; vehicle.turnLeft(); vehicle.turnLeft();}
        else if (x > 700){vehicle.stopEngine(); vehicle.startEngine(); vehicle.x=700; vehicle.turnLeft(); vehicle.turnLeft();}
        else if (y < 0){vehicle.turnLeft(); vehicle.turnLeft(); vehicle.y=0; vehicle.stopEngine(); vehicle.startEngine(); }
        else if (y > 500){vehicle.turnLeft(); vehicle.turnLeft(); vehicle.y=500; vehicle.stopEngine(); vehicle.startEngine(); }

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

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
    }
}
