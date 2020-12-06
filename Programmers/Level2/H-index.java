import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int num = citations[citations.length - 1];
        
        for (int i = citations.length - 1; i > 0; i--) {
            if (num <= citations.length - i && num >= i) {
                return num;
            } else {
                if (num > citations[i - 1]) {
                    num--;
                    i++;
                } else {
                    num = citations[i - 1];
                }
            }
        }
        return 0;
    }
}
