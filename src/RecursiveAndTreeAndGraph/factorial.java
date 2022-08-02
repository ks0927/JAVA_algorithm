package RecursiveAndTreeAndGraph;

import java.util.Scanner;

public class factorial {
    public int DFS(int n){
        if(n==1) return 1;
        else{
            return n*DFS(n-1);
        }
    }

    public static void main(String[] args) {
        factorial F = new factorial();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        System.out.println(F.DFS(n));
    }
}
