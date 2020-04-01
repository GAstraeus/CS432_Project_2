import javax.naming.NoInitialContextException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String [] args){
        ArrayList<Node> output = new ArrayList<>();

        /*
        System.out.println("BFT Rec 100 Nodes:");
        output = BFTRecLinkedList(createLinkedList(100));
        System.out.println("Complete");
         */


        /*
        System.out.println("BFT Rec 10000 Nodes:");
        output = BFTRecLinkedList(createLinkedList(10000));
        System.out.println("Complete");
         */

        /*
        System.out.println("BFT Iter 10000 Nodes:");
        output = BFTIterLinkedList(createLinkedList(10000));
        System.out.println("Complete");
         */

    }
    public static Graph createRandomUnweightedGraphIter(final int n){
        Graph graph = new Graph();
        for (int i =0; i<n; i++){
            graph.addNode(i+"");
        }
        Random rand = new Random();
        Node[] nodes = graph.getAllNodes().toArray(new Node[0]);
        int node1 = rand.nextInt(n);
        int node2 = rand.nextInt(n);
        int repitions = rand.nextInt((int)Math.pow(n,2));
        for (int i = 0; i < repitions;){
            if (node1 == node2){
                node1 = rand.nextInt(n);
                node2 = rand.nextInt(n);
                continue;
            }
            graph.addUndirectedEdge((Node) nodes[node1], (Node) nodes[node2]);
            i++;
        }
        return graph;
    }

    public static Graph createLinkedList(final int n){
        Graph graph = new Graph();
        for (int i =0; i<n; i++){
            graph.addNode(i+"");
        }
        Node[] nodes = graph.getAllNodes().toArray(new Node[0]);
        Arrays.sort(nodes);
        for(int i = 1; i < nodes.length; i++){
            graph.addUndirectedEdge((Node)nodes[i], (Node) nodes[i-1]);
        }
        return graph;
    }

    public static ArrayList<Node> BFTRecLinkedList(final Graph graph){
        GraphSearch search = new GraphSearch(graph);
        return search.BFSRec(graph.getNode("0"),graph.getNode("9999"));
    }

    public static ArrayList<Node> BFTIterLinkedList(final Graph graph){
        GraphSearch search = new GraphSearch(graph);
        return search.BFSIterative(graph.getNode("0"),graph.getNode("9999"));
    }

    public static ArrayList<Node> testDFSRec(){
        Graph graph = new Graph();
        graph.addNode("1");
        graph.addNode("2");
        graph.addNode("3");
        graph.addNode("4");
        graph.addNode("5");
        graph.addNode("6");
        graph.addUndirectedEdge(graph.getNode("1"),graph.getNode("2"));
        graph.addUndirectedEdge(graph.getNode("2"),graph.getNode("3"));
        graph.addUndirectedEdge(graph.getNode("2"),graph.getNode("4"));
        graph.addUndirectedEdge(graph.getNode("3"),graph.getNode("5"));
        graph.addUndirectedEdge(graph.getNode("5"),graph.getNode("6"));
        GraphSearch graphSearch = new GraphSearch(graph);
        return graphSearch.DFSRec(graph.getNode("1"),graph.getNode("4"));
    }
    public static ArrayList<Node> testDFSIter(){
        Graph graph = new Graph();
        graph.addNode("1");
        graph.addNode("2");
        graph.addNode("3");
        graph.addNode("4");
        graph.addNode("5");
        graph.addNode("6");
        graph.addUndirectedEdge(graph.getNode("1"),graph.getNode("2"));
        graph.addUndirectedEdge(graph.getNode("2"),graph.getNode("3"));
        graph.addUndirectedEdge(graph.getNode("2"),graph.getNode("4"));
        graph.addUndirectedEdge(graph.getNode("3"),graph.getNode("5"));
        graph.addUndirectedEdge(graph.getNode("5"),graph.getNode("6"));
        GraphSearch graphSearch = new GraphSearch(graph);
        return graphSearch.DFSIter(graph.getNode("1"),graph.getNode("4"));
    }

    public static ArrayList<Node> testBFSRec(){
        Graph graph = new Graph();
        graph.addNode("1");
        graph.addNode("2");
        graph.addNode("3");
        graph.addNode("4");
        graph.addNode("5");
        graph.addNode("6");
        graph.addUndirectedEdge(graph.getNode("1"),graph.getNode("2"));
        graph.addUndirectedEdge(graph.getNode("1"),graph.getNode("3"));
        graph.addUndirectedEdge(graph.getNode("1"),graph.getNode("4"));
        graph.addUndirectedEdge(graph.getNode("4"),graph.getNode("5"));
        graph.addUndirectedEdge(graph.getNode("5"),graph.getNode("6"));
        GraphSearch search = new GraphSearch(graph);
        return search.BFSRec(graph.getNode("1"), graph.getNode("5"));
    }

    public static ArrayList<Node> testBFSIter(){
        Graph graph = new Graph();
        graph.addNode("1");
        graph.addNode("2");
        graph.addNode("3");
        graph.addNode("4");
        graph.addNode("5");
        graph.addNode("6");
        graph.addUndirectedEdge(graph.getNode("1"),graph.getNode("2"));
        graph.addUndirectedEdge(graph.getNode("1"),graph.getNode("3"));
        graph.addUndirectedEdge(graph.getNode("1"),graph.getNode("4"));
        graph.addUndirectedEdge(graph.getNode("4"),graph.getNode("5"));
        graph.addUndirectedEdge(graph.getNode("5"),graph.getNode("6"));
        GraphSearch search = new GraphSearch(graph);
        return search.BFSIterative(graph.getNode("1"), graph.getNode("5"));
    }
}
