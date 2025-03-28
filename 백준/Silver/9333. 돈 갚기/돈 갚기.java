import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double R = Double.parseDouble(st.nextToken()); // 이자율
            double B = Double.parseDouble(st.nextToken()); // 빌린돈
            double M = Double.parseDouble(st.nextToken()); // 과외비

            int count = 1;
            while (count <= 1200) {
                // 이자 계산 (소수점 2자리 반올림)
                B = Math.round(B * (100 + R)) / 100.0;

                // 과외비로 갚기
                B -= M;

                // 대출금을 다 갚았으면 종료
                if (B <= 0) {
                    break;
                }

                count++;
            }

            sb.append(count > 1200 ? "impossible" : count).append("\n");
        }

        System.out.print(sb);
    }
}