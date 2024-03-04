import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    map[i][j] = 999999999;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = 1;
            map[end][start] = 1;
        }

        // 플로이드 와샬
        // 방문할 노선( i )
        // j인 사람이 k인 사람에게 가는 단계가 j부터 i를 거친뒤 i부터 k로 가는 단계를 합친거 보다 크면 갱신해준다.
        // 즉, i인 사람을 중간자로 쓰는 경우를 모두 탐색하여 초기화 하는 방식.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {

                    if (map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i] + map[i][k];
                    }

                }
            }
        }

        int answer = 0;
        int answerSum = 999999999;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if(i == j) {
                    continue;
                }
                sum += map[i][j];
            }
            if(answerSum > sum) {
                answer = i;
                answerSum = sum;
            }
        }

        System.out.println(answer);
    }


}

