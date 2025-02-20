import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int N;
    static int R;
    static int result;
    static int[][] map;
    static boolean[] visited;
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
 
            N = Integer.parseInt(br.readLine());
            R = N / 2;
            map = new int[N][N];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j2 = 0; j2 < N; j2++) {
                    map[j][j2] = Integer.parseInt(st.nextToken());
                }
            }
             
            result = Integer.MAX_VALUE;
            visited = new boolean[N];
            combi(0, 0);
             
            sb.append("#").append(i + 1).append(" ").append(result).append("\n");
        }
         
        System.out.println(sb);
    }
 
    private static void combi(int depth, int start) {
 
        if (depth == R) {
//          System.out.println(Arrays.toString(visited));
 
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
 
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    A.add(i);
                } else {
                    B.add(i);
                }
            }
 
            makeFood(A, B);
 
            return;
        }
 
        for (int i = start; i < N; i++) {
            visited[i] = true;
            combi(depth + 1, i + 1);
            visited[i] = false;
        }
    }
 
    private static void makeFood(ArrayList<Integer> A, ArrayList<Integer> B) {
        int sumA = 0;
 
        for (int i = 0; i < R; i++) {
            for (int j = i + 1; j < R; j++) {
                Integer food1 = A.get(i);
                Integer food2 = A.get(j);
                sumA += map[food1][food2];
                sumA += map[food2][food1];
            }
        }
 
        int sumB = 0;
 
        for (int i = 0; i < R; i++) {
            for (int j = i + 1; j < R; j++) {
                Integer food1 = B.get(i);
                Integer food2 = B.get(j);
                sumB += map[food1][food2];
                sumB += map[food2][food1];
            }
        }
        int abs = Math.abs(sumA - sumB);
        result = Math.min(result, abs);
    }
 
}