package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2141 {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

//        포문으로 우체국이 될수있는 위치를 모두 돌면서 해당위치에 우체국이 놓아졌을때
//        좌우의 사람들을 다시 모두 돌면서 거리의 합을 구하면 모든 경우의 수가 나오고
//        해당 값들중 가장작을때 이면서 가장 인덱스가 작은곳을 구하려했다.
//
//        허나 마을의 갯수는 1 ≤ N ≤ 100,000 이고 해당 루프를 돌면서 내부에서 좌우루프를 N만큼 다시 돌텐데
//        그러면 최악의 경우 10,000,000,000의 시행이 이어질것이라 생각했고 해당문제는 특정 요건이 있을거라 판단했다.
//                딱 생각나는 것은 없어서 이전의 그리디 문제들을 돌아보다가 이전의 백준 20300의 서강근육맨이 생각났다.
//                해당 문제와 같은 풀이는 아니지만 해당문제에서 팀을 이룰때 값을 고르게 고르는 상황을 유도했었다.
//        그래서 이번 문제도 그러면 우체국의 위치로부터 좌 우의 마을사람들이 비슷하게 혹은 같게 되는 상황일때 최소일수있나? 가정했다.
//
//                문제는 구현을 어떻게 하면 좌우를 비교하는데 시간을 적게 진행할까... 즉 그리디 하게 하는 방식을 고민했다.
//        그냥 앞에서부터 더하다가 인구수의 절반이 나온 시점에 우체국을 놓으면 그게 좌우가 비슷한 인구수로 배치되지않을까 생각.
    }
}
