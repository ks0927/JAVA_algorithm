import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static int[][] visited;
    static List<Integer> building;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 위 아래 왼쪽 오른쪽

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new int[N][N];
        building = new ArrayList<>();

        //초기화
        for (int i = 0; i < N; i++) {
            String readLine = br.readLine();
            for (int j = 0; j < N; j++) {
                int value = Character.getNumericValue(readLine.charAt(j));
                map[i][j] = value;
            }
        }

        int dan = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    bfs(i, j, N , dan);
                    dan++;
                }
            }
        }

        sb.append(dan-1).append("\n");
        Collections.sort(building);

        for (Integer integer : building) {
            sb.append(integer).append("\n");

        }

        System.out.println(sb);
    }

    private static void bfs(int i, int j, int N , int dan) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        visited[i][j] = dan;

        int people = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Point poll = queue.poll();
                for (int l = 0; l < 4; l++) { //위 아래 왼쪽 오른쪽 탐색
                    int nexti = poll.i + direction[l][0];
                    int nextj = poll.j + direction[l][1];

                    //탐색할 위치의 범위가 올바르고
                    if (0 <= nexti && nexti < N && 0 <= nextj && nextj < N) {

                        // 맵에서 1이며 아직 탐색한적 없는 곳이면
                        if(map[nexti][nextj] == 1 && visited[nexti][nextj] == 0) {
                            //탐색 배열 초기화해주고
                            visited[nexti][nextj] = dan;
                            //큐에 넣어서 그 위치부터 다시 탐색
                            queue.add(new Point(nexti,nextj));
                        }
                    }
                }
            }
            people += queue.size();
        }

        building.add(people);
    }

    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
