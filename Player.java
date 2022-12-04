public class Player {
    private final String name;
    private final int points;

    private final int[][] Cell_type = new int[8][8];

    public Player(String name, int points) {
        this.name = name;
        this.points = points;
    }
    public void Info(){
        System.out.printf("Количество очков у игрока %s: %d", name, points);
    }
}
