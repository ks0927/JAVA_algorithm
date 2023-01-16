package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class classPresident {
    public char solution(int n,String str){
        char answer = ' ';
        Map<Character,Integer> vote = new HashMap<>();
        //hashMap은 hashing(해싱)을 사용해서 많은 양의 데이터를 검색하는데 뛰어난 성능을보인다
        //Map은 key와 value를 하나의 쌍으로 저장하는데 key는 중복을 허용하지않는다.(value는 가능)
        //만약 put으로 이미존재하는 key를 집어넣으면 기존 값은 사라지고 새로 입력되는 값으로 대치된다.
        for(char x : str.toCharArray()){
            if(vote.containsKey(x)) { //이미 있는 key(후보의 기호) 라면
                int a =vote.get(x);
                vote.put(x,++a); //value값을 새로 초기화
            }
            else{
                vote.put(x,1); //처음보는 key(후보의 기호)라면 추가
            }
            //vote.put(x, map.getOrDefault(x, 0)+1); 이런식으로 하면 map.getOrDefault(x, 0)로 key-value를 만들고 value값 리턴해서
            //좀더 깔끔하고 간결하게 코드를 작성할 수 있다.
        }
        int max=0;
        for(char key : vote.keySet()){
            if(vote.get(key)>max){
                max=vote.get(key);
                answer = key;
            }
        }
        return answer;

    }

    public static void main(String[] args){

        classPresident C = new classPresident();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(C.solution(n,str));
    }
}
