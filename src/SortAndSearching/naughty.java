package SortAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class naughty {

    public int[] solution(int n, int[] arr) {
        int[] answer = new int[2];
        int[] copyarr =arr.clone();
        Arrays.sort(copyarr);
//        System.out.println(Arrays.toString(copyarr));
        int lt = 0, rt = n - 1;
        for (int i = 0; i < n; i++) {
            if (arr[lt] != copyarr[lt]) {
                answer[0] = lt + 1;
                break;
            }
            lt++;
        }
        for (int i = 0; i < n; i++) {
            if (arr[rt] != copyarr[rt]) {
                answer[1] = rt + 1;
                break;
            }
            rt--;
        }
        return answer;
/*        for(int i=0; i<n; i++){
            if(arr[lt]>arr[lt+1]){
                answer[0]=lt+1;
                break;
            }
            lt++;
        }
        for(int i=0; i<n; i++){
            if(arr[rt]<arr[rt-1]){
                answer[1]=rt+1;
                break;
            }
            rt--;
        }return answer;*/
    }

    public static void main(String[] args) {
        naughty N = new naughty();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]= kb.nextInt();
        for(int x: N.solution(n,arr))
            System.out.print(x+" ");
    }
}
