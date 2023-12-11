import java.util.*;
import java.io.*;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < K; i++) {
            int length = Integer.parseInt(br.readLine());
            arr.add(length);
            min = Math.min(length, min);
        }

        Long left = 1L;
        Long right = Long.valueOf(Integer.MAX_VALUE);

        while (left <= right) {
            Long middle = (left + right) / 2;
            Long sum = 0L;
            for (Integer integer : arr) {
                sum += integer / middle;
            }
            if (sum < N) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        System.out.println(right);
    }


}
