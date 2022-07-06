package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class plaidPlate {

    public int soultion(int n,int[][] arr){
        ArrayList<Integer> sum =new ArrayList<>();
        int tmp;
        for(int i=0; i<n ; i++){
            tmp = 0;
            for(int j =0; j<n; j++){
                tmp +=arr[i][j];
            }
            sum.add(tmp);
        }
        for(int i=0; i<n ; i++){
            tmp = 0;
            for(int j =0; j<n; j++){
                tmp +=arr[j][i];
            }
            sum.add(tmp);
        }
        tmp=0;
        for(int i=0; i<n ; i++){
            tmp += arr[i][i];
        }
        sum.add(tmp);

        tmp=0;
        for(int i=n-1; i>=0 ; i--){
            tmp += arr[i][i];
        }
        sum.add(tmp);
        int answer= 0;
        for(int x : sum){
            if(x>answer)
                answer=x;
        }
        return answer;

    }

    public static void main(String[] args){
        plaidPlate P = new plaidPlate();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n ; i++){
            for(int j =0; j<n; j++)
                 arr[i][j]= kb.nextInt();
        }

        System.out.println(P.soultion(n,arr));
    }
}
