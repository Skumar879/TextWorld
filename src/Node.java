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
        neighbors.add(n);
    }

    /**
     * Returns a String of the names of all the neighbors of this node
     * @return
     */
    public String getNeighborNames(){
        String output = "";
        for (int i = 0; i < neighbors.size(); i++) {
            output = output + neighbors.get(i).getName() + ", ";
        }
        return output;
    }

    /**
     * Return neighbor whose name is name. Returns null otherwise.
     * @param name name of neighboring node to return
     * @return returns neighboring node with correct name
     */
    public Node getNeighbor(String name){
        for (int i = 0; i < neighbors.size(); i++) {
             if(name.equals(neighbors.get(i).getName())) return neighbors.get(i);
        }
        return null;
    }
    public Node getNode(Node j){
        for (int i = 0; i < neighbors.size(); i++) {
            if(j.equals(neighbors.get(i))) return neighbors.get(i);
        }
        return null;
    }

    public ArrayList<Node> getNeighborArrayList(){
        return neighbors;
    }

    public String getName(){
        return name;
    }
}
