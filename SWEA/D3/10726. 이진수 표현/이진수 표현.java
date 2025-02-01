import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String answer = "OFF";
            int checkBit = (1 << N) - 1;

            if( (checkBit & M) == checkBit ){
                answer = "ON";
            }

            sb.append("#").append(i + 1).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }
}
