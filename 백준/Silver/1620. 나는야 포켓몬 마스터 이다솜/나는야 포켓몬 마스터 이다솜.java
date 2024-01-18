import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String,Integer> map = new HashMap<>();
        String[] strings = new String[N+1];
        for (int i = 1; i <= N; i++) {
            String readLine = br.readLine();
            strings[i] = readLine;
            map.put(readLine,i);
        }

        for (int i = 0; i < M; i++) {
            String readLine = br.readLine();
            if(isDigit(readLine)){
                sb.append(strings[Integer.parseInt(readLine)]).append("\n");
                continue;
            }
            sb.append(map.get(readLine)).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isDigit(String readLine) {
        try {
            Integer.parseInt(readLine);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }


}
