public class Chicken extends Creature{

    public Chicken(Graph.Node room){
        setCurrentroom(room);
    }

    @Override
    public void move() {
        int randomRoom = (int)(Math.random()*currentroom.getNeighborArray().size());
        setCurrentroom(currentroom.getRandomNeighbor());
    }

    @Override
    public void act() {
        move();
    }
}
