import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            if (i % 2 == 1) {
                sb.append(" ");
            }

            for (int j = 0; j < N; j++) {
                sb.append("* ");
            }
            sb.deleteCharAt(sb.length() - 1); //마지막 " "공백 하나 지우기용 

            sb.append("\n");
        }

        System.out.print(sb);
    }


}
