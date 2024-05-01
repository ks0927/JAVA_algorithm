import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] height = new int[100];
            for (int j = 0; j < 100; j++) {
                int parseInt = Integer.parseInt(st.nextToken());
                height[j] = parseInt;
            }

            int result = 0;
            for (int j = 0; j < N; j++) {
                Arrays.sort(height);
                if (height[99] == height[0]) {
                    break;
                }
                result = height[99] - height[0];
                height[99]--;
                height[0]++;
            }
            Arrays.sort(height);
            result = height[99] - height[0];

            sb.append("#").append(i + 1).append(" ").append(result).append("\n");
        }
        System.out.print(sb);

    }


}
