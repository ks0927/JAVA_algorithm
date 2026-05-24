import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        List<int[]> tmp = new ArrayList<>();
        
        int idx = -1;
        if(ext.equals("code")) idx = 0;
        if(ext.equals("date")) idx = 1;
        if(ext.equals("maximum")) idx = 2;
        if(ext.equals("remain")) idx = 3;

        
        for(int i=0; i < data.length; i++) {
            if(data[i][idx] < val_ext) {
                tmp.add(new int[] {data[i][0],data[i][1],data[i][2],data[i][3]});    
            }
        }
        
        int sortIdx = -1;
        if(sort_by.equals("code")) sortIdx = 0;
        if(sort_by.equals("date")) sortIdx = 1;
        if(sort_by.equals("maximum")) sortIdx = 2;
        if(sort_by.equals("remain")) sortIdx = 3;
        
        final int finalSortIdx = sortIdx;
        tmp.sort((a, b) -> Integer.compare(a[finalSortIdx], b[finalSortIdx]));
        
        answer = tmp.toArray(new int[0][]);
        
        return answer;
    }
}