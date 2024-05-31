package Graph.Bars;

import Frames.JavaGraphs;

import java.awt.*;

import static Frames.JavaGraphs.getFrameHeight;
import static Graph.BarGraph.VertTextScale;
import static Graph.Graph.highestLetterCount;

public class VerticalBarText extends BarText{

    /**
     *
     * @param x x axis point
     * @param y y axis point
     * @param barWidth width of bar
     * @param barHeight height of bar
     * @param text text to be displayed
     */
    public VerticalBarText(int x, int y, int barWidth, int barHeight, String text) {
        // x = x + (3*barWidth / 4)                                          to keep bar text at the center of the bar
        // y = JavaGraphs.getFrameHeight() - barHeight - y - barWidth / 6    to keep bar text at top of the bar

        super(x + (3*barWidth / 4),JavaGraphs.getFrameHeight() - barHeight - y - barWidth / 6 ,barWidth,barHeight,text);
        setFontsize();
    }

    /**
     * set font size
     */
    private void setFontsize() {
        //calculate and set the font size based on the highest letter word so that it fits
        if (highestLetterCount<10) {
            this.setFontSize(highestLetterCount / 2 + 10);
        }
        else {
            this.setFontSize(highestLetterCount / 2 + 5);
        }



    }

    /**
     * function to draw the bar text
     * @param g2d graphic to draw to
     */
    @Override
    public void draw(Graphics2D g2d) {
        g2d.translate((float)this.getX(),(float)this.getY());                       // pen goes to x and y coordinate
        g2d.rotate(Math.toRadians(-90));                                            // rotates the pen to -90 degrees
        g2d.setColor(Color.BLACK);                                                  // sets color to black
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, this.getFontSize()));  // sets the font
        g2d.drawString(this.getText(),0,0);                                    // draws the string
        g2d.rotate(-Math.toRadians(-90));                                           // restores pens original degrees
        g2d.translate(-(float)this.getX(),-(float)this.getY());                     // restores pen original coordinates
    }
}
