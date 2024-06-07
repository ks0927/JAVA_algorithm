import java.util.*;
import java.io.*;

class Solution {
    static int[] pipe;
    static boolean[][] visited;
    static int[] directionX = {0, 0, -1, 1};
    static int[] directionY = {-1, 1, 0, 0};
    static int n;
    static int m;

    static public int solution(int[][] land) {

        n = land.length;
        m = land[0].length;

        //파이프를 뚫었을때 해당 라인의 석유량 저장용 리스트
        pipe = new int[m];

        visited = new boolean[n][m];
        //가로를 기준으로 세로로 조사함.
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                //석유가 있고 안간 땅이면 전부 조사.
                if (land[j][i] == 1 && !visited[j][i]) {
                    BFS(j, i, land);
                }
            }

        }

        int answer = 0;
        for (int oils : pipe) {
            if (oils > answer) {
                answer = oils;
            }
        }

        return answer;
    }

    static void BFS(int j, int i, int[][] land) {


        visited[j][i] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(j, i));
        int sum = 1;

        Set<Integer> pipes = new HashSet<>();
        pipes.add(i);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                Point poll = queue.poll();
                for (int l = 0; l < 4; l++) {
                    int nextY = poll.y + directionY[l];
                    int nextX = poll.x + directionX[l];

                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n)
                        continue;

                    if (!visited[nextY][nextX] && land[nextY][nextX] == 1) {
                        visited[nextY][nextX] = true;
                        queue.add(new Point(nextY, nextX));
                        pipes.add(nextX);
                        sum++;
                    }
                }
            }
        }

        //파이프를 뚫었을때 석유가 있는 곳에 미리 생산량을 더해둔다.
        for (Integer integer : pipes) {
            pipe[integer] += sum;
        }
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}