import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, result = 0;
        TreeMap<Integer, Integer> countMap = new TreeMap<>();

        for (int right = 0; right < N; right++) {
            countMap.put(arr[right], countMap.getOrDefault(arr[right], 0) + 1);

            while (countMap.lastKey() - countMap.firstKey() > 2) {
                if (countMap.put(arr[left], countMap.get(arr[left]) - 1) == 1) {
                    countMap.remove(arr[left]);
                }
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        System.out.println(result);
    }
}
