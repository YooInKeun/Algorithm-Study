import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 1;
        int currentLimit = limit;
        Arrays.sort(people);
        
        for (int person : people) {
            if (currentLimit >= person) {
                currentLimit -= person;
            } else {
                currentLimit = limit;
                currentLimit -= person;
                answer++;
            }
        }
        
        return answer;
    }
}
