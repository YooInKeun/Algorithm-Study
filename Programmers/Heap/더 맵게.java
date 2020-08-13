import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int next = 0;
        List<Integer> scovilleList = new ArrayList<>();
        for (int s : scoville) {
            scovilleList.add(s);
        }
        
        while(next < K && scovilleList.size() >= 2) {
            next = scovilleList.get(0) + scovilleList.get(1) * 2;
            scovilleList.remove(0);
            scovilleList.remove(1);
            boolean flag = true;
            for (int i = 0; i < scovilleList.size() && flag; i++) {
                if (scovilleList.get(i) <= next) {
                    scovilleList.add(i + 1, next);
                    flag = false;
                }
            }
            answer++;
            
            if (scovilleList.size() < 2) {
                answer = -1;
            }
        }
        
        return answer;
    }
}
