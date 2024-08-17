import java.io.*;
import java.util.*;

public class Main {
    enum pipeType {G, S, D}

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int parseInt = Integer.parseInt(st.nextToken());
                map[i][j] = parseInt;
            }
        }

        if (map[N - 1][N - 1] == 1) {
            System.out.println(result);
            return;
        }

        Queue<Pipe> queue = new LinkedList<>();
        queue.add(new Pipe(0, 1, pipeType.G));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Pipe poll = queue.poll();
                int row = poll.row;
                int col = poll.col;

                if (row == N - 1 && col == N - 1) {
                    result++;
                    continue;
                }

                if (poll.pipeType.equals(pipeType.G)) {

                    int nextRow = row;
                    int nextCol = col + 1;

                    if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N && map[nextRow][nextCol] != 1) {
                        queue.add(new Pipe(nextRow, nextCol, pipeType.G));
                    }

                    nextRow = row + 1;
                    nextCol = col + 1;

                    if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N && map[nextRow][nextCol] != 1 && map[nextRow - 1][nextCol] != 1 && map[nextRow][nextCol - 1] != 1) {
                        queue.add(new Pipe(nextRow, nextCol, pipeType.D));
                    }
                }

                if (poll.pipeType.equals(pipeType.S)) {

                    int nextRow = row + 1;
                    int nextCol = col;

                    if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N && map[nextRow][nextCol] != 1) {
                        queue.add(new Pipe(nextRow, nextCol, pipeType.S));
                    }

                    nextRow = row + 1;
                    nextCol = col + 1;

                    if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N && map[nextRow][nextCol] != 1 && map[nextRow - 1][nextCol] != 1 && map[nextRow][nextCol - 1] != 1) {
                        queue.add(new Pipe(nextRow, nextCol, pipeType.D));
                    }
                }

                if (poll.pipeType.equals(pipeType.D)) {

                    int nextRow = row;
                    int nextCol = col + 1;

                    if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N && map[nextRow][nextCol] != 1) {
                        queue.add(new Pipe(nextRow, nextCol, pipeType.G));
                    }

                    nextRow = row + 1;
                    nextCol = col;

                    if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N && map[nextRow][nextCol] != 1) {
                        queue.add(new Pipe(nextRow, nextCol, pipeType.S));
                    }

                    nextRow = row + 1;
                    nextCol = col + 1;

                    if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N && map[nextRow][nextCol] != 1 && map[nextRow - 1][nextCol] != 1 && map[nextRow][nextCol - 1] != 1) {
                        queue.add(new Pipe(nextRow, nextCol, pipeType.D));
                    }
                }

            }
        }

        System.out.print(result);

    }

    static class Pipe {
        int row;
        int col;

        pipeType pipeType;

        public Pipe(int row, int col, pipeType pipeType) {
            this.row = row;
            this.col = col;
            this.pipeType = pipeType;
        }
    }
}
