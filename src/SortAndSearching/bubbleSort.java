package SortAndSearching;

import java.util.Scanner;

public class bubbleSort {
    public int[] solution(int n, int[] arr) {
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args){
        bubbleSort B = new bubbleSort();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]= kb.nextInt();

        for(int x: B.solution(n,arr))
            System.out.print(x+" ");
    }

}
