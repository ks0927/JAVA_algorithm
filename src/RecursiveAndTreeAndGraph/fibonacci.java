package RecursiveAndTreeAndGraph;

import java.util.Scanner;

public class fibonacci {
    public int DFS(int n,int[] arr){

        if(arr[n]!=0)
            return arr[n];
        else if(n==1 || n==2)
            return arr[n]= 1;
        else{
            int tmp = DFS(n-2,arr) + DFS(n-1,arr);
            arr[n]=tmp;
            return tmp;
        }

    }


    public static void main(String[] args) {
        fibonacci F = new fibonacci();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n+1];
        F.DFS(n,arr);
        for(int i=1; i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
