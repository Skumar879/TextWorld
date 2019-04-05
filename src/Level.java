import java.util.ArrayList;
import java.util.HashMap;

public class Level{
    //    private ArrayList<Node> nodes;
    private HashMap<String, Room> nodes;


    public Level(){
//      nodes = new ArrayList<>();
        nodes = new HashMap<>();
    }

    public void addNode(String name) {
        nodes.put(name, new Room(name));
    }

    public void addDirectedEdge(String name1, String name2) {
        Room n1 = getNode(name1);
        Room n2 = getNode(name2);
        n1.addNeighbor(n2);
    }

    public void addUndirectedEdge(String name1, String name2) {
        Room n1 = getNode(name1);
        Room n2 = getNode(name2);
        n1.addNeighbor(n2);
        n2.addNeighbor(n1);
    }

    public Room getNode(String name) {
        return nodes.get(name);
    }


}
