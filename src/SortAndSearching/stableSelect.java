package SortAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class stableSelect {
    public int count(int[] arr, int dist){
        int cnt =1;
        int ep = arr[0];
        for(int i=1; i< arr.length; i++){
            if(arr[i]-ep >= dist){
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }

    public int solution(int n, int c, int[] arr){
        int answer =0;
        Arrays.sort(arr);
        int lt =1;
        int rt =arr[n-1];
        while(lt<= rt){
            int middle = (lt+rt)/2;
            if(count(arr,middle)>=c){ // c마리보다 더들어간다면 일단 조건은 성립
                answer=middle;
                lt=middle+1; //더 좋은값을 찾아서 ㄱㄱ
            }
            else{
                rt = middle-1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        stableSelect S = new stableSelect();
        Scanner kb= new Scanner(System.in);

        int n = kb.nextInt();
        int c = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]= kb.nextInt();
        System.out.println(S.solution(n,c,arr));
    }
}
