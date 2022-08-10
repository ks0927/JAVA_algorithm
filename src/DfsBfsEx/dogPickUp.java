package DfsBfsEx;

import java.util.Scanner;

public class dogPickUp {
    static int c;
    static int n;
    static int[] arr;
    static Boolean[] check;
    static int max=0;
    public void DFS(int L){
        if(L==n){
            int curWeight =0;
            for (int i = 0; i < n; i++) {
                if(check[i])
                    curWeight+=arr[i];
                if(curWeight>c)
                    return;
            }
            if(curWeight>max) {
                max = curWeight;
                //System.out.println("max = " + max);
            }
        }
        else{
            check[L]=true;
            DFS(L+1);
            check[L]=false;
            DFS(L+1);
        }

    }
    public static void main(String[] args) {
        dogPickUp D = new dogPickUp();
        Scanner kb = new Scanner(System.in);
        c = kb.nextInt();
        n = kb.nextInt();
        check = new Boolean[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        D.DFS(0);
        System.out.println(max);
    }
}
