package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class allAnagram {
    public boolean isEqual(Map<Character,Integer> map,Map<Character,Integer> target){
        for(char x: target.keySet()){
            if(!map.containsKey(x))
                return false;
            if(map.get(x)!=(target.get(x)))
                return false;
            }

        return true;
    }


    public int solution(String str,String word){
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> target = new HashMap<>();
        int answer= 0;

        char[] str_char = str.toCharArray();
        for(Character x: word.toCharArray())
            target.put(x,target.getOrDefault(x,0)+1);

        for(int i=0; i<word.length(); i++){
            map.put(str_char[i],map.getOrDefault(str_char[i],0)+1);
        }
        if(isEqual(map,target))
            answer++;

        for(int i=0; i<str.length()-word.length(); i++){
            int lt = i;
            int rt = i+word.length();
            map.put(str_char[rt],map.getOrDefault(str_char[rt],0)+1);
            map.put(str_char[lt],map.getOrDefault(str_char[lt],0)-1);
            if(map.get(str_char[lt])==0)
                map.remove(str_char[lt]);
            if(isEqual(map,target))
                answer++;
        }
        return answer;
    }
    //equals 함수를 사용한 버전
    public int solution2(String str, String word){
        int answer= 0;
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> target = new HashMap<>();

        for(char x : word.toCharArray())
            target.put(x,target.getOrDefault(x,0)+1); // 타겟문자열 map에 추가

        int k = word.length()-1;
        for (int i = 0; i < k; i++) {
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        //sliding window
        for (int i = k; i < str.length(); i++) {
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);  //하나밀고
            if(map.equals(target))  //equals 함수를 사용하면 entryset 즉 모든 키값과 value를 꺼내서 비교하는듯
                answer++;
            map.put(str.charAt(i-k),map.get(str.charAt(i-k))-1); //밀었으니까 앞에꺼 지우고
            if(map.get(str.charAt(i-k))==0)  //value값이 0이면 key-value 쌍 삭제제
               map.remove(str.charAt(i-k));
        }

        return answer;
    }


    public static void main(String[] args){
        allAnagram A =  new allAnagram();
        Scanner kb = new Scanner(System.in);

        String  str = kb.next();
        String  word = kb.next();
        System.out.println(A.solution(str,word));
        System.out.println(A.solution2(str,word));
    }
}
