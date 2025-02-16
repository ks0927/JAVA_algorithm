import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean[] visited;
    static boolean check;
    static String result;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String perm = br.readLine();

        int length = perm.length();
        N = (length < 10) ? length : 9 + (length - 9) / 2;
        int twoSlicePoint = (length < 10) ? 0 : (length - 9) / 2;

        result = "";
        check = false;
        visited = new boolean[N + 1];
        DFS(0, twoSlicePoint, perm, "");

        System.out.print(result);
    }

    private static void DFS(int depth, int twoSlicePoint, String perm, String repairPerm) {
        if (check) {
            return;
        }

        if (depth == N) {

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    return;
                }
            }

            check = true;
            result = repairPerm;
            return;
        }

        // 2칸 자르기
        if (twoSlicePoint > 0) {
            int curNum = Integer.parseInt(perm.substring(0, 2));

            if (curNum >= 0 && curNum <= N && !visited[curNum]){
                visited[curNum] = true;
                DFS(depth + 1, twoSlicePoint - 1, perm.substring(2), repairPerm + perm.substring(0, 2) + " ");
                visited[curNum] = false;
            }

        }

        // 1칸 자르기
        int curNum = Integer.parseInt(perm.substring(0, 1));
        if(!visited[curNum]){
            visited[curNum] = true;
            DFS(depth + 1, twoSlicePoint, perm.substring(1), repairPerm + perm.substring(0, 1) + " ");
            visited[curNum] = false;
        }
        
    }

}
