package ArbitrageDetection;

import java.util.ArrayList;
import java.util.List;

public class BellmanFord {

    private List<Edge> edgeList;
    private List<Vertex> vertexList;
    private List<Vertex> cycleList;


    public BellmanFord(List<Vertex> vertexList,List<Edge> edgeList) {
        this.edgeList = edgeList;
        this.vertexList = vertexList;
    }

    public void bellmanFord(Vertex sourceVertex) {
        sourceVertex.setDistance(0);

        for (int i = 0; i < vertexList.size() - 1; i++) {

            for(Edge edge : edgeList){

                Vertex startVertex = edge.getStartVertex();
                Vertex targetVertex = edge.getTargetVertex();

                if(startVertex.getDistance() == Double.MAX_VALUE) continue;
                double newDistance = startVertex.getDistance() + edge.getWeight();

                if(newDistance < targetVertex.getDistance()){
                    targetVertex.setDistance(newDistance);
                    targetVertex.setPreviousVertex(startVertex);

                }
            }
        }

        //Negative Cycles--Vth Iteration
        for( Edge edge: edgeList){

            if( edge.getStartVertex().getDistance() != Double.MAX_VALUE){

                if( hasCycle(edge)){

                    this.cycleList = new ArrayList<>();
                    System.out.println("There has been Negative cycle detected...");
                    Vertex vertex = edge.getStartVertex();

                    while(! vertex.equals(edge.getTargetVertex())){
                        this.cycleList.add(vertex);
                        vertex = vertex.getPreviousVertex();
                    }

                    this.cycleList.add(edge.getStartVertex());
                    return;
                }
            }
        }

    }

    private boolean hasCycle(Edge edge) {
        return edge.getStartVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance();
    }

    public void getShortestPath(Vertex targetVertex){
        if( targetVertex.getDistance() == Double.MAX_VALUE){
            System.out.println("There is no path to the target vertex..");
        }

        Vertex actualVertex = targetVertex;

        while( actualVertex.getPreviousVertex() != null){
            System.out.print(actualVertex+" - ");
            actualVertex = actualVertex.getPreviousVertex();
        }
    }

    public void printCycle(){
        if(this.cycleList != null){
            System.out.println("Arbitrage opportunities detected....");
            for(Vertex vertex: this.cycleList){
                System.out.println(vertex);
            }
        }else {
            System.out.println("No Arbitrage opportunities..");
        }
    }
}
