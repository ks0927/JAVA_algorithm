package DfsBfsEx;

import java.util.Scanner;

public class maxScore {
    static int m;
    static int n;
//    static boolean[] check;
    static int max =0;
    static int[] sum_score;
    static int[] sum_time;
    public void DFS(int L, int sum, int time){
        if(time > m){
            return;
        }
        if(L==n){
            if(sum> max){
                max=sum;
            }
        }
        else{
//            check[L]=true;
            DFS(L+1,sum+sum_score[L],time+sum_time[L]);
//            check[L]=false;
            DFS(L+1,sum,time);

        }
    }

    public static void main(String[] args) {
        maxScore M = new maxScore();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();
//        check= new boolean[n];

        sum_score = new int[n];
        sum_time = new int[n];
        for (int i = 0; i <n; i++) {
            sum_score[i]= kb.nextInt();
            sum_time[i]= kb.nextInt();
        }

        M.DFS(0,0,0);
        System.out.println(max);

    }
}
