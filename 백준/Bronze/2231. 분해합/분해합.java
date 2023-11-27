import java.util.*;
import java.io.*;

public class Main{
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        arr = new int[1_000_001];
        
        for (int i = 1; i < 1_000_001; i++) {
            arr[i]=(splitInt(i));
            if(arr[i] == N){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }


    public static int splitInt(int num){
        int answer = num;

        while(true){

            if(num / 10 != 0){
                answer += num %10;
                num/= 10;
            }else {
                answer += num;
                break;
            }
        }
        return answer;
    }
}