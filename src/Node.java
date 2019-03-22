import java.util.ArrayList;

public class Node {
    private String name;
    private ArrayList<Node> neighbors;

    public Node(String name){
        neighbors = new ArrayList<Node>();
        this.name = name;
    }

    public void addNeighbor(Node n){
        //add this node as a neighbor
    }

    /**
     * Returns a String of the names of all the neighbors of this node
     * @return
     */
    public String getNeighborNames(){
        return " ";
    }

    /**
     * Return neighbor whose name is name. Returns null otherwise.
     * @param name name of neighboring node to return
     * @return returns neighboring node with correct name
     */
    public Node getNeighbor(String name){
        return null;
    }
    public Node getNode(Node j){
    return null;
    }

    public String getName(){
        return name;
    }
}
