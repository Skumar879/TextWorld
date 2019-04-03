public abstract class Creature {
    protected Graph.Node currentroom;
    protected String name;
    protected String description;

    public abstract void move();

    public abstract void act();

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Graph.Node getCurrentroom() {
        return currentroom;
    }

    public void setCurrentroom(Graph.Node currentroom) {
        this.currentroom = currentroom;
    }
}
