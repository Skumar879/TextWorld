import java.util.ArrayList;

public class Wumpus extends Creature{
    Player avoid;

    public Wumpus(Room startingroom, Player player){
        setCurrentroom(startingroom);
        avoid = player;
    }
    @Override
    public void act() {
        ArrayList<Room> helpmysoul = new ArrayList<Room>(currentroom.getNeighborArray().values());
        for (int i = 0; i < helpmysoul.size(); i++) {
            if(!avoid.getCurrentroom().equals(helpmysoul.get(i)) && !checkforPlayer(new ArrayList<Room>(helpmysoul.get(i).getNeighborArray().values()))) setCurrentroom(helpmysoul.get(i));
        }
    }

    public boolean checkforPlayer(ArrayList<Room> helpme){
        for (int i = 0; i < helpme.size(); i++) {
            if(avoid.getCurrentroom().equals(helpme.get(i))) return true;
        }
        return false;
    }
}

