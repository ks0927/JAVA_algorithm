import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] score = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            double target = 0;

            List<Double> students = new ArrayList<>();

            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                int Mid = Integer.parseInt(st.nextToken());
                int Final = Integer.parseInt(st.nextToken());
                int Report = Integer.parseInt(st.nextToken());
                double sum = Mid * 0.35 + Final * 0.45 + Report * 0.2;

                students.add(sum);

                if (j == K) {
                    target = sum;
                }
            }

            Collections.sort(students, Collections.reverseOrder());

            String result = "";
            for (int j = 0; j < students.size(); j++) {
                if (students.get(j) == target) {
                    int part = N / 10;
                    int temp = j + 1;

                    int flag = -1;
                    while (temp > 0) {
                        temp -= part;
                        flag++;
                    }

                    result = score[flag];
                }
            }

            sb.append("#").append(i + 1).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }


}
