import java.util.*;

class Solution {
    
    private static int BIG_NUM = 1000;
    private static int MIN_NUM = 40;
    
    public int solution(int[] people, int limit) {
        int answer = 0;
        int currentLimit = limit;
        Arrays.sort(people);
        
        for (int i = people.length - 1; i >= 0; i--) {
            if (people[i] >= BIG_NUM) {
                continue;
            }
            currentLimit -= people[i];
            answer++;
            
            for (int j = 0; j < i; j++) {
                if (currentLimit < MIN_NUM) {
                    break;
                }
                
                if (currentLimit >= people[j]) {
                    currentLimit -= people[j];
                    people[j] = BIG_NUM;
                    
                    if (currentLimit < MIN_NUM) {
                        break;
                    }
                }
            }
            
            currentLimit = limit;
        }
        
        return answer;
    }
}
