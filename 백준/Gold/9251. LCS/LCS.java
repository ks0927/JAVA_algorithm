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

        System.out.println(LCS(s1.length() - 1, s2.length() - 1));


/*      만약 길이가 아니라 직접 LCS를 구해야한다면?
        https://lotuslee.tistory.com/39 해당 블로그 참조

        StringBuilder sb = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;

        while (i >= 0 && j >= 0) {
            if (i - 1 >= 0 && map[i][j] == map[i - 1][j]) {
                i--;
                continue;
            }

            if (j - 1 >= 0 && map[i][j] == map[i][j - 1]) {
                j--;
                continue;
            }

            if (i - 1 >= 0 && j - 1 >= 0 && map[i][j] == map[i - 1][j - 1] + 1) {
                sb.append(s1.charAt(i));
                i--;
                j--;
                continue;
            }

            if(i - 1 <= 0 || j - 1 <= 0) {
                if(map[i][j] == 1 && s1.charAt(i) == s2.charAt(j)) {
                    sb.append(s1.charAt(i));
                    i--;
                    j--;
                }
            }
        }

        System.out.println(sb.reverse());*/
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
