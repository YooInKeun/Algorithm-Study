import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] skillCharArray = skill.toCharArray();

        for (String skill_tree : skill_trees) {
            char[] skillTreeCharArray = skill_tree.toCharArray();
            boolean flag = true;
            
            Map<String, Integer> skillMap1 = new HashMap<String, Integer>();
            Map<Integer, String> skillMap2 = new HashMap<Integer, String>();
            Map<String, Boolean> skillMap3 = new HashMap<String, Boolean>();
            for (int i = 0; i < skillCharArray.length; i++) {
                skillMap1.put(Character.toString(skillCharArray[i]), i);
                skillMap2.put(i, Character.toString(skillCharArray[i]));
                skillMap3.put(Character.toString(skillCharArray[i]), false);
            }
            
            for (int i = 0; i < skillTreeCharArray.length; i++) {
                if (skillMap1.containsKey(Character.toString(skillTreeCharArray[i]))) {
                    if (skillMap1.get(Character.toString(skillTreeCharArray[i])) != 0) {
                        if (skillMap3.get(skillMap2.get(skillMap1.get(Character.toString(skillTreeCharArray[i])) - 1)) == false) {
                            flag = false;
                        } else {
                            skillMap3.put(skillMap2.get(skillMap1.get(Character.toString(skillTreeCharArray[i]))), true);
                        }
                    }
                    else {
                        skillMap3.put(Character.toString(skillTreeCharArray[i]), true);
                    }
                }
            }
            
            if (flag == true) {
                answer++;
            }
            flag = false;
        }
        
        return answer;
    }
}
