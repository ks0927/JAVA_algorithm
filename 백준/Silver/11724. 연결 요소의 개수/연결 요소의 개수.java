import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {


    //인접 리스트로 무방향 그래프 설정
    static ArrayList<ArrayList<Integer>> graph;
    //해당 정점이 연결되었나 체크(내부 숫자를 통해 누구누구하고 같이 연결되어있는지도 확인간으
    static int[] visited;
    static int N;
    static int M;
    //연결 요소 (Connected Component)의 개수
    static int CC;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[N+1];

        //그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        CC =0;
        for (int i = 1; i <= N; i++) {
            //아직 연결된적이 없다면
            if(visited[i]==0){
                ++CC;
                solution(i,CC); //dfs를 불러서 같이 연결된 모든 정점을 찾아서 같은 visited 값을 가지게한다.
            }
        }
        System.out.println(CC);


    }

    static void solution(int x, int cc){

        visited[x] = cc;

        ArrayList<Integer> integers = graph.get(x);
        for (Integer integer : integers) {
            if(visited[integer]==0){
                visited[integer]=cc;
                solution(integer,cc);
            }
        }

    }
}
