package src;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    // To keep track of a singel cars position
    // ArrayList<Point> carsPointList = new ArrayList<>(); {
    //     carsPointList.add(new Point());
    //     carsPointList.add(new Point());
    //     carsPointList.add(new Point());
    // }
    
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();

    // TODO: Make this genereal for all cars
    void moveit(String modelName, int x, int y){
        switch (modelName) {
            case "Volvo240": volvoPoint.x = x;
                volvoPoint.y = y;
                break;
            case "Saab95": saabPoint.x = x;
                saabPoint.y = y;
                break;
            case "Scania": scaniaPoint.x = x;
                scaniaPoint.y = y;
                break;

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
            volvoImage = ImageIO.read(new File("Src\\pics\\Volvo240.jpg"));
            saabImage = ImageIO.read(new File("Src\\pics\\Saab95.jpg"));
            scaniaImage = ImageIO.read(new File("Src\\pics\\Scania.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            //volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
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
        // see javadoc for more info on the parameters
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
    }
}
