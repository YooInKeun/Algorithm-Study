class Solution {
    public String solution(int n) {
        StringBuffer answer = new StringBuffer();

        int divider = 1;
        while (n / divider != 0) {
            divider *= 3;
        }
        divider /= 3;

        if (n % divider == 0 && divider != 1) {
            divider /= 3;
        }

        while (divider > 0) {
            int num = (n / divider);
            int appendedNum = num;
            if (num == 3) {
                appendedNum = 4;
            }
            answer.append(appendedNum);
            n -= num * divider;
            divider /= 3;
        }

        while (answer.indexOf("0") > -1) {
            int pos = answer.indexOf("10");
            if (pos > -1) {
                answer.replace(pos, pos + 2, "04");
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
