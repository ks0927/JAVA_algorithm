package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj2212 {


    static int N;
    static int K;
    static int[] sensor;
    static Integer[] diffList;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        sensor = new int[N];
        diffList = new Integer[N-1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            sensor[i] = height;
        }

        // 센서를 오름차순으로 정렬
        Arrays.sort(sensor);

        //센서 위치 차이 값들을 담는다.
        for (int i = 0; i < sensor.length-1; i++) {
            int diff = sensor[i + 1] - sensor[i];
            diffList[i] = diff;
        }

        // 센서간 차이를 내림차순으로 정렬
        Arrays.sort(diffList,Collections.reverseOrder());

        int result = 0;

        // 센서간 차이가 큰곳을 K-1개 만큼 지운다.
        // 즉 더이상 그쪽으로 이어지지 않은 다른 팀을 구성한다고 생각하면될것같다.
        for (int i = 0; i < diffList.length; i++) {
            if(i < K-1)
                continue;
            result += diffList[i];
        }

        System.out.println(result);
    }
}
