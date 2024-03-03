import java.io.*;
import java.util.*;

public class Main {

    //왼,오른,위,아래
    static int[] directionY = {0, 0, -1, +1};
    static int[] directionX = {-1, +1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] answer = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        Queue<Position> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int parseInt = Integer.parseInt(st.nextToken());
                map[i][j] = parseInt;
                if (parseInt == 2) {
                    queue.add(new Position(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position poll = queue.poll();
                int x = poll.x;
                int y = poll.y;
                int day = poll.day;

                for (int j = 0; j < 4; j++) {
                    int nextX = x + directionX[j];
                    int nextY = y + directionY[j];

                    if (0 <= nextY && nextY < N && 0 <= nextX && nextX < M) {
                        if (map[nextY][nextX] != 0 && !visited[nextY][nextX]) {
                            queue.add(new Position(nextY, nextX, day + 1));
                            visited[nextY][nextX] = true;
                            answer[nextY][nextX] = day + 1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int check = map[i][j];
                //못가는곳
                if (check == 1 && answer[i][j] == 0) {
                    answer[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(answer[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static class Position {
        int y;
        int x;
        int day;

        public Position(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }


}

