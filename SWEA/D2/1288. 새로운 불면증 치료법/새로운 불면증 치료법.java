import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int a = (1 << 10) - 1;
            int b = 0;
            int k = 1;
            int answer = -1;

            while (true) {
                int tempN = N * k;
                String str = String.valueOf(tempN);

                char[] charArray = str.toCharArray();
                for (char c : charArray) {
                    int value = c - '0';

                    b |= (1 << value); // b와 비트마스킹 연산
                }

                if (b == a) {  // 비스마스킹을 하면 total을 확인할때 속도가 매우 빠르다.
                    answer = N * k;
                    break;
                }

                k++;
            }

            sb.append("#").append(i+1).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }
}
