import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            int[][] map = new int[9][9];

            // 초기화
            for (int j = 0; j < 9; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 9; k++) {
                    int parseInt = Integer.parseInt(st.nextToken());
                    map[j][k] = parseInt;
                }
            }

            int result = validateGame(map);

            sb.append("#").append(i + 1).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }

    static int validateGame(int[][] map) {
        //가로 체크
        boolean[] check = new boolean[10];
        for (int i = 0; i < 9; i++) {
            check = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (check[map[i][j]]) {
                    return 0;
                }
                check[map[i][j]] = true;
            }
        }

        //세로 체크
        check = new boolean[10];
        for (int i = 0; i < 9; i++) {
            check = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (check[map[j][i]]) {
                    return 0;
                }
                check[map[j][i]] = true;
            }
        }

        // 9칸씩 서브그리드로 나누어서 체크
        for (int blockRow = 0; blockRow < 3; blockRow++) {
            for (int blockCol = 0; blockCol < 3; blockCol++) {
                check = new boolean[10];

                // 서브그리드 내부 체크
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        int realRow = blockRow * 3 + row;
                        int realCol = blockCol * 3 + col;

                        if(check[map[realRow][realCol]]) {
                            return 0;
                        }
                        check[map[realRow][realCol]] = true;
                    }
                }
            }
        }

        return 1;
    }


}
