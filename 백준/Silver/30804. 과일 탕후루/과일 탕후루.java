import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int max;
    static Map<Integer, Integer> integerMap;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            map[i] = value;
        }

        integerMap = new HashMap<>();
        max = 0;
        solution(map);

        System.out.println(max);

    }

    private static void solution(int[] arr) {
        int front = 0;

        for (int back = 0; back < N; back++) {
            integerMap.put(arr[back], integerMap.getOrDefault(arr[back], 0) + 1);

            while (integerMap.size() > 2) {
                integerMap.put(arr[front], integerMap.get(arr[front]) - 1);

                if(integerMap.get(arr[front]) == 0)
                    integerMap.remove(arr[front]);

                front++;
            }

            max = Math.max(max, back - front + 1);
        }

    }
}
