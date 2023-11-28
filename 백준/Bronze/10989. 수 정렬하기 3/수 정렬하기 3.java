import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        //카운팅 정렬 
        int[] arr = new int[10_000_001];
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i < 10_000_001; i++) {
            while(arr[i]>0){
                sb.append(i).append("\n");
                arr[i]--;
            }
        }
        System.out.println(sb);
    }
}
