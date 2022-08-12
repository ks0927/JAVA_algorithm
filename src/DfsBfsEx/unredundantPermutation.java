package DfsBfsEx;

import java.util.Scanner;

public class unredundantPermutation {
    static int n;
    static int m;
    static int[] arr;
    static int[] cur_int;
    static boolean[] check;

    public void DFS(int L){
        if(L==m){
            for (int i : cur_int) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        else{
            for (int i = 0; i < n; i++) {
                if(check[i]==false) { //안갔을때
                    check[i] = true;  //갔다고 체크
                    cur_int[L]=arr[i];  //간곳 값 저장
                    DFS(L + 1);
                    check[i] = false; //돌아와서 반환
                }
            }
        }
    }

    public static void main(String[] args) {
        unredundantPermutation U = new unredundantPermutation();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt();
        m=kb.nextInt();
        arr=new int[n];
        for(int i=0; i<n; i++)
            arr[i]=kb.nextInt();
        check=new boolean[n];
        cur_int=new int[m];

        U.DFS(0);
    }
}
