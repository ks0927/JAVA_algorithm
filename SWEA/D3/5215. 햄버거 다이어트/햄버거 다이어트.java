import java.io.*;
import java.util.*;

public class Solution {

    static int scoreMax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[] scores = new int[N];
            int[] cals = new int[N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int cal = Integer.parseInt(st.nextToken());
                scores[j] = score;
                cals[j] = cal;
            }
            scoreMax = 0;
            backTracking(scores, cals, L, 0, 0, 0);

            sb.append("#").append(i + 1).append(" ").append(scoreMax).append("\n");
        }
        System.out.print(sb);

    }

    static void backTracking(int[] scores, int[] cals, int L, int start, int scoreSum, int calSum) {

        if (calSum <= L) {
            scoreMax = Math.max(scoreSum, scoreMax);
        } else {
            return;
        }

        for (int i = start; i < scores.length; i++) {
            scoreSum += scores[i];
            calSum += cals[i];

            backTracking(scores, cals, L, i + 1, scoreSum, calSum);

            scoreSum -= scores[i];
            calSum -= cals[i];
        }
    }


}
