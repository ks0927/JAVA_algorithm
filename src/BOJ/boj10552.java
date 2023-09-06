package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10552 {

    static int[] hateChannelToFavoriteChannel; //싫어하는 채널에서 좋아하는 채널로 가는 배열
    static boolean[] visited;
    static int N;
    static int M;
    static int P;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        hateChannelToFavoriteChannel = new int[M+1];
        visited = new boolean[M+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int like = Integer.parseInt(st.nextToken());
            int hate = Integer.parseInt(st.nextToken());
            //이렇게 하는 이유는 최초의 값 즉 가장 어린사람이 채널을 바꾸기때문에
            //한번 싫어하는채널->좋아하는채널 값이 입력되면 더이상 갱신되면 안된다.
            if(hateChannelToFavoriteChannel[hate]==0) {
                hateChannelToFavoriteChannel[hate] = like;
            }
        }
        result =0;
        DFS(P);

        System.out.println(result);
    }

    static void DFS(int channel){


        if(visited[channel]) { //이미 간적있는 채널이면 사이클이 만들어졌다는것이기 때문에 끊어줘야한다.
            result = -1;
        }
        else if(hateChannelToFavoriteChannel[channel] != 0){ //해당 채널을 싫어하는 사람이 있다면
            result++;
            visited[channel] = true; //현재 채널 체크하고
            DFS(hateChannelToFavoriteChannel[channel]); //좋아하는 채널로 이동
        }
    }
}
