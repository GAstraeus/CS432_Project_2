import java.util.ArrayList;

public class Node implements Comparable{
    public String value;
    public boolean visited;
    public Node(final String value){
        this.value = value;
        this.visited = false;
    }
    @Override
    public String toString() {
        return this.value;
    }
    @Override
    public boolean equals(Object o){
        Node node2 = (Node) o;
        return this.value.equals(node2.value);
    }
    @Override
    public int compareTo(Object o){
        Node node2 = (Node) o;
        Integer one = Integer.parseInt(this.value);
        Integer two = Integer.parseInt(node2.value);
        return one.compareTo(two);
    }
}