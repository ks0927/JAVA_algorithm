package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj16234 {


    static int N;
    static int L;
    static int R;
    static int team;
    static int result;
    static int[][] map;
    static int[][] visited;
    static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}}; //상 하 좌 우

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());


        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
            }
        }

        result = 0;
        while(true){
            visited = new int[N][N]; // 방문배열을 순회를 돌때마다 초기화 필요

            team =1;
/*            System.out.println("map배열");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }*/
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(visited[i][j]!=0) continue; //누군가와 이미 연합인 상태면 pass
                    DFS(i,j);
                    ++team;
                }
            }
/*            System.out.println("visited배열");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(visited[i][j]);
                }
                System.out.println();
            }*/

            //연합의 갯수가 모든 국가들의 갯수라면 더이상 이동이 없다는것이다.
            if(team == N*N+1) {
//                System.out.println("team = " + team);
                break;
            }

            ++result; //연합이 잘 형성되어있으므로 하루 지났음을 체크

            //map을 통해 이제 visited를 순회하면서 같은 연합 즉 같은 숫자인 국가들의 인덱스를 저장한다
            //키값은 숫자 , 벨류값은 해당숫자를 가진 visited의 인덱스
            //map으로 만들어서 해당국가의 갯수를 size로 간편하게 구할수도있다.
            Map<Integer, ArrayList<int[]>> intIndexMap = new HashMap<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int intValue = visited[i][j];
                    int[] index = {i,j};

                    if (!intIndexMap.containsKey(intValue)) { //기존에 존재하던 연합이 아니면
                        intIndexMap.put(intValue, new ArrayList<>());  //만들어주고
                    }
                    intIndexMap.get(intValue).add(index);  //인덱스 값도 넣어준다.
                }
            }

            for (Integer integer : intIndexMap.keySet()) { //키값들을 순회한다.
                ArrayList<int[]> indexList = intIndexMap.get(integer); //같은 키값인 인덱스를 불러온뒤
                int unionSum =0;
                int unionSize = indexList.size();

                for (int[] ints : indexList) { //인덱스를 돌며 인구를 구한다
                    int indexR = ints[0]; // r좌표
                    int indexC = ints[1]; // c좌표
                    unionSum+=map[indexR][indexC]; //구한 인구값을 연합 총합에 더해주고
                }
                int distribute = unionSum / unionSize; //최종적으로 연합 총합과 연합 국가들을 나눠서 분배값을 찾는다.

                for (int[] ints : indexList) {
                    int indexR = ints[0]; // r좌표
                    int indexC = ints[1]; // c좌표
                    map[indexR][indexC]= distribute; //분배값을 다시 맵에 적용한다
                }
            }

        }

        System.out.println(result);


    }

    static void DFS(int r, int c){
        visited[r][c] = team;

        for (int i = 0; i < 4; i++) {
            int next_r = r + direction[i][0];
            int next_c = c + direction[i][1];

            //범위 밖이면 out
            if(!(0<= next_r && next_r< N && 0 <= next_c && next_c < N)) continue;

            int curValue = map[r][c];
            int nextValue = map[next_r][next_c];
            int differ = Math.abs(curValue - nextValue); //현재 값과 다음값의 차이(절대값)
            if(L <=differ && differ<=R){ //차이값이 L과 R사이 일때
                if(visited[next_r][next_c] != 0) continue; //방문한적 없는 땅이라면 pass

                DFS(next_r,next_c); //다음 땅으로
            }
        }

    }
}
