package SortAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class coordinateAlignment {
    public void solution(int n,int[][] arr){
        Arrays.sort(arr,((o1, o2) -> {
            if(o1[0]==o2[0]){
                return Integer.compare(o1[1],o2[1]);
            }
            else {
                return Integer.compare(o1[0], o2[0]);
            }
        }));

        for(int i=0; i<n; i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }
    }

    public static void main(String[] args) {
        coordinateAlignment C =new coordinateAlignment();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++)
                arr[i][j]= kb.nextInt();
        }
        C.solution(n,arr);

    }
}
