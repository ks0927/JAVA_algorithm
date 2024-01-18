import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String,Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String readLine = br.readLine();
            map.put(readLine,map.getOrDefault(readLine,0)+1);
        }

        for (int i = 0; i < M; i++) {
            String readLine = br.readLine();
            map.put(readLine,map.getOrDefault(readLine,0)+1);
        }

        int count = 0;

        for (Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if(stringIntegerEntry.getValue().equals(2)){
                count++;
                sb.append(stringIntegerEntry.getKey()).append("\n");
            }
        }
        System.out.println(count);
        System.out.println(sb);

    }

}
