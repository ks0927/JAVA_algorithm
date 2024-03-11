import java.io.*;
import java.util.*;

public class Main {
    // 방향용 테이블, 왼쪽, 오른쪽, 뒤, 앞, 아래, 위
    static int[] directionX = {-1, 1, 0, 0, 0, 0};
    static int[] directionY = {0, 0, -1, 1, 0, 0};
    static int[] directionZ = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] chests = new int[H][N][M];
        int[][][] bfs = new int[H][N][M];
        boolean[][][] visited = new boolean[H][N][M];
        Queue<Position> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int value = Integer.parseInt(st.nextToken());
                    chests[i][j][k] = value;

                    //토마토가 있는곳 큐에 추가
                    if (value == 1) {
                        visited[i][j][k] = true;
                        queue.add(new Position(i, j, k, 0));
                    }
                }
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position poll = queue.poll();

                int x = poll.x;
                int y = poll.y;
                int z = poll.height;

                for (int j = 0; j < 6; j++) {
                    int nextX = x + directionX[j];
                    int nextY = y + directionY[j];
                    int nextZ = z + directionZ[j];

                    if (0 <= nextY && nextY < N && 0 <= nextX && nextX < M && 0 <= nextZ && nextZ < H) {

                        if(chests[nextZ][nextY][nextX] != -1 && !visited[nextZ][nextY][nextX]) {
                            queue.add(new Position(nextZ,nextY,nextX, poll.day + 1));
                            visited[nextZ][nextY][nextX] = true;
                            bfs[nextZ][nextY][nextX] = poll.day + 1;
                            result = Math.max(result, poll.day + 1);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int check = bfs[i][j][k];

                    //bfs에서 간적없고, 토마토 상자에서는 안익었다면 모두 익지 못하는 상황이 발생한것.
                    if (check == 0 && chests[i][j][k] == 0) {
                        result = -1;
                        System.out.println(result);
                        return;
                    }
                }
            }
        }
        
        System.out.println(result);

    }

    static class Position {
        int height;
        int y;
        int x;
        int day;

        public Position(int height, int y, int x, int day) {
            this.height = height;
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
}

