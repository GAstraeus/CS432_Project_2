import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Node implements Comparable{
    public String value;
    public HashSet<Node> children;
    public int x;
    public int y;

    /**
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param value
     */
    public Node(final int x, final int y, final String value){
        this.value = value;
        this.children = new HashSet<>();
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "("+this.x+","+this.y+")";
    }
    @Override
    public boolean equals(Object o){
        Node node2 = (Node) o;
        return this.x == node2.x && this.y == node2.y;
    }
    @Override
    public int compareTo(Object o){
        Node node2 = (Node) o;
        Integer one = Integer.parseInt(this.value);
        Integer two = Integer.parseInt(node2.value);
        return one.compareTo(two);
    }

    public String getValue() {
        return value;
    }

    public HashSet<Node> getChildren() {
        return children;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setChildren(HashSet<Node> children) {
        this.children = children;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}