public abstract class Entity {
    private int x;
    private int y;

    public Entity() {
    }

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
