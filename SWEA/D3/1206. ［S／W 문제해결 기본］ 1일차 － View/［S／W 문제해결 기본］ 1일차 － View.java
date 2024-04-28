import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());

            //초기화
            int[] building = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int floor = Integer.parseInt(st.nextToken());
                building[j] = floor;
            }

            int result = checkBuilding(N, building);

            sb.append("#").append(i + 1).append(" ").append(result).append("\n");
        }
        System.out.print(sb);

    }

    private static int checkBuilding(int N, int[] building) {
        int result = 0;

        for (int j = 2; j < N - 2; j++) {
            int nearBiggest = 0;

            for (int k = j - 1; k >= j - 2; k--) {
                if (nearBiggest < building[k]) {
                    nearBiggest = building[k];
                }
            }

            for (int k = j + 1; k <= j + 2; k++) {
                if (nearBiggest < building[k]) {
                    nearBiggest = building[k];
                }
            }

            if(building[j] - nearBiggest > 0) {
                result += (building[j] - nearBiggest);
            }
        }

        return result;
    }


}
