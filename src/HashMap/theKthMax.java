package HashMap;

import java.util.*;

public class theKthMax {
    public int solution(int n ,int k, int[] arr){
        HashSet<Integer> result = new HashSet<>();
        //이렇게 하면 3장을 뽑는 모든 경우 다 돌수있다.
        //그러면 3장이아닌 경우엔 이렇게 하드코딩말고 어케하지? 조합구현해서 해야되나
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
        Collections.sort(answer); //오름차순정렬
        Collections.reverse(answer);//오름차순을 뒤집으면 내림차순

        //TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder()); 만약 treeset을 쓰면 집어넣때마다 내림차순으로 정렬되는디...
        //treeset과 treemap은 이진탐색트리형태로 저장해서 정렬과 검색에 유리함
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
