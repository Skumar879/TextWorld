public class Wumpus extends Creature{
    Player avoid;

    public Wumpus(Room startingroom, Player player){
        setCurrentroom(startingroom);
        avoid = player;
    }
    @Override
    public void act() {
        if(!currentroom.getRandomNeighbor().equals(avoid.getCurrentroom())) setCurrentroom(currentroom.getRandomNeighbor());
    }

}

