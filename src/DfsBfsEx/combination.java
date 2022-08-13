package DfsBfsEx;

import java.util.Scanner;


public class combination {
    static int[][] memo; //메모이제이션용 이차원배열
    public int DFS(int n, int r){
        if(memo[n][r]!=0){ //메모이제이션용, 만약 0이아니면 이미 방문한값
            return memo[n][r];
        }
        if(n==r||r==0){ //만약 n=r 이거나 r=0 인경우 1반환
            return memo[n][n]=1; //메모이제이션에 저장
        }
        else{
            return memo[n][r]= DFS(n-1,r-1)+DFS(n-1,r); //공식 사용
        }
    }

    public static void main(String[] args) {
        combination C = new combination();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int r = kb.nextInt();
        memo = new int[n+1][n+1];
        System.out.println(C.DFS(n,r));

    }
}
