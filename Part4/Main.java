import javax.naming.NoInitialContextException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String [] args){
        /*===============================================
    Properties of a DAG
    1) All edges between nodes are directed. (An edge that goes from A to B does not also go from B to A)
    2) The Graph must be acyclic
    3) The nodes and edges will not change so that when an edge is made it is only added to the
    adgency list of one node and not both nodes at once. The nodes will also keep track of their indegree
    =================================================== */
        ArrayList<Node> output = new ArrayList<>();
        DirectedGraph dg = createRandomDAGIter(1000);
        //dg = makeTestGraph();
        ArrayList<Node> out1 = TopSort.Khans(dg);
        ArrayList<Node> out2 = TopSort.mDFS(dg);
        System.out.println();
    }
    public static DirectedGraph createRandomDAGIter(final int n){
        DirectedGraph graph = new DirectedGraph();
        for (int i =0; i<n; i++){
            graph.addNode(i+"");
        }
        Random rand = new Random();
        //Node[] nodes = graph.getAllNodes().toArray(new Node[0]);
        int node1 = rand.nextInt(n);
        int node2 = rand.nextInt(n);
        int repitions = rand.nextInt((int)Math.pow(n,2));
        for (int i = 0; i < repitions;){
            if (node1 == node2 || node1>node2){
                node1 = rand.nextInt(n);
                node2 = rand.nextInt(n);
                continue;
            }
            graph.addDirectedEdge(graph.getNode(node1+""), graph.getNode(node2+""));
            i++;
            node1 = rand.nextInt(n);
            node2 = rand.nextInt(n);
        }
        return graph;
    }

    public static DirectedGraph makeTestGraph(){
        DirectedGraph graph = new DirectedGraph();
        graph.addNode("0");graph.addNode("1");graph.addNode("2");graph.addNode("3");
        graph.addNode("4");graph.addNode("5");graph.addNode("6");graph.addNode("7");
        graph.addNode("8");graph.addNode("9");

        graph.addDirectedEdge(graph.getNode("0"), graph.getNode("2"));
        graph.addDirectedEdge(graph.getNode("0"), graph.getNode("4"));
        graph.addDirectedEdge(graph.getNode("2"), graph.getNode("3"));
        graph.addDirectedEdge(graph.getNode("2"), graph.getNode("4"));
        graph.addDirectedEdge(graph.getNode("5"), graph.getNode("7"));
        graph.addDirectedEdge(graph.getNode("5"), graph.getNode("9"));
        graph.addDirectedEdge(graph.getNode("6"), graph.getNode("8"));
        graph.addDirectedEdge(graph.getNode("7"), graph.getNode("9"));
        graph.addDirectedEdge(graph.getNode("8"), graph.getNode("9"));

        return graph;
    }
}