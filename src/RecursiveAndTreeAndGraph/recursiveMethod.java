package RecursiveAndTreeAndGraph;

import java.util.Scanner;

public class recursiveMethod {
    public void DFS(int n){
        if(n==0){
            return;
        }
        else {
            System.out.println(n);
            DFS(n-1);
        }
    }

    public static void main(String[] args) {
        recursiveMethod  R = new recursiveMethod();
        Scanner kb =new Scanner(System.in);
        int a = kb.nextInt();
        R.DFS(a);
    }
}
