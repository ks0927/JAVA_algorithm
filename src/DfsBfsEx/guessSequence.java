package DfsBfsEx;

import java.util.Scanner;

public class guessSequence {
    static int[][] combi; //메모이제이션용 이차원배열
    public int combination(int n, int r){
        if(combi[n][r]!=0){ //메모이제이션용, 만약 0이아니면 이미 방문한값
            return combi[n][r];
        }
        if(n==r||r==0){ //만약 n=r 이거나 r=0 인경우 1반환
            return combi[n][n]=1; //메모이제이션에 저장
        }
        else{
            return combi[n][r]= combination(n-1,r-1)+combination(n-1,r); //공식 사용
        }
    }
    static int[] precombi; //파스칼의 삼각형을 위해 미리 구해둔 컴비네이션 배열들
    static int[] cur; //값 담아둘곳
    static boolean[] check;
    boolean flag =false;
    static int n;
    static int f;

    public void DFS(int L, int sum){
        if(flag)
            return;
        if(L==n){
            if(sum==f){
                for (int x : cur) {
                    System.out.print(x+" ");
                }
                flag=true;
            }
        }
        else{
            for (int i = 1; i <= n; i++) {
                if(check[i]==false){ //중복없는 순열 만드는 거 기억하지?
                    check[i]=true;
                    cur[L]=i;
                    DFS(L+1,sum+(precombi[L]*cur[L])); //파스칼의 삼각형 성질 이용, 콤비값을 더하는...
                    check[i]=false;
                }
            }
        }
    }

    public static void main(String[] args) {
        guessSequence G = new guessSequence();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        f = kb.nextInt();
        precombi= new int[n];
        cur = new int[n];
        check=new boolean[n+1];
        combi= new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            precombi[i] = G.combination(n-1,i); //파스칼의 삼각형을 이용하기 위해서 미리 컴비네이션값을 구한다.
        }
        G.DFS(0,0);
    }
}
