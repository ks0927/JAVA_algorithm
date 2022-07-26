package SortAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {
    public int solution(int n, int m, int[] arr){
        Arrays.sort(arr);
        int lt = 0;
        int rt = arr.length-1;
        while(lt<=rt){
            int middle = (lt+rt)/2;
            if(arr[middle]==m){
                return middle+1;
            }
            else if(arr[middle]<m){
                lt = middle+1;
            }
            else{
                rt = middle-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        binarySearch B = new binarySearch();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]= kb.nextInt();

        System.out.println(B.solution(n,m,arr));
    }
}
