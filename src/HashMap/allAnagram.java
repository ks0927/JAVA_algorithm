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


    public static void main(String[] args){
        allAnagram A =  new allAnagram();
        Scanner kb = new Scanner(System.in);

        String  str = kb.next();
        String  word = kb.next();
        System.out.println(A.solution(str,word));
    }
}
