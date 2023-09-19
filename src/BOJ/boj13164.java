package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj13164 {

    static int N;
    static int K;
    static int[] heightList;
    static Integer[] diffList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        heightList = new int[N];
        diffList = new Integer[N-1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            heightList[i] = height;
        }

        //키 차이 값을 담는다.
        for (int i = 0; i < heightList.length-1; i++) {
            int diff = heightList[i + 1] - heightList[i];
            diffList[i] = diff;
        }

/*        for (int i : diffList) {
            System.out.println("i = " + i);
        }*/

        //키 차이값을 내림차순으로 정렬한다.
        Arrays.sort(diffList, Collections.reverseOrder());

        int result = 0;

        //K개의 팀을 위해 K-1개의 벽을 세운다.
        //내림차순으로 정렬된걸 돌기때문에 인덱스가 K-1보다 작은 값들은 큰값에 벽을세우는 작업이라 생각하자 (continue로 pass한다)
        for (int i = 0; i < diffList.length; i++) {
            if(i < K-1)
                continue;
            result += diffList[i];
        }

        System.out.println(result);
    }
}
