import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int maximum = 0;
        Board Cell_type;
        Cell_type = new Board();
        Cell_type.create();
        Cell_type.show();
        Scanner in = new Scanner(System.in);
        String option = "YES";
        while (Objects.equals(option, "YES")) {
            System.out.print("Выберите режим игры: \n1 - С другим человеком.\n2 - Против компьютера(обычная сложность).\n");
            Cell_type.clear();
            Cell_type.create();
            int Mode;
            Mode = in.nextInt();
            if (Mode == 1) {
                System.out.print("Введите в первой строке имя игрока 1, во второй имя игрока 2\n");
                String name3 = in.nextLine();
                String name1 = in.nextLine();
                String name2 = in.nextLine();
                Player Player1;
                Player Player2;
                Player1 = new Player(name1, 0);
                Player2 = new Player(name2, 0);
                Player1.Info();
                System.out.println();
                Player2.Info();
                System.out.println();
                boolean flag = true;
                while (flag) {
                    flag = false;
                    if (Cell_type.find(1)[1] == 1) {
                        Cell_type.show();
                        Cell_type.variants();


                        System.out.printf("Ход игрока %s.\nВведите координаты (x,y) ячейки, в которую хотите поставить X\n", name1);
                        int x, y;
                        x = in.nextInt();
                        y = in.nextInt();
                        while (x < 1 || x > 8 || y < 1 || y > 8 || !(Cell_type.correct(x, y))) {
                                System.out.println("Введите допустимые координаты");
                                x = in.nextInt();
                                y = in.nextInt();
                        }
                        Cell_type.change(x, y, 1);
                        Cell_type.fill(x - 1, y - 1, 1);
                        System.out.printf("Количество очков у игрока %s: %d\n", name1, Cell_type.points(1));
                        System.out.printf("Количество очков у игрока %s: %d\n", name2, Cell_type.points(2));
                        System.out.println();
                        flag = true;
                    }
                    if (Cell_type.find(2)[2] == 1) {
                        Cell_type.show();
                        Cell_type.variants();

                        System.out.printf("Ход игрока %s.\nВведите координаты (x,y) ячейки, в которую хотите поставить O\n", name2);
                        int x, y;
                        x = in.nextInt();
                        y = in.nextInt();
                        while (x < 1 || x > 8 || y < 1 || y > 8 || !(Cell_type.correct(x, y))) {
                                System.out.println("Введите допустимые координаты");
                                x = in.nextInt();
                                y = in.nextInt();
                        }
                        Cell_type.change(x, y, 2);
                        Cell_type.fill(x - 1, y - 1, 2);
                        System.out.printf("Количество очков у игрока %s: %d\n", name1, Cell_type.points(1));
                        System.out.printf("Количество очков у игрока %s: %d\n", name2, Cell_type.points(2));
                        System.out.println();
                        flag = true;

                        }
                }
                Cell_type.show();
                System.out.printf("Количество очков у игрока %s: %d\n", name1, Cell_type.points(1));
                System.out.printf("Количество очков у игрока %s: %d\n", name2, Cell_type.points(2));
                System.out.println();
            } else {
                boolean flag = true;
                while (flag) {
                    flag = false;
                    if (Cell_type.find(1)[1] == 1) {
                        Cell_type.show();
                        Cell_type.variants();

                        System.out.print("Ход игрока.\nВведите координаты (x,y) ячейки, в которую хотите поставить X\n");
                        int x, y;
                        x = in.nextInt();
                        y = in.nextInt();
                        while (x < 1 || x > 8 || y < 1 || y > 8 || !(Cell_type.correct(x, y)) ) {
                            System.out.println("Введите допустимые координаты");
                            x = in.nextInt();
                            y = in.nextInt();
                        }
                        Cell_type.change(x, y, 1);
                        Cell_type.fill(x - 1, y - 1, 1);
                        flag = true;
                    }
                    if (Cell_type.find(2)[2] == 1) {
                        int X_PC = (Cell_type.best(2)[0] + 1);
                        int Y_PC = (Cell_type.best(2)[1] + 1);
                        Cell_type.show();

                        System.out.printf("Ход компьютера. Идет на (%d, %d).\n", X_PC, Y_PC);
                        int x, y;
                        x = X_PC;
                        y = Y_PC;

                        Cell_type.change(x, y, 2);
                        Cell_type.fill(x - 1, y - 1, 2);
                        System.out.printf("Количество очков у игрока: %d\n" ,Cell_type.points(1));
                        System.out.printf("Количество очков у компьютера: %d\n", Cell_type.points(2));
                        System.out.println();
                        flag = true;
                    }
                }
                System.out.println();
            }
            maximum = Math.max(Cell_type.points(1), maximum);
            Cell_type.show();
            System.out.print("Сыграем еще раз? Введите YES, если да, и NO, если нет.\n");
            option = in.nextLine();
            option = in.nextLine();
        }
        System.out.printf("Максимальное колисетво очков за сессию: %d\n",maximum);
    }
}