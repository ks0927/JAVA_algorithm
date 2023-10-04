package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj9655 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int threeCount = N / 3;
        int oneCount = N % 3; // 0 1 2

        //전체 횟수
        int allCount = threeCount + oneCount;

        //횟수가 짝수면 창영, 홀수면 상근이 이긴다.
        if(allCount%2 == 0 ){
            System.out.println("CY");
        }
        else{
            System.out.println("SK");
        }
    }
}
