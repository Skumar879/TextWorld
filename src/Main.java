import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Build up a graph of connected nodes
        Node root = new Node("hall");

        root.addNeighbor(new Node ("closet"));
        root.addNeighbor(new Node ("bedroom"));

        root.getNeighbor("closet").addNeighbor(new Node("hall"));

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
}
