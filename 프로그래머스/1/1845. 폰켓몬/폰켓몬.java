import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int get = nums.length / 2;
        
        Set<Integer> set = new HashSet<>();
        for (int parseInt : nums) {
            set.add(parseInt);
        }
        int check = set.size();
        
        int answer = 0;
        if(check < get) {
            answer = check;
        }else{
            answer = get;
        }
        return answer;
    }
}