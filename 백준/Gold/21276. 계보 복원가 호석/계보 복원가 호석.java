import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] tree;
    static HashMap<String, Integer> map;
    static HashMap<Integer, String> map2;
    static int[] weights;
    static List<String>[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);

        map = new HashMap<>();
        map2 = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(arr[i], i);
            map2.put(i, arr[i]);
        }

        M = Integer.parseInt(br.readLine());

        tree = new List[N];
        result = new List[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
            result[i] = new ArrayList<>();
        }

        weights = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String son = st.nextToken();
            String anc = st.nextToken();

            int sonIndex = map.get(son);
            int ancIndex = map.get(anc);

            weights[sonIndex] += 1;
            tree[ancIndex].add(sonIndex);
        }

        int family = 0;

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (weights[i] == 0) {
                family++;
                queue.add(i);
                sb.append(map2.get(i) + " ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");

        System.out.println(family);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < tree[now].size(); i++) {
                int son = tree[now].get(i);
                weights[son] -= 1;

                if(weights[son] == 0) {
                    result[now].add(map2.get(son));
                    queue.add(son);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(map2.get(i)).append(" ");
            if(result[i].size() == 0) {
                sb.append(0).append("\n");
            }else {
                sb.append(result[i].size()).append(" ");

                Collections.sort(result[i]);
                for (int j = 0; j < result[i].size(); j++) {
                    sb.append(result[i].get(j)).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

}

