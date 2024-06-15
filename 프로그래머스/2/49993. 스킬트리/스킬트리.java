import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {

        Map<String, Integer> skillBook = new HashMap<>();

        int I = 1;
        for(char singleSkill : skill.toCharArray()) {
            String s = String.valueOf(singleSkill);
            skillBook.put(s,I);
            I++;
        }

        int answer = 0;

        for (String skillTree : skill_trees) {
            int checkFlag  = 1;
            boolean correct = true;
            for (char checkSkill : skillTree.toCharArray()) {
                String s = String.valueOf(checkSkill);

                if(skillBook.containsKey(s)) {
                    if(skillBook.get(s) == checkFlag) {
                        checkFlag++;
                    }else {
                        correct = false;
                        break;
                    }
                }
            }
            if(correct) {
                answer++;
            }
        }

        return answer;
    }
}