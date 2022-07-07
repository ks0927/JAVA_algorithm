package Array;

import java.util.Scanner;

public class classPresident {


    public static void main(String[] args){

        classPresident C = new classPresident();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n ; i++){
            for(int j =0; j<n; j++)
                arr[i][j]= kb.nextInt();
        }

    }
}
