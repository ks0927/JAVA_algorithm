package RecursiveAndTreeAndGraph;

import java.util.Scanner;

public class binary {
    public void DFS(int n){
        if(n==0) return;
        else{
            DFS(n/2);
            System.out.println(n%2);
        }
    }

    public static void main(String[] args) {
        binary B = new binary();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        B.DFS(n);
    }
}
