import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class Graph extends JPanel {
    int mar = 50;


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g1 = (Graphics2D) g;
        g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        g1.draw(new Line2D.Double(mar, mar, mar, height - mar));
        g1.draw(new Line2D.Double(mar, height - mar, width - mar, height - mar));
        double x = (double) (width - 2 * mar) / (10);
        double scale = (double) (height - 2 * mar) / getMax();
        g1.setPaint(Color.BLUE);


        for (int i = 0; i < Population.xcoordinates.size(); i++) {
            double x1 = mar + Population.xcoordinates.get(i) * x;
            double y1 = height - mar - scale * Population.ycoordinates.get(i);
            g1.draw(new Line2D.Double(x1, y1, (mar +Population.xcoordinates.get(i) * x) , (height - mar - scale * Population.ycoordinates.get(i)) + 20));
            g1.fill(new Ellipse2D.Double(x1 - 2, y1 - 2, 4, 4));
        }


    }

    private int getMax() {
        int max = -Integer.MAX_VALUE;
        for (int i = 0; i < Population.xcoordinates.size(); i++) {
            if (Population.xcoordinates.get(i) > max)
                max = Population.xcoordinates.get(i);

        }
        return max;
    }

    public void CreateGraph() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Graph());
        frame.setSize(400, 400);
        frame.setLocation(200, 200);
        frame.setVisible(true);

    }
}
