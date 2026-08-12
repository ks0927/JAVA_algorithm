import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
            
        Set<String> noSpoiler = new HashSet<>();
        Set<String> Spoiler = new HashSet<>();
        
        int currentIndex = 0;
        for(String word : message.split(" ")) {
            int startIndex = message.indexOf(word,currentIndex);
            int endIndex = startIndex+word.length() -1;
            currentIndex = endIndex+1;
            
            boolean isSpoiler = false;
            for(int[] range : spoiler_ranges) {
                if(startIndex <= range[1] && endIndex >= range[0]) {
                    Spoiler.add(word);
                    isSpoiler = true;
                    break;
                }
            }
            
            if(!isSpoiler) noSpoiler.add(word);
            
        }
        
        Set<String> important = new HashSet<>();
        
        for(String sp : Spoiler) {
            if(!noSpoiler.contains(sp) && !important.contains(sp)) {
                important.add(sp);
            }
        }
        
        return important.size();
    }
}