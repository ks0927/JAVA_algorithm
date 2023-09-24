package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1092 {

    static int N;
    static int M;
    static Integer[] crane;
    static List<Integer> box;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 크레인 값 초기화
        crane = new Integer[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int cranePower = Integer.parseInt(st.nextToken());
            crane[i] = cranePower;
        }
        //내림차순으로 정렬
        Arrays.sort(crane, Collections.reverseOrder());
        int maxCranePower = crane[0];

        // 박스 값 초기화
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int boxWeight = Integer.parseInt(st.nextToken());
            box.add(boxWeight);
        }
        //내림차순으로 정렬
        Collections.sort(box,Collections.reverseOrder());
        int maxBoxWeight = box.get(0);

        //만약 가장 강한 크레인보다 가장무거운박스가 더 크면 모든박스를 배로 옮길수없다.
        if(maxCranePower < maxBoxWeight){
            System.out.println(-1);
            return;
        }

        int result = 0;
        while(!box.isEmpty()){

            // 인덱스를 기억하는 변수. 왜 기억해야하나?
            // 예를 들면 9 1 1 상황에서 93333 을 돈다고생각하면
            // 9다음 1이 돌때 한번 3333을 돌면
            // 다음 두번째 1이 돌때는 인덱스를 기억하고있다면 333'3' <- 여기 이후부터 돌면 시간복잡도가 줄겠지?
            int indexSave = 0;
            for (int i = 0; i < crane.length; i++) {
                Integer nowCrane = crane[i];
//                System.out.println("nowCrane = " + nowCrane);

                //돌다가 박스가 비었으면 바로나가기
                if(box.isEmpty()){
                    break;
                }
                //
                if(indexSave<=0){
                    indexSave = 0;
                }

                for (int j = indexSave; j < box.size(); j++) {
                    indexSave = j;
//                    System.out.println("j = " + j + ", box.get(j) = "+box.get(j) +" box.size() ="+ box.size() + " indexSave = "+indexSave);
                    if(nowCrane >= box.get(j) ){
                        box.remove(j);
                        // box 리스트가 줄어들면 인덱스도 하나 줄어들어야지.
                        indexSave--;
                        break;
                    }


                }
            }

            result++;
        }

        System.out.println(result);
    }
}
