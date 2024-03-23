import java.io.*;
import java.util.*;

public class Main {

    // 비둘기 집의 원리
    // 만약 4칸이있는데 비둘기가 5마리라면 4칸중 한칸은 무조건 2마리가 있을것.
    // 이처럼 mbti는 16종류이기 때문에 17명이라면 최소 2명이 하나의 mbti로 겹치고, 33명이면 최소 3명이 하나의 mbti로 겹치게된다.
    // 따라서 32명 초과이면 거리를 0으로 반환해버리면 시간복잡도를 줄일수있다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            String[] mbtiList = new String[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            if (N > 32) {
                sb.append(0).append("\n");
                continue;
            }

            for (int j = 0; j < N; j++) {
                String mbti = st.nextToken();
                mbtiList[j] = mbti;
            }

            int result = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    for (int l = k + 1; l < N; l++) {
                        result = Math.min(result, solution(mbtiList[j], mbtiList[k], mbtiList[l]));
                    }
                }
            }
            sb.append(result).append("\n");

        }

        System.out.println(sb);
    }

    static int solution(String s1, String s2, String s3) {

        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (s1.charAt(i) != s2.charAt(i)) result++;
            if (s1.charAt(i) != s3.charAt(i)) result++;
            if (s2.charAt(i) != s3.charAt(i)) result++;
        }

        return result;
    }


}
