import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {         
        String[] ans = new String[arr1.length];
        
        for(int i=0; i < arr1.length; i++) {
            String tmp = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            while (tmp.length() < n) {
                tmp = "0" + tmp;
            }
            
            tmp = tmp.replaceAll("1","#");
            tmp = tmp.replaceAll("0"," ");
            ans[i] = tmp;
        }
        
        return ans;
    }
}