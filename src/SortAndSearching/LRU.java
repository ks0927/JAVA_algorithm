package SortAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class LRU {
    public int contains(int[] arr, int work){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==work){
                return i;
            }
        }
        return -99;
    }

    public int[] solution(int s, int n, int[] arr){
        int[] answer = new int[s];
        for(int i=0; i<n;i++){
            int iter = contains(answer, arr[i]);
            if(iter==-99){
                int j;
                for(j=s-1;j>=1;j--){
                    answer[j]=answer[j-1];
                }
                answer[j]=arr[i];
            }
            else{
                int j;
                for(j=iter;j>=1;j--){
                    answer[j] = answer[j-1];
                }
                answer[j]=arr[i];
            }
            //System.out.println(Arrays.toString(answer) +arr[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        LRU L = new LRU();
        Scanner kb =new Scanner(System.in);

        int s = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]= kb.nextInt();

        for(int x:L.solution(s,n,arr)){
            System.out.print(x+" ");
        }

    }
}
