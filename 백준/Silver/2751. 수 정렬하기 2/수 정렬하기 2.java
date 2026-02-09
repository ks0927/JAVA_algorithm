import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            arr.add(cur);
        }
        
        Collections.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < N; i++) {
            sb.append(arr.get(i)).append("\n");
        }
        
        System.out.print(sb);
    }
}