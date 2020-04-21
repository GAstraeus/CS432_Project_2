import javafx.util.Pair;

import java.util.*;

public class Main {
    public static void main(String [] args){
        GridGraph graph = createRandomCompleteWeightedGraph(100);
        ArrayList<Node> out = astar(graph.getNode(0,0), graph.getNode(99,99));

    }
    public static GridGraph createRandomCompleteWeightedGraph(final int n){
        GridGraph graph = new GridGraph(n);
        for (int x =0; x<n; x++){
            for (int y = 0; y<n; y++) {
                graph.addNode(x,y,x+y+"");
            }
        }
        Random random = new Random();
        for (Node node: graph.getAllNodes()){
            for (Node child: graph.getValidChildren(node)){
                if(random.nextBoolean())
                    graph.addUndirectedEdge(node, child);
            }
        }
        return graph;
    }
    public static ArrayList<Node> astar(final Node start, final Node end){
        PriorityQueue<Pair<Node,Integer>> priorityQueue = new PriorityQueue<Pair<Node,Integer>>(new aStarNodeComparator());
        HashMap<Node, int[]> distances = new HashMap<>();
        HashSet<Node> finalize = new HashSet<>();
        HashMap<Node, Node> parent = new HashMap<>();
        //priorityQueue.add(new Pair<>(start,heuristic(start,end)));
        distances.put(start, new int[] {0,heuristic(start, end)});
        parent.put(start,null);

        Node curr = start;
        while (curr != end){
            finalize.add(curr);
            for (Node child : curr.children){
                if (!finalize.contains(child)){
                    int distance = distances.get(curr)[0]+1;
                    int Heuristic = heuristic(child, end);
                    if (!distances.containsKey(child) || distance+Heuristic < distances.get(child)[0]+distances.get(child)[1]){
                        priorityQueue.add(new Pair<>(child,distance+Heuristic));
                        distances.put(child, new int[] {distance,Heuristic});
                        parent.put(child, curr);
                    }
                }
            }
            int minDistance = Integer.MAX_VALUE;
            curr = priorityQueue.poll().getKey();
            for (Node n: distances.keySet()){
                if (distances.get(n)[0]+distances.get(n)[1] < minDistance && !finalize.contains(n)){
                    curr = n;
                    minDistance = distances.get(n)[0]+distances.get(n)[1];
                }
            }

        }
        ArrayList<Node> order = new ArrayList<>();
        Node n = end;
        while(n != null){
            order.add(n);
            n = parent.get(n);
        }
        Collections.reverse(order);
        return order;
    }

    public static int heuristic(final Node node, final Node dest) {
        return Math.abs(dest.x - node.x + dest.y - node.y);
    }
}

class aStarNodeComparator implements Comparator<Pair<Node, Integer>> {
    public int compare(Pair<Node,Integer> obj1, Pair<Node,Integer> obj2)
    {
        return obj1.getValue().compareTo(obj2.getValue());
    }
}
