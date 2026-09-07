import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0) return cities.length*5;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();

            // Cache Hit
            if (map.containsKey(city)) {
                map.put(city, i);
                answer += 1;

            // Cache Miss
            } else {
                // 캐시가 꽉 찼다면 가장 오래된 index 제거
                if (map.size() >= cacheSize) {

                    String oldestCity = null;
                    int oldestIndex = Integer.MAX_VALUE;

                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        if (entry.getValue() < oldestIndex) {
                            oldestIndex = entry.getValue();
                            oldestCity = entry.getKey();
                        }
                    }

                    map.remove(oldestCity);
                }

                map.put(city, i);
                answer += 5;
            }
        }

        return answer;
    }
}