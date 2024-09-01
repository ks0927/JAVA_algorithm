import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static ArrayList<Point> house;
    static ArrayList<Point> chicken;
    static boolean[] chosenChicken;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int parseInt = Integer.parseInt(st.nextToken());
                map[i][j] = parseInt;

                if (parseInt == 1) {
                    house.add(new Point(i, j));
                } else if (parseInt == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        chosenChicken = new boolean[chicken.size()];
        DFS(0, 0);
        System.out.println(answer);
    }

    static void DFS(int index, int chosen) {
        if (chosen == M) {
            int sum = 0; // 선택된 치킨집과 집의 '도시의 치킨거리'

            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE; //집의 '치킨거리'

                for (int j = 0; j < chicken.size(); j++) {
                    if (chosenChicken[j]) {
                        int distance = Math.abs(house.get(i).col - chicken.get(j).col) + Math.abs(house.get(i).row - chicken.get(j).row);
                        temp = Math.min(temp, distance);
                    }
                }

                sum += temp; //집의 '치킨거리'를 '도시의 치킨거리' 구하기위해 더함.
            }

            answer = Math.min(answer, sum); // '도시의 치킨거리' 최소값을 찾기 위해 '현재 도시의 치킨거리' 와 비교함.
            return;
        }

        //백트래킹
        for (int i = index; i < chicken.size(); i++) {
            chosenChicken[i] = true;
            DFS(i + 1, chosen + 1);
            chosenChicken[i] = false;
        }
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
