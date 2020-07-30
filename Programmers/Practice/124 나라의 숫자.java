import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuffer answer = new StringBuffer();
        
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        while (n / 3 != 0) {
            stack.push((n % 3));
            n /= 3;
        }
        stack.push(n);
        
        while (!stack.empty()) {
            String numStr = String.valueOf(stack.pop());
            answer.append(numStr);
        }
        
        while (answer.indexOf("0") > -1) {
            int pos = answer.indexOf("10");
            if (pos > -1) {
                answer.replace(pos, pos + 2, "04");
                if (answer.indexOf("0") == 0) {
                    answer.replace(0, 1, "");
                }
            }
            
            pos = answer.indexOf("20");
            if (pos > -1) {
                answer.replace(pos, pos + 2, "14");
            }
            
            pos = answer.indexOf("40");
            if (pos > -1) {
                answer.replace(pos, pos + 2, "24");                
            }
        }
            
        return answer.toString();
    }
}
