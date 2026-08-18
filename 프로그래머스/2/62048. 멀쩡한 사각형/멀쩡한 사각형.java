import java.util.*;
import java.math.*;

class Solution {
    public long solution(int w, int h) {
        
        BigInteger a = BigInteger.valueOf(w);
        BigInteger b = BigInteger.valueOf(h);
        int gcd = a.gcd(b).intValue();
        
        long answer = (long)w * (long)h - (w + h - gcd);
        return answer;
    }
}