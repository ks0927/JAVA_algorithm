package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14916 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int result = 0;

        //돈이 5보다 크면 일단 낼수있는 가장 큰 거스름돈인 5를 먼저 생각해본다.
        if(5<=N){

            int a = N / 5;

            //거스름돈 5로 줄수있는 최대 갯수는 a개 인데
            //거스름돈 5를 a개를 주고 남은 돈(temp)가 0이면 그게 최소거스름돈 갯수고
            //0이 아니고 2로 나눠진다면 지금까지의 거스름돈 5의 갯수와 남은 N을 초기화
            for (int i = a; i >=1; i--) {
                int temp = N - (5*i);

                if(temp ==0){
                    System.out.print(i);
                    return;
                }

                if(temp %2 ==0){
                    result = i;
                    N = temp;
                    break;
                }
            }
        }

        //남은 N이 들어오고 거스름돈 2 일때 를 생각한다.
        //1일때도 생각해서 1<=N
        if(1<=N){
            //만약 2로 안나눠지면 5와 2로 거슬러줄수없는 돈이다. -1반환
            if(N % 2 != 0){
                result = -1;
                System.out.println(result);
                return;
            }
            // 2로 나눠지기때문에 나눠서 반환
            int a = N /2 ;
            result+=a;
        }

        System.out.println(result);
    }
}
