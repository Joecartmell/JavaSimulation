import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.applet.*;
import java.util.ArrayList;

public class Graph extends JPanel {
    int mar = 100;


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g1 = (Graphics2D) g;
        g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();     // width of available area for drawing measured in pixels
        int height = getHeight();   // height of available area for drawing measured in pixels
		System.out.printf("width of drawing area in pixels: %d\n",width);
		System.out.printf("height of drawing area in pixels: %d\n",height);
		//draw vertical for the y-axis
        g1.draw(new Line2D.Double(mar, mar, mar, height - mar));  
		
        // draw horizontalfor the x-axis
        // leave margin left and right of the plotting area in the drawing area		
        g1.draw(new Line2D.Double(mar, height - mar, width - mar, height - mar)); 
        int extent_of_x_axis_in_pixels = width - mar - mar ; 	// this is the available width  for plotting my data

        //draw vertical for the y-axis
		// leave margin above and below the plotting area in the drawing area
        g1.draw(new Line2D.Double(mar, mar, mar, height - mar));  
        int extent_of_y_axis_in_pixels = height - mar - mar ; 	// this is the available height  for plotting my data		
      
	    //draw and fill a circle at the centred at pixel coordinates (0,0) of the whole drawing area
		// and of radius 5 pixels. 
		// To do this specify x=-5 pixels, y=-5 pixels, width=5 pixels, height = 5 pixels
		// Note that (0,0) coordinates in pixels is top-left of the drawing area
		g1.fill(new Ellipse2D.Double(-5, -5, 10, 10));
		
		//now draw a circle at the origin of our application plotting coordinates i.e.
		// where the x-axis interesects the y-axis. 
		// This open (unfilled) circle is the origin in my plotting coordinates
		g1.draw(new Ellipse2D.Double(mar - 5 , height - mar -5 , 10, 10));

		// 
		// Multiplying my application units by a scale factor converts my units to pixels
        double xscalefactor = (double) (extent_of_x_axis_in_pixels) / (getMax_x_value()); 
        double yscalefactor = (double) (extent_of_y_axis_in_pixels) / getMax_y_value();  
        g1.setPaint(Color.BLUE);

        for (int i = 0; i < Population.xcoordinates.size(); i++) {
            double x1 = mar + Population.xcoordinates.get(i) * xscalefactor;
            double y1 = height - mar - yscalefactor * Population.ycoordinates.get(i);          // This has to flip because y=0 in drawing area is at top but y=0 in plotting coordinates is at bottom
            if(Population.xcoordinates.get(i) < (Population.xcoordinates.size()-1)){          //draw lines between each point if it is not the last point
                double x2 = mar + Population.xcoordinates.get(i+1) * xscalefactor;
                double y2 = height - mar - yscalefactor * Population.ycoordinates.get(i+1);
                g1.draw(new Line2D.Double(x1, y1, x2, y2));
            }
            g1.draw(new Line2D.Double(x1, height - mar, x1, height-mar +8 ));   //x axis ticks(days)
            String xTick = Integer.toString(Population.xcoordinates.get(i));
            g.drawString(xTick,(int)x1,(int)height-mar +22 );
            System.out.printf("plotting x at : %f, plotting y at %f\n", x1,y1);
            g1.fill(new Ellipse2D.Double(x1 - 2, y1 - 2, 4, 4));

        }


        double xValueOfLabel = mar + (Population.xcoordinates.size()/2) * xscalefactor;        //x axis label
        g.drawString("Days of Simulation", (int)xValueOfLabel, height-mar+35);

        double yValueOfLabel = height - mar - yscalefactor * (getMax_y_value()/2);       //y axis label
        g.drawString("Total",mar-85, (int) yValueOfLabel);
        g.drawString("Infections",mar-85, (int) yValueOfLabel+15);

        double yTickInterval = Math.ceil(((getMax_y_value()/10)+1) / 10) * 10;          //y axis ticks and labels
        System.out.println(yTickInterval);
        for(int i = 1; i<=10; i++){
            double yTickValue = height - mar - yscalefactor * (i*yTickInterval);
            g1.draw(new Line2D.Double(mar, yTickValue, mar-5, yTickValue));
            Integer yTickRealValue = i * (int)yTickInterval;
            String yTickLabel = Integer.toString(yTickRealValue);
            g.drawString(yTickLabel,mar-25,(int)yTickValue);
        }






    }
	
	private int getMax_x_value() { 
        return Population.xcoordinates.size();
    }        //returns size of xcoordinates which is essentially same as max value

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
