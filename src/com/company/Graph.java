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
		System.out.println(width);
        int height = getHeight();
		System.out.println(height);
        g1.draw(new Line2D.Double(mar, mar, mar, height - mar));
        g1.draw(new Line2D.Double(mar, height - mar, width - mar, height - mar));
        double xscalefactor = (double) (width - 2 * mar) / (getMax_x_value());               // xscalefactor was previously named x
        double yscalefactor = (double) (height - 2 * mar) / getMax_y_value();  // yscalefactor was previously named scale   //getMax_y_value was previously named getMax
        g1.setPaint(Color.BLUE);

        for (int i = 0; i < Population.xcoordinates.size(); i++) {
            double x1 = mar + Population.xcoordinates.get(i) * xscalefactor;
            double y1 = height - mar - yscalefactor * Population.ycoordinates.get(i);
			System.out.printf("plotting x at : %f, plotting y at %f\n", x1,y1); 
            g1.draw(new Line2D.Double(x1, y1, x1 , y1 + 20));
            g1.fill(new Ellipse2D.Double(x1 - 2, y1 - 2, 4, 4));
        }

    }
	
	private int getMax_x_value() { 
        return 10;
    }

    private int getMax_y_value() {
        int max = -Integer.MAX_VALUE;
        for (int i = 0; i < Population.xcoordinates.size(); i++) {
            if (Population.ycoordinates.get(i) > max)   // Ooops - this needs say ycoordinates as well
                max = Population.ycoordinates.get(i);  //previously  Population.xcoordinates.get(i) !!!!!!!!!!!!!
        }
		System.out.printf("max is %d\n",max);
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
