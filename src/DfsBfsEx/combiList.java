package DfsBfsEx;

import java.util.Scanner;

public class combiList {
    static int n;  //1~n 까지의 구슬
    static int m; //그중 뽑는 갯수
    static int[] arr;
    public void DFS(int L,int start){
        if(L==m){
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        else{
            for (int i = start; i <= n; i++) {
                arr[L] =i;
                DFS(L+1,i+1);
            }
        }
    }

    public static void main(String[] args) {
        combiList C = new combiList();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        m= kb.nextInt();
        arr= new int[m];

        C.DFS(0,1);

    }
}
