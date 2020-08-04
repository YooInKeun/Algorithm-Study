import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> participantMap = new HashMap<String, Integer>();
        
        for (String person : participant) {
            if (participantMap.get(person) == null) {
                participantMap.put(person, 1);
            } else {
                participantMap.put(person, participantMap.get(person) + 1);
            }
        }

        for (String completionPerson : completion) {
            participantMap.put(completionPerson, participantMap.get(completionPerson) - 1);
        }
        
        for (String key : participantMap.keySet()) {
            if (participantMap.get(key) == 1) {
                answer = key;
            }
        }
        return answer;
    }
}
