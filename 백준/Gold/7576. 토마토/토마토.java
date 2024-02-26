import java.io.*;
import java.util.*;

public class Main {

    //왼,오른,위,아래
    static int[] directionY = {0, 0, -1, +1};
    static int[] directionX = {-1, +1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] chest = new int[N][M];
        int[][] answer = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        Queue<Position> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int parseInt = Integer.parseInt(st.nextToken());
                chest[i][j] = parseInt;
                if (parseInt == 1) {
                    queue.add(new Position(i, j, 1));
                    visited[i][j] =true;
                }
            }
        }

        int level = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position poll = queue.poll();
                int x = poll.x;
                int y = poll.y;

                for (int j = 0; j < 4; j++) {
                    int nextX = x + directionX[j];
                    int nextY = y + directionY[j];

                    if(0<=nextY && nextY< N && 0<=nextX && nextX< M ){
                        if(chest[nextY][nextX] != -1  && !visited[nextY][nextX]) {
                            queue.add(new Position(nextY,nextX,level + 1));
                            visited[nextY][nextX] = true;
                            answer[nextY][nextX] = level + 1;
                            result = Math.max(result,level+1);
                        }
                    }
                }
            }
            level++;
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(answer[i][j]+" ");
//            }
//            System.out.println();
//        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int check =chest[i][j];
                //실패
                if (check == 0 && answer[i][j] == 0) {
                    result = -1;
                }
            }
        }

        System.out.println(result);

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

