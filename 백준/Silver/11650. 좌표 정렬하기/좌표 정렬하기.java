import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<Node> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parseIntX = Integer.parseInt(st.nextToken());
            int parseIntY = Integer.parseInt(st.nextToken());
            arr.add(new Node(parseIntX,parseIntY));
        }

        Collections.sort(arr);

        for (Node node : arr) {
            sb.append(node.x).append(" ").append(node.y).append("\n");
        }
        System.out.println(sb);
    }

    public static class Node implements Comparable<Node>{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if(this.x == o.x){
                return  this.y - o.y;
            }else {
                return this.x - o.x;
            }
        }
    }
}