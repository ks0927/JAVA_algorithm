package DfsBfsEx;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class coinChange {
    static int money;
    static int n;
    static Integer[] arr;
    static int min =Integer.MAX_VALUE;
    public void DFS(int L,int sum) {
        if(L>min)
            return;
        if (sum > money) {
            return;
        }
        if (sum == money) {
//            System.out.println("L = " + L);
            if(min>L)
                min=L;
            return;
        }
        if(sum<money) {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, sum + arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        coinChange C = new coinChange();
        Scanner kb= new Scanner(System.in);

        n = kb.nextInt();
        arr  = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr,Collections.reverseOrder());
        money = kb.nextInt();
        C.DFS(0,0);
        System.out.println(min);
    }
}
