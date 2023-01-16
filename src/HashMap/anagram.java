package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class anagram {
    //첫번째 단어를 집어넣고 두번째 단어는 -1해서 만약 0이 아닌값이있으면 no
    public void solution(String str1,String str2){
        Map<Character,Integer> map = new HashMap<>();
        int difference=0;

        for(Character x : str1.toCharArray())
            map.put(x,map.getOrDefault(x,0)+1);
        for(Character x : str2.toCharArray())
            map.put(x,map.getOrDefault(x,-1)-1);

        for(int x: map.values()){
            if(x!=0)
                difference++;
        }
        if(difference!=0)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
    //중간에 잘못된게 있으면 바로 return하기 때문에 좀 더 성능이 좋음
    public String solution2(String str1, String str2){
        Map<Character,Integer> map = new HashMap<>();

        for (char x :str1.toCharArray()) {
            map.put(x, map.getOrDefault(x,0)+1);
        }

        for (char x : str2.toCharArray()) {
            if(!map.containsKey(x) || map.get(x)==0){ //만약 알파벳이 없거나, 있긴한데 이제 다 체크해서 0일때 NO
                return "NO";
            }
            map.put(x, map.get(x)-1);  //1개 지움으로서 하나체크
        }
        return "YES";
    }


    public static void main(String[] args){
        anagram A = new anagram();
        Scanner kb = new Scanner(System.in);

        String str1 = kb.next();
        String str2 = kb.next();
        A.solution(str1,str2);
        System.out.println(A.solution2(str1,str2));
    }
}
