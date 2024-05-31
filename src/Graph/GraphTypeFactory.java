package Graph;

import Graph.Bars.Bar;
import Graph.Bars.BarFactory;
import Graph.Bars.HorizontalBar;
import Graph.Bars.VerticalBar;

import java.util.ArrayList;

public class GraphTypeFactory {

    /**
     * an instance for GraphTypeFactory, used for making GraphTypeFactory a singleton
     */
    private static GraphTypeFactory instance = null;

    private GraphTypeFactory() {
    }

    /**
     *
     * @returns one instance of GraphTypeFactory
     */
    public static GraphTypeFactory GetInstance() {
        if (instance == null) {
            return new GraphTypeFactory();
        }
        return instance;
    }

    /**
     * returns a graph object of the required type
     * @param x x position of th graph
     * @param y y position of the graph
     * @param data data from the file
     * @param graphType type of graph you want
     * @return an object of graph
     */
    public Graph getGraph(int x, int y, ArrayList<String[]> data, String graphType) {

        if (graphType.equals("HBAR")) {
            return new HorizontalBarGraph(x,y,data);
        } else if (graphType.equals("VBAR")) {
            return new VerticalBarGraph(x,y,data);
        }

        return new LineGraph(x,y,data);
    }
}
