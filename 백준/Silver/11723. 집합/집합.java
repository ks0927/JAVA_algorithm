import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] map = new int[21];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    map[j] = 1;
                }
                continue;
            }

            if(command.equals("empty")) {
                for (int j = 1; j <= 20; j++) {
                    map[j] = 0;
                }
                continue;
            }

            int X = Integer.parseInt(st.nextToken());

            if(command.equals("add")) {
                map[X] = 1;
            }

            if(command.equals("remove")) {
                map[X] = 0;
            }

            if(command.equals("check")) {
                if(map[X] == 1) {
                    sb.append("1").append("\n");
                }
                else {
                    sb.append("0").append("\n");
                }
            }

            if(command.equals("toggle")) {
                if(map[X] == 1) {
                    map[X] = 0;
                }
                else {
                    map[X] = 1;
                }
            }
        }

        System.out.println(sb);

    }


}

