import java.io.*;
import java.util.*;

public class Solution {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                arr.add(new ArrayList<>());
            }

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    int parseInt = Integer.parseInt(st.nextToken());
                    arr.get(j).add(parseInt);
                }
            }

            ArrayList<ArrayList<Integer>> turn90 = turn(arr);
            ArrayList<ArrayList<Integer>> turn180 = turn(turn90);
            ArrayList<ArrayList<Integer>> turn270 = turn(turn180);

            sb.append("#").append(i+1).append("\n");

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    Integer value = turn90.get(j).get(k);
                    sb.append(value);
                }
                sb.append(" ");
                for (int k = 0; k < N; k++) {
                    Integer value = turn180.get(j).get(k);
                    sb.append(value);
                }
                sb.append(" ");
                for (int k = 0; k < N; k++) {
                    Integer value = turn270.get(j).get(k);
                    sb.append(value);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    public static ArrayList<ArrayList<Integer>> turn(ArrayList<ArrayList<Integer>> arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = N -1; j >= 0; j--) {
                Integer value = arr.get(j).get(i);
                result.get(i).add(value);
            }
        }

        return result;
    }

}
