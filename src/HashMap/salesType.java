package HashMap;

import java.util.*;

public class salesType {
    public ArrayList<Integer> solution(int n, int k, int[] arr){
/*        HashSet<Integer> set = new HashSet<>();
        int[] answer= new int[n-k+1];
        for(int i=0; i<n-k+1; i++ ){
            for(int j=i; j<k+i; j++){
                set.add(arr[j]);
            }
            answer[i]=set.size();
            set.clear();
        }*/
        Map<Integer,Integer> slide = new HashMap<>();
        ArrayList<Integer> answer= new ArrayList<>();
        for(int i=0; i<k; i++)
            slide.put(arr[i],slide.getOrDefault(arr[i],0)+1);
        answer.add(slide.size());

        for(int j= k; j<n;j++){
            slide.put(arr[j],slide.getOrDefault(arr[j],0)+1);
            slide.put(arr[j-k],slide.getOrDefault(arr[j-k],0)-1);
            if(slide.get(arr[j-k])==0)
                slide.remove(arr[j-k]);
            answer.add(slide.size());
        }
        return answer;
    }


    public static void main(String[] args){
        salesType S = new salesType();
        Scanner kb= new Scanner(System.in);

        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = kb.nextInt();

        for(int x : S.solution(n,k,arr))
            System.out.print(x+" ");
    }
}
