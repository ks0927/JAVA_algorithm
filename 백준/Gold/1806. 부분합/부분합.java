import java.io.*;
import java.util.*;

public class Main{
    static int N,S;
    static int[] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        map = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int min = 200001;
        int sum = map[right];
        while (right < N){

            if(sum >= S) {
                min = Math.min(min,(right - left + 1));
                if(min == 1){
                    break;
                }
                sum-=map[left];
                left++;
            }else {
                right++;
                if(right == N)
                    break;
                sum+=map[right];
            }
        }

        System.out.println(min==200001?0:min);
    }
}



