package DfsBfsEx;

import java.util.Scanner;

public class sameSumSubset {
    static int n;
    static int[] arr;
    static boolean[] check;
    static boolean result;
    public void DFS(int L){
        if(L==n){
            int subset1 =0;   //check가 true인 값
            int subset2 =0;  //check가 false인 값
            for (int i = 0; i < n; i++) {
                if(check[i])
                    subset1+=arr[i];
                else
                    subset2+=arr[i];
            }
            if(subset1==subset2){
                result =true;
            }
            if(result==true)
                return;
        }
        else{
            check[L]=true;
            DFS(L+1);     // L값이 있을때
            check[L]=false;
            DFS(L+1); //L값이 없을때
        }

    }

    public static void main(String[] args) {
        sameSumSubset S = new sameSumSubset();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        arr  = new int[n];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        S.DFS(0);
        if(result==true)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
