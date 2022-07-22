package SortAndSearching;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class duplicationCheck {
    public void solution(int n, int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int x: arr){
            set.add(x);
        }
        if(set.size()!=n)
            System.out.println("D");
        else
            System.out.println("U");
    }

    public static void main(String[] args) {
        duplicationCheck D = new duplicationCheck();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]= kb.nextInt();
        D.solution(n,arr);
    }
}
