import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<Integer> map = new ArrayList<>();

        int i = 1;
        while(map.size() != N) {
            String toStr = String.valueOf(i);
            if (toStr.contains("666")) {
                map.add(i);
            }
            i++;
        }

        System.out.println(map.get(N - 1));
    }
}
