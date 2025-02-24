import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String s = br.readLine();

            for (int j = 0; j < 9; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        sudoku(0, 0);
//        System.out.println(sb);

    }

    private static void sudoku(int r, int c) {

        if (r == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
            return;
        }

        if (c >= 9) {
            sudoku(r + 1, 0);
            return;
        }

        if (map[r][c] != 0) {
            sudoku(r, c + 1);
        }

        if (map[r][c] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (valid(r, c, i)) {
                    map[r][c] = i;
                    sudoku(r, c + 1);
                    map[r][c] = 0;
                }
            }
        }

    }

    private static boolean valid(int r, int c, int value) {

        //가로
        for (int i = 0; i < 9; i++) {
            if (map[r][i] == value)
                return false;
        }

        //세로
        for (int i = 0; i < 9; i++) {
            if (map[i][c] == value)
                return false;
        }

        // 3x3 사각형
        int nr = r / 3 * 3;
        int nc = c / 3 * 3;
        for (int i = nr; i < nr + 3; i++) {
            for (int j = nc; j < nc + 3; j++) {
                if (map[i][j] == value)
                    return false;
            }
        }

        return true;
    }


}
