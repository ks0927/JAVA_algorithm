package HashMap;

import java.util.*;

public class theKthMax {
    public int solution(int n ,int k, int[] arr){
        HashSet<Integer> result = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int m=j+1;m<n;m++){
                    result.add(arr[i]+arr[j]+arr[m]);
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for(int x: result)
            answer.add(x);
        Collections.sort(answer,Collections.reverseOrder());
        if(answer.size()>k-1)
            return answer.get(k-1);
        else
            return -1;

    }

    public static void main(String[] args){
        theKthMax T = new theKthMax();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i= 0; i<n; i++)
            arr[i]= kb.nextInt();
        System.out.println(T.solution(n,k,arr));

    }
}
