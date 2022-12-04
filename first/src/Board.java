public class Board {
    private final int[][] Cell_type = new int[8][8];
    private final int[][] duplicate = new int[8][8];
    static final String End = "| %c |";

    public Board() {
        int[][] Cell_type = new int[8][8];
    }

    public void clear(){
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Cell_type[x][y] = 0;
            }
        }
    }
    public void create() {
        Cell_type[3][3] = 1; // "X"
        Cell_type[3][4] = 2; //"O"
        Cell_type[4][3] = 2; // "O"
        Cell_type[4][4] = 1;
    }

    public void show() {
        for (int i = 0; i < 8; i++) {
            System.out.printf("    %d", i + 1);
        }
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.printf("%d ", i + 1);
            for (int j = 0; j < 8; j++) {
                if (Cell_type[i][j] == 0) {
                    System.out.printf(End, ' ');
                    duplicate[i][j] = 0;
                } else if (Cell_type[i][j] == 1) {
                    System.out.printf(End, 'X');
                    duplicate[i][j] = 0;
                } else if (Cell_type[i][j] == 2) {
                    System.out.printf(End, 'O');
                    duplicate[i][j] = 0;
                }
                if (Cell_type[i][j] == 4) {
                    System.out.printf(End, '+');
                    Cell_type[i][j] = 0;
                    duplicate[i][j] = 4;
                }
            }
            System.out.println();
        }
    }

    public void change(int x, int y, int player_number) {
        if (player_number == 1) {
            Cell_type[x - 1][y - 1] = 2;
        } else {
            Cell_type[x - 1][y - 1] = 1;
        }
    }
    public boolean correct(int x, int y){
        return duplicate[x - 1][y - 1] == 4;
    }
    public int points(int Number) {
        int Summa = 0;
        if (Number == 1) {
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    if (Cell_type[x][y] == 2) {
                        Summa += 1;
                    }
                }
            }
        }
        else {
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    if (Cell_type[x][y] == 1) {
                        Summa += 1;
                    }
                }
            }
        }
        return Summa;
    }

    public int[] find(int player_number) {
        int[] ret = new int[5];
        ret[0] = 0;
        ret[1] = 0;
        ret[2] = 0;
        if (player_number == 1) { // O
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (Cell_type[i][j] == 1) { // X
                        if (i != 0) {
                            if (Cell_type[i - 1][j] == 0) { // вниз
                                int k = i;
                                while ((Cell_type[k][j] == 1) && (k != 7)) {
                                    k += 1;
                                }
                                if (Cell_type[k][j] == 2) {
                                    Cell_type[i - 1][j] = 4;
                                    ret[1] = 1;
                                }
                            }
                        }
                        if (i != 7) {
                            if (Cell_type[i + 1][j] == 0) { // вверх
                                int k = i;
                                while ((Cell_type[k][j] == 1) && (k != 0)) {
                                    k -= 1;
                                }
                                if (Cell_type[k][j] == 2) {
                                    Cell_type[i + 1][j] = 4;
                                    ret[1] = 1;
                                }
                            }
                        }
                        if (j != 7) {
                            if (Cell_type[i][j + 1] == 0) { // вправо
                                int k = j;
                                while ((Cell_type[i][k] == 1) && (k != 0)) {
                                    k -= 1;
                                }
                                if (Cell_type[i][k] == 2) {
                                    Cell_type[i][j + 1] = 4;
                                    ret[1] = 1;
                                }
                            }
                        }
                        if (j != 0) {
                            if (Cell_type[i][j - 1] == 0) { // влево
                                int k = j;
                                while ((Cell_type[i][k] == 1) && (k != 7)) {
                                    k += 1;
                                }
                                if (Cell_type[i][k] == 2) {
                                    Cell_type[i][j - 1] = 4;
                                    ret[1] = 1;
                                }
                            }
                        }
                        if (j != 0 && i != 0) {
                            if (Cell_type[i - 1][j - 1] == 0) { // влево
                                int k = j;
                                int t = i;
                                while ((Cell_type[t][k] == 1) && (k != 7) && (t != 7)) {
                                    k += 1;
                                    t += 1;
                                }
                                if (Cell_type[t][k] == 2) {
                                    Cell_type[i - 1][j - 1] = 4;
                                    ret[1] = 1;
                                }
                            }
                        }
                        if (j != 7 && i != 7) {
                            if (Cell_type[i + 1][j + 1] == 0) { // вправо
                                int k = j;
                                int t = i;
                                while ((Cell_type[t][k] == 1) && (k != 0) && (t != 0)) {
                                    k -= 1;
                                    t -= 1;
                                }
                                if (Cell_type[t][k] == 2) {
                                    Cell_type[i + 1][j + 1] = 4;
                                    ret[1] = 1;
                                }
                            }
                        }
                        if (j != 7 && i != 0) {
                            if (Cell_type[i - 1][j + 1] == 0) { // влево
                                int k = j;
                                int t = i;
                                while ((Cell_type[t][k] == 1) && (k != 0) && (t != 7)) {
                                    k -= 1;
                                    t += 1;
                                }
                                if (Cell_type[t][k] == 2) {
                                    Cell_type[i - 1][j + 1] = 4;
                                    ret[1] = 1;
                                }
                            }
                        }
                        if (j != 0 && i != 7) {
                            if (Cell_type[i + 1][j - 1] == 0) { // вправо
                                int k = j;
                                int t = i;
                                while ((Cell_type[t][k] == 1) && (k != 7) && (t != 0)) {
                                    k += 1;
                                    t -= 1;
                                }
                                if (Cell_type[t][k] == 2) {
                                    Cell_type[i + 1][j - 1] = 4;
                                    ret[1] = 1;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (Cell_type[i][j] == 2) { // O
                        if (i != 0) {
                            if (Cell_type[i - 1][j] == 0) { // вниз
                                int k = i;
                                while ((Cell_type[k][j] == 2) && (k != 7)) {
                                    k += 1;
                                }
                                if (Cell_type[k][j] == 1) {
                                    Cell_type[i - 1][j] = 4;
                                    ret[2] = 1;
                                }
                            }
                        }
                        if (i != 7) {
                            if (Cell_type[i + 1][j] == 0) { // вверх
                                int k = i;
                                while ((Cell_type[k][j] == 2) && (k != 0)) {
                                    k -= 1;
                                }
                                if (Cell_type[k][j] == 1) {
                                    Cell_type[i + 1][j] = 4;
                                    ret[2] = 1;
                                }
                            }
                        }
                        if (j != 7) {
                            if (Cell_type[i][j + 1] == 0) { // вправо
                                int k = j;
                                while ((Cell_type[i][k] == 2) && (k != 0)) {
                                    k -= 1;
                                }
                                if (Cell_type[i][k] == 1) {
                                    Cell_type[i][j + 1] = 4;
                                    ret[2] = 1;
                                }
                            }
                        }
                        if (j != 0) {
                            if (Cell_type[i][j - 1] == 0) { // влево
                                int k = j;
                                while ((Cell_type[i][k] == 2) && (k != 7)) {
                                    k += 1;
                                }
                                if (Cell_type[i][k] == 1) {
                                    Cell_type[i][j - 1] = 4;
                                    ret[2] = 1;
                                }
                            }
                        }
                        if (j != 0 && i != 0) {
                            if (Cell_type[i - 1][j - 1] == 0) { // влево
                                int k = j;
                                int t = i;
                                while ((Cell_type[t][k] == 2) && (k != 7) && (t != 7)) {
                                    k += 1;
                                    t += 1;
                                }
                                if (Cell_type[t][k] == 1) {
                                    Cell_type[i - 1][j - 1] = 4;
                                    ret[2] = 1;
                                }
                            }
                        }
                        if (j != 7 && i != 7) {
                            if (Cell_type[i + 1][j + 1] == 0) { // вправо
                                int k = j;
                                int t = i;
                                while ((Cell_type[t][k] == 2) && (k != 0) && (t != 0)) {
                                    k -= 1;
                                    t -= 1;
                                }
                                if (Cell_type[t][k] == 1) {
                                    Cell_type[i + 1][j + 1] = 4;
                                    ret[2] = 1;
                                }
                            }
                        }
                        if (j != 7 && i != 0) {
                            if (Cell_type[i - 1][j + 1] == 0) { // влево
                                int k = j;
                                int t = i;
                                while ((Cell_type[t][k] == 2) && (k != 0) && (t != 7)) {
                                    k -= 1;
                                    t += 1;
                                }
                                if (Cell_type[t][k] == 1) {
                                    Cell_type[i - 1][j + 1] = 4;
                                    ret[2] = 1;
                                }
                            }
                        }
                        if (j != 0 && i != 7) {
                            if (Cell_type[i + 1][j - 1] == 0) { // вправо
                                int k = j;
                                int t = i;
                                while ((Cell_type[t][k] == 2) && (k != 7) && (t != 0)) {
                                    k += 1;
                                    t -= 1;
                                }
                                if (Cell_type[t][k] == 1) {
                                    Cell_type[i + 1][j - 1] = 4;
                                    ret[2] = 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }

    public void fill(int x, int y, int player_number) {
        if (player_number == 1) { // O
            if (x != 7) { // вверх
                int k = x + 1;
                while ((Cell_type[k][y] == 1) && (k != 7)) {
                    k += 1;
                }
                if (Cell_type[k][y] == 2) {
                    k = x + 1;
                    while ((Cell_type[k][y] != 2) && (k != 7)) {
                        Cell_type[k][y] = 2;
                        k += 1;
                    }
                }
            }
            if (x != 0) { // вниз
                int k = x - 1;
                while ((Cell_type[k][y] == 1) && (k != 0)) {
                    k -= 1;
                }
                if (Cell_type[k][y] == 2) {
                    k = x - 1;
                    while ((Cell_type[k][y] != 2) && (k != 0)) {
                        Cell_type[k][y] = 2;
                        k -= 1;
                    }
                }
            }
            if (y != 0) { // вправо
                int j = y - 1;
                while ((Cell_type[x][j] == 1) && (j != 0)) {
                    j -= 1;
                }
                if (Cell_type[x][j] == 2) {
                    j = y - 1;
                    while ((Cell_type[x][j] != 2) && (j != 0)) {
                        Cell_type[x][j] = 2;
                        j -= 1;
                    }
                }
            }
            if (y != 7) { // влево
                int j = y + 1;
                while ((Cell_type[x][j] == 1) && (j != 7)) {
                    j += 1;
                }
                if (Cell_type[x][j] == 2) {
                    j = y + 1;
                    while ((Cell_type[x][j] == 1) && (j != 7)) {
                        Cell_type[x][j] = 2;
                        j += 1;
                    }
                }
            }
            if (y != 0 && x != 0) {
                int k = y - 1;
                int t = x - 1;
                while ((Cell_type[t][k] == 1) && (k != 0) && (t != 0)) {
                    k -= 1;
                    t -= 1;
                }
                if (Cell_type[t][k] == 2) {
                    k = y - 1;
                    t = x - 1;
                    while ((Cell_type[t][k] != 2) && (k != 0) && (t != 0)) {
                        Cell_type[t][k] = 2;
                        k -= 1;
                        t -= 1;
                    }
                }
            }
            if (y != 7 && x != 7) {
                int k = y + 1;
                int t = x + 1;
                while ((Cell_type[t][k] == 1) && (k != 7) && (t != 7)) {
                    k += 1;
                    t += 1;
                }
                if (Cell_type[t][k] == 2) {
                    k = y + 1;
                    t = x + 1;
                    while ((Cell_type[t][k] != 2) && (k != 7) && (t != 7)) {
                        Cell_type[t][k] = 2;
                        k += 1;
                        t += 1;
                    }

                }
            }
            if (y != 7 && x != 0) {
                int k = y + 1;
                int t = x - 1;
                while ((Cell_type[t][k] == 1) && (k != 7) && (t != 0)) {
                    k += 1;
                    t -= 1;
                }
                if (Cell_type[t][k] == 2) {
                    k = y + 1;
                    t = x - 1;
                    while ((Cell_type[t][k] != 2) && (k != 7) && (t != 0)) {
                        Cell_type[t][k] = 2;
                        k += 1;
                        t -= 1;
                    }

                }
            }
            if (y != 0 && x != 7) {
                int k = y - 1;
                int t = x + 1;
                while ((Cell_type[t][k] == 1) && (k != 0) && (t != 7)) {
                    k -= 1;
                    t += 1;
                }
                if (Cell_type[t][k] == 2) {
                    k = y - 1;
                    t = x + 1;
                    while ((Cell_type[t][k] != 2) && (k != 0) && (t != 7)) {
                        Cell_type[t][k] = 2;
                        k -= 1;
                        t += 1;
                    }
                }
            }
        } else {
            if (x != 7) { // вверх
                int k = x + 1;
                while ((Cell_type[k][y] == 2) && (k != 7)) {
                    k += 1;
                }
                if (Cell_type[k][y] == 1) {
                    k = x + 1;
                    while ((Cell_type[k][y] != 1) && (k != 7)) {
                        Cell_type[k][y] = 1;
                        k += 1;
                    }
                }
            }
            if (x != 0) { // вниз
                int k = x - 1;
                while ((Cell_type[k][y] == 2) && (k != 0)) {
                    k -= 1;
                }
                if (Cell_type[k][y] == 1) {
                    k = x - 1;
                    while ((Cell_type[k][y] != 1) && (k != 0)) {
                        Cell_type[k][y] = 1;
                        k -= 1;
                    }
                }
            }
            if (y != 0) { // вправо
                int j = y - 1;
                while ((Cell_type[x][j] == 2) && (j != 0)) {
                    j -= 1;
                }
                if (Cell_type[x][j] == 1) {
                    j = y - 1;
                    while ((Cell_type[x][j] != 1) && (j != 0)) {
                        Cell_type[x][j] = 1;
                        j -= 1;
                    }
                }
            }
            if (y != 7) { // влево
                int j = y + 1;
                while ((Cell_type[x][j] == 2) && (j != 7)) {
                    j += 1;
                }
                if (Cell_type[x][j] == 1) {
                    j = y + 1;
                    while ((Cell_type[x][j] != 1) && (j != 7)) {
                        Cell_type[x][j] = 1;
                        j += 1;
                    }
                }
            }
            if (y != 0 && x != 0) {
                int k = y - 1;
                int t = x - 1;
                while ((Cell_type[t][k] == 2) && (k != 0) && (t != 0)) {
                    k -= 1;
                    t -= 1;
                }
                if (Cell_type[t][k] == 1) {
                    k = y - 1;
                    t = x - 1;
                    while ((Cell_type[t][k] != 1) && (k != 0) && (t != 0)) {
                        Cell_type[t][k] = 1;
                        k -= 1;
                        t -= 1;
                    }
                }
            }
            if (y != 7 && x != 7) {
                int k = y + 1;
                int t = x + 1;
                while ((Cell_type[t][k] == 2) && (k != 7) && (t != 7)) {
                    k += 1;
                    t += 1;
                }
                if (Cell_type[t][k] == 1) {
                    k = y + 1;
                    t = x + 1;
                    while ((Cell_type[t][k] != 1) && (k != 7) && (t != 7)) {
                        Cell_type[t][k] = 1;
                        k += 1;
                        t += 1;
                    }

                }
            }
            if (y != 7 && x != 0) {
                int k = y + 1;
                int t = x - 1;
                while ((Cell_type[t][k] == 2) && (k != 7) && (t != 0)) {
                    k += 1;
                    t -= 1;
                }
                if (Cell_type[t][k] == 1) {
                    k = y + 1;
                    t = x - 1;
                    while ((Cell_type[t][k] != 1) && (k != 7) && (t != 0)) {
                        Cell_type[t][k] = 1;
                        k += 1;
                        t -= 1;
                    }

                }
            }
            if (y != 0 && x != 7) {
                int k = y - 1;
                int t = x + 1;
                while ((Cell_type[t][k] == 2) && (k != 0) && (t != 7)) {
                    k -= 1;
                    t += 1;
                }
                if (Cell_type[t][k] == 1) {
                    k = y - 1;
                    t = x + 1;
                    while ((Cell_type[t][k] != 1) && (k != 0) && (t != 7)) {
                        Cell_type[t][k] = 1;
                        k -= 1;
                        t += 1;
                    }
                }
            }
        }
    }

    public void variants() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (duplicate[x][y] == 4) {
                    System.out.printf("Варианты ходов: %d %d\n", x + 1, y + 1);
                }
            }
        }
    }

    public int[] best(int player_number) {
        int[] ret = new int[2];
        int s_i;
        double ss, R_max = 0, maxx;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (Cell_type[x][y] == 4) {
                    if ((x == 7 && y == 0) || (x == 7 && y == 7) || (x == 0 && y == 0) || (x == 0 && y == 7)) {
                        ss = 0.8;
                    } else if (x == 7 || y == 0 || y == 7 || x == 0) {
                        ss = 0.4;
                    } else {
                        ss = 0;
                    }
                    //System.out.printf("Варианты ходов: %d %d\n",x, y);
                    s_i = 0;
                    maxx = 0;
                    if (player_number == 1) { // O
                        if (x != 7) { // вниз
                            int k = x + 1;
                            while ((Cell_type[k][y] == 1) && (k != 7)) {
                                //System.out.print("Vn");
                                k += 1;
                            }
                            if (Cell_type[k][y] == 2) {
                                k = x + 1;
                                while ((Cell_type[k][y] != 2) && (k != 7)) {
                                    //System.out.print("Vn");
                                    if (y == 0 || y == 7) {
                                        s_i += 2;
                                    } else {
                                        s_i += 1;
                                    }
                                    k += 1;
                                }
                            }
                        }
                        if (x != 0) { // вверх
                            int k = x - 1;
                            while ((Cell_type[k][y] == 1) && (k != 0)) {
                                //System.out.print("VV");
                                k -= 1;
                            }
                            if (Cell_type[k][y] == 2) {
                                k = x - 1;
                                while ((Cell_type[k][y] != 2) && (k != 0)) {
                                    //System.out.print("VV");
                                    if (y == 0 || y == 7) {
                                        s_i += 2;
                                    } else {
                                        s_i += 1;
                                    }
                                    k -= 1;
                                }
                            }
                        }
                        if (y != 0) { // влево
                            int j = y - 1;
                            while ((Cell_type[x][j] == 1) && (j != 0)) {
                                //System.out.print("VL");
                                j -= 1;
                            }
                            if (Cell_type[x][j] == 2) {
                                j = y - 1;
                                while ((Cell_type[x][j] != 2) && (j != 0)) {
                                    //System.out.print("VL");
                                    if (x == 0 || x == 7) {
                                        s_i += 2;
                                    } else {
                                        s_i += 1;
                                    }
                                    j -= 1;
                                }
                            }
                        }
                        if (y != 7) { // влево
                            int j = y + 1;
                            while ((Cell_type[x][j] == 1) && (j != 7)) {
                                //System.out.print("VP");
                                j += 1;
                            }
                            if (Cell_type[x][j] == 2) {
                                j = y + 1;
                                while ((Cell_type[x][j] != 2) && (j != 7)) {
                                    //System.out.print("VP");
                                    if (x == 0 || x == 7) {
                                        s_i += 2;
                                    } else {
                                        s_i += 1;
                                    }
                                    j += 1;
                                }
                            }
                        }
                        if (y != 0 && x != 0) {
                            int k = y - 1;
                            int t = x - 1;
                            while ((Cell_type[t][k] == 1) && (k != 0) && (t != 0)) {
                                k -= 1;
                                t -= 1;
                            }
                            if (Cell_type[t][k] == 2) {
                                k = y - 1;
                                t = x - 1;
                                while ((Cell_type[t][k] != 2) && (k != 0) && (t != 0)) {
                                    s_i += 1;
                                    k -= 1;
                                    t -= 1;
                                }
                            }
                        }
                        if (y != 7 && x != 7) {
                            int k = y + 1;
                            int t = x + 1;
                            while ((Cell_type[t][k] == 1) && (k != 7) && (t != 7)) {
                                k += 1;
                                t += 1;
                            }
                            if (Cell_type[t][k] == 2) {
                                k = y + 1;
                                t = x + 1;
                                while ((Cell_type[t][k] != 2) && (k != 7) && (t != 7)) {
                                    s_i += 1;
                                    k += 1;
                                    t += 1;
                                }

                            }
                        }
                        if (y != 7 && x != 0) {
                            int k = y + 1;
                            int t = x - 1;
                            while ((Cell_type[t][k] == 1) && (k != 7) && (t != 0)) {
                                k += 1;
                                t -= 1;
                            }
                            if (Cell_type[t][k] == 2) {
                                k = y + 1;
                                t = x - 1;
                                while ((Cell_type[t][k] != 2) && (k != 7) && (t != 0)) {
                                    s_i += 1;
                                    k += 1;
                                    t -= 1;
                                }

                            }
                        }
                        if (y != 0 && x != 7) {
                            int k = y - 1;
                            int t = x + 1;
                            while ((Cell_type[t][k] == 1) && (k != 0) && (t != 7)) {
                                k -= 1;
                                t += 1;
                            }
                            if (Cell_type[t][k] == 2) {
                                k = y - 1;
                                t = x + 1;
                                while ((Cell_type[t][k] != 2) && (k != 0) && (t != 7)) {
                                    s_i += 1;
                                    k -= 1;
                                    t += 1;
                                }
                            }
                        }
                        maxx = s_i + ss;
                        if (maxx > R_max) {
                            ret[0] = x;
                            ret[1] = y;
                            R_max = maxx;
                        }
                    } else {
                        if (x != 7) { // вверх
                            int k = x + 1;
                            while ((Cell_type[k][y] == 2) && (k != 7)) {
                                k += 1;
                            }
                            if (Cell_type[k][y] == 1) {
                                k = x + 1;
                                while ((Cell_type[k][y] != 1) && (k != 7)) {
                                    if (y == 0 || y == 7) {
                                        s_i += 2;
                                    } else {
                                        s_i += 1;
                                    }
                                    k += 1;
                                }
                            }
                        }
                        if (x != 0) { // вниз
                            int k = x - 1;
                            while ((Cell_type[k][y] == 2) && (k != 0)) {
                                k -= 1;
                            }
                            if (Cell_type[k][y] == 1) {
                                k = x - 1;
                                while ((Cell_type[k][y] != 1) && (k != 0)) {
                                    if (y == 0 || y == 7) {
                                        s_i += 2;
                                    } else {
                                        s_i += 1;
                                    }
                                    k -= 1;
                                }
                            }
                        }
                        if (y != 0) { // вправо
                            int j = y - 1;
                            while ((Cell_type[x][j] == 2) && (j != 0)) {
                                j -= 1;
                            }
                            if (Cell_type[x][j] == 1) {
                                j = y - 1;
                                while ((Cell_type[x][j] != 1) && (j != 0)) {
                                    if (x == 0 || x == 7) {
                                        s_i += 2;
                                    } else {
                                        s_i += 1;
                                    }
                                    j -= 1;
                                }
                            }
                        }
                        if (y != 7) { // влево
                            int j = y + 1;
                            while ((Cell_type[x][j] == 2) && (j != 7)) {
                                j += 1;
                            }
                            if (Cell_type[x][j] == 1) {
                                j = y + 1;
                                while ((Cell_type[x][j] != 1) && (j != 7)) {
                                    if (x == 0 || x == 7) {
                                        s_i += 2;
                                    } else {
                                        s_i += 1;
                                    }
                                    j += 1;
                                }
                            }
                        }
                        if (y != 0 && x != 0) {
                            int k = y - 1;
                            int t = x - 1;
                            while ((Cell_type[t][k] == 2) && (k != 0) && (t != 0)) {
                                k -= 1;
                                t -= 1;
                            }
                            if (Cell_type[t][k] == 1) {
                                k = y - 1;
                                t = x - 1;
                                while ((Cell_type[t][k] != 1) && (k != 0) && (t != 0)) {
                                    s_i += 1;
                                    k -= 1;
                                    t -= 1;
                                }
                            }
                        }
                        if (y != 7 && x != 7) {
                            int k = y + 1;
                            int t = x + 1;
                            while ((Cell_type[t][k] == 2) && (k != 7) && (t != 7)) {
                                k += 1;
                                t += 1;
                            }
                            if (Cell_type[t][k] == 1) {
                                k = y + 1;
                                t = x + 1;
                                while ((Cell_type[t][k] != 1) && (k != 7) && (t != 7)) {
                                    s_i += 1;
                                    k += 1;
                                    t += 1;
                                }

                            }
                        }
                        if (y != 7 && x != 0) {
                            int k = y + 1;
                            int t = x - 1;
                            while ((Cell_type[t][k] == 2) && (k != 7) && (t != 0)) {
                                k += 1;
                                t -= 1;
                            }
                            if (Cell_type[t][k] == 1) {
                                k = y + 1;
                                t = x - 1;
                                while ((Cell_type[t][k] != 1) && (k != 7) && (t != 0)) {
                                    s_i += 1;
                                    k += 1;
                                    t -= 1;
                                }

                            }
                        }
                        if (y != 0 && x != 7) {
                            int k = y - 1;
                            int t = x + 1;
                            while ((Cell_type[t][k] == 2) && (k != 0) && (t != 7)) {
                                k -= 1;
                                t += 1;
                            }
                            if (Cell_type[t][k] == 1) {
                                k = y - 1;
                                t = x + 1;
                                while ((Cell_type[t][k] != 1) && (k != 0) && (t != 7)) {
                                    s_i += 1;
                                    k -= 1;
                                    t += 1;
                                }
                            }
                        }
                        maxx = s_i + ss;
                        if (maxx > R_max) {
                            ret[0] = x;
                            ret[1] = y;
                            R_max = maxx;
                        }
                    }
                }
            }
        }
        //System.out.println(R_max);
        return ret;
    }
}