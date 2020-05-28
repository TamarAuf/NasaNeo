package aufrichtig.nasa.neo;

import javax.inject.Singleton;
import javax.swing.*;
import java.awt.*;

/**
 * Display the NearEarthObject
 */
@Singleton
public class NearEarthObjectView extends JComponent {

    private NeoFeed.NearEarthObject neo;

    public void setNearEarthObject(NeoFeed.NearEarthObject neo) {
        this.neo = neo;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (neo == null) {
            return;
        }

        // Earth
        g.setColor(Color.BLUE);
        g.fillOval(-50, 200, 100, 100);

        // Asteroid
        g.setColor(Color.RED);
        g.fillOval(getWidth()-10, 200, 10, 10);

        double lunars = neo.closestLunarDistance();
        double uiDistance = getWidth()-10;
        double moonX = uiDistance / lunars;

        // Moon
        g.setColor(Color.GRAY);
        g.fillOval((int) moonX, 200, 25, 25);
    }

}
