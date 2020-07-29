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
            answer.append(Integer.toString(num));
            n -= num * divider;
            divider /= 3;
        }
        
        
        return answer.toString().replaceAll("3", "4");
    }
}
