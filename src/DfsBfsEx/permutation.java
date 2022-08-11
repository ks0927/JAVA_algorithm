package DfsBfsEx;

import java.util.Scanner;

public class permutation {
    static int n;
    static int m;
    static int[] checkCurInt;
    public void DFS(int L){
        if(L ==m){
            for (int i : checkCurInt) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        else{
            for (int i = 1; i <= n; i++) {
                checkCurInt[L]=i;
                DFS(L+1);
            }
        }
    }

    public static void main(String[] args) {
        permutation P = new permutation();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();
        checkCurInt = new int[m];
        P.DFS(0);
    }
}
