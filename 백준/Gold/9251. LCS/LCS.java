import java.io.*;
import java.util.*;

public class Main {
    static String s1;
    static String s2;
    static Integer[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s1 = br.readLine();
        s2 = br.readLine();

        map = new Integer[s1.length()][s2.length()];

        System.out.print(LCS(s1.length() - 1, s2.length() - 1));
    }

    static int LCS(int row, int col) {

        if (row == -1 || col == -1) {
            return 0;
        }

        if (map[row][col] == null) {
            map[row][col] = 0;

            if (s1.charAt(row) == s2.charAt(col)) {
                map[row][col] = LCS(row - 1, col - 1) + 1;
            } else {
                map[row][col] = Math.max(LCS(row - 1, col), LCS(row, col - 1));
            }

        }


        return map[row][col];
    }
}
