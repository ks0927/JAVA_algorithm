import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int parseInt = Integer.parseInt(st.nextToken());
            if(binarySearch(arr, parseInt) >= 0){
                sb.append(1).append("\n");
            }else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int binarySearch(int[] arr, int parseInt) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int middle = (left + right) / 2;

            if (parseInt < arr[middle]) {
                right = middle - 1;
            } else if (parseInt > arr[middle]) {
                left = middle + 1;
            } else {
                //찾으면 인덱스값 반환.
                return middle;
            }
        }
        //못찾음
        return -1;
    }
}
