package Graph.Bars;

public class BarFactory {

    /**
     * an instance for barfactory, used for making barfactory a singleton
     */
    private static BarFactory instance = null;

    private BarFactory() {
    }

    /**
     *
     * @returns one instance of barFactory
     */
    public static BarFactory GetInstance() {
        if (instance == null) {
            return new BarFactory();
        }
        return instance;
    }

    /**
     * return a bar object
     * @param x top left x location of the bar
     * @param y top left y location of the bar
     * @param barWidth width of the bar
     * @param barHeight height of the bar
     * @param barText text of the bar
     * @param vertical if true, return vertical bar, else return horizontal bar
     * @return
     */
    public Bar getBar(int x, int y, int barWidth, int barHeight, String barText, boolean vertical) {

        if (vertical) {
            return new VerticalBar(x,y,barWidth,barHeight,barText);
        } else {
            return new HorizontalBar(x,y,barWidth,barHeight,barText);
        }

    }

}
