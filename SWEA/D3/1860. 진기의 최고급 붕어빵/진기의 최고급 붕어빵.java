import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int max = 0;
            int[] people = new int[11112];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int parseInt = Integer.parseInt(st.nextToken());
                people[parseInt] += 1;

                if (parseInt > max)
                    max = parseInt;
            }

            String result = getResult(max, M, K, people);

            sb.append("#").append(i + 1).append(" ").append(result).append("\n");
        }

        System.out.print(sb);

    }

    static String getResult(int max, int M, int K, int[] people) {
        int bung = 0;
        int flag = 0;
        for (int j = 0; j <= max; j++) {
            if (j != 0) {
                flag++;
            }

            if (flag == M) {
                bung += K;
                flag = 0;
            }

            if (people[j] != 0) {
                bung -= people[j];
            }

            if (bung < 0) {
                return "Impossible";
            }
        }
        return "Possible";
    }


}
