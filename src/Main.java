import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Build up a graph of connected nodes
        Node root = new Node("hall");

        root.addNeighbor(new Node ("closet"));
        root.addNeighbor(new Node ("bedroom"));

        root.getNeighbor("closet").addNeighbor(new Node("hall"));
        root.getNeighbor("bedroom").addNeighbor(new Node("living room"));
        root.getNeighbor("bedroom").getNeighbor("living room").addNeighbor(new Node("kitchen"));
        root.getNeighbor("bedroom").getNeighbor("living room").addNeighbor(new Node("dining room"));
        root.getNeighbor("bedroom").getNeighbor("living room").getNeighbor("dining room").addNeighbor(root);

        displaypaths(root);
        //"game loop"  where I get user input and move the player.
        Node currentRoom = root;

        String response = "";
        Scanner in = new Scanner(System.in);

        do{
            //display the room and the exits
            System.out.println("You are currently in the " + currentRoom.getName());
            System.out.println("You can go to the: " + currentRoom.getNeighborNames());

            //ask player what they want to do
            System.out.print("Type the name of the room you want to go to: ");
            response = in.nextLine();

            //do that
            Node nextRoom = currentRoom.getNeighbor(response);
            if(nextRoom == null) {
                System.out.println("You can't go to " + response + " try again");
            } else{
                currentRoom = nextRoom;
            }

        } while (!response.equals("quit"));
    }

    private static void displaypaths(Node root) {
        if(root.getNeighborArrayList().size() != 0) {
            for (int i = 0; i < root.getNeighborArrayList().size(); i++) {
                System.out.print(root.getName() + " ---> " );
                displaypaths(root.getNeighborArrayList().get(i));
                System.out.println();
            }
        }
    }
}
