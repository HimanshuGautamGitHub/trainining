/**
 *
 *
 *  *  USD 1      0.741  0.657  1.061  1.005
 *  *  EUR 1.349  1      0.888  1.433  1.366
 *  *  GBP 1.521  1.126  1      1.614  1.538
 *  *  CHF 0.942  0.698  0.619  1      0.953
 *  *  CAD 0.995  0.732  0.650  1.049  1
 *
 *  *  1000.00000 USD =  741.00000 EUR
 *  *   741.00000 EUR = 1012.20600 CAD
 *  *  1012.20600 CAD = 1007.14497 USD
 */

package ArbitrageDetection;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(new Vertex("USD"));
        vertexList.add(new Vertex("EUR"));
        vertexList.add(new Vertex("GBP"));
        vertexList.add(new Vertex("CHF"));
        vertexList.add(new Vertex("CAD"));

        List<Edge> edgeList = new ArrayList<>();

        edgeList.add( new Edge(vertexList.get(0),vertexList.get(1), -1*Math.log(0.741)));
        edgeList.add( new Edge(vertexList.get(0),vertexList.get(2), -1*Math.log(0.657)));
        edgeList.add( new Edge(vertexList.get(0),vertexList.get(3), -1*Math.log(1.061)));
        edgeList.add( new Edge(vertexList.get(0),vertexList.get(4), -1*Math.log(1.005)));


        edgeList.add( new Edge(vertexList.get(1),vertexList.get(0), -1*Math.log(1.349)));
        edgeList.add( new Edge(vertexList.get(1),vertexList.get(2), -1*Math.log(0.888)));
        edgeList.add( new Edge(vertexList.get(1),vertexList.get(3), -1*Math.log(1.433)));
        edgeList.add( new Edge(vertexList.get(1),vertexList.get(4), -1*Math.log(1.366)));

        edgeList.add( new Edge(vertexList.get(2),vertexList.get(0), -1*Math.log(1.521)));
        edgeList.add( new Edge(vertexList.get(2),vertexList.get(1), -1*Math.log(1.126)));
        edgeList.add( new Edge(vertexList.get(2),vertexList.get(3), -1*Math.log(1.614)));
        edgeList.add( new Edge(vertexList.get(2),vertexList.get(4), -1*Math.log(1.538)));

        edgeList.add( new Edge(vertexList.get(3),vertexList.get(0), -1*Math.log(0.942)));
        edgeList.add( new Edge(vertexList.get(3),vertexList.get(1), -1*Math.log(0.698)));
        edgeList.add( new Edge(vertexList.get(3),vertexList.get(2), -1*Math.log(0.619)));
        edgeList.add( new Edge(vertexList.get(3),vertexList.get(4), -1*Math.log(0.953)));

        edgeList.add( new Edge(vertexList.get(4),vertexList.get(0), -1*Math.log(0.995)));
        edgeList.add( new Edge(vertexList.get(4),vertexList.get(1), -1*Math.log(0.732)));
        edgeList.add( new Edge(vertexList.get(4),vertexList.get(2), -1*Math.log(0.650)));
        edgeList.add( new Edge(vertexList.get(4),vertexList.get(3), -1*Math.log(1.049)));


        BellmanFord bellmanFordAlgo = new BellmanFord(vertexList,edgeList);
        bellmanFordAlgo.bellmanFord(vertexList.get(0));
        bellmanFordAlgo.printCycle();


    }
}
