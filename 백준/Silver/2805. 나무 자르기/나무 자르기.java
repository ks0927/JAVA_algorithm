import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];

        int min = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int length = Integer.parseInt(st.nextToken());

            tree[i] = length;
            if (length > max) {
                max = length;
            }
        }

        // 이분 탐색
        // upperbound로 구한뒤 -1 하는게 정답!
        // 하한선이 min , 상한선이 max

        while (min < max) {

            int mid = (min + max) / 2;
            long sum = 0;

            for (int height : tree) {
                if (height - mid > 0) {
                    sum += (height - mid);
                }
            }

            //이분 탐색 실제 부분

            // 자른 나무를 합한 값이 필요한 M개 보다 적다는 것은 너무 위에서 잘랐다는 것이다
            // 즉 상한을 내려서 아랫부분을 봐보자
            if (sum < M) {
                max = mid;
            }
            // 자른 나무를 합한 값이 필요한 M개 보다 크거나 같다는것은 너무 아래에서 잘랐다는 것이다
            // 즉 하한을 올려서 윗부분을 봐보자
            else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);

    }


}

