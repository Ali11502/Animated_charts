package Graph.Bars;

import java.awt.*;

public class HorizontalBarText extends BarText{


    /**
     *
     * @param x x axis point
     * @param y y axis point
     * @param barWidth width of bar
     * @param barHeight height of bar
     * @param text text to be displayed
     */
    public HorizontalBarText(int x, int y, int barWidth, int barHeight, String text) {
        // x = x + barHeight + barWidth / 4     to keep bar text to the right of the bar
        // y + (3*barWidth / 4) + 35            to put bar text at the center of the bar

        super( x + barHeight + barWidth / 4,y + (3*barWidth / 4) + 35,barWidth,barHeight,text);
        calculateFontSize();
    }

    /**
     * calculates and sets the font size
     */
    private void calculateFontSize() {
        int size = this.getBarWidth() / 2;

        if (size > 20) {
            this.setFontSize(20);
        } else if (size < 9) {
            this.setFontSize(9);
        } else {
            this.setFontSize(size);
        }

    }

    /**
     * function to draw the bar text
     * @param g2d graphic to draw to
     */
    @Override
    public void draw(Graphics2D g2d) {
        //set the color of text
        g2d.setColor(Color.BLACK);

        //set the font of text
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, this.getFontSize()));

        //draw the text
        g2d.drawString(this.getText(),this.getX(),this.getY());
    }
}
