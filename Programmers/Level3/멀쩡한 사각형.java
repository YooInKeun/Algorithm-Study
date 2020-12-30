class Solution {
    public long solution(int w, int h) {
        int gcd = getGreatestCommonDivisor(w, h);
        int cutSquareCount = (w / gcd) + (h / gcd) - 1;
        int totalCutSquareCount = cutSquareCount * gcd;
        long answer = w * h - totalCutSquareCount;
        return answer;
    }
    
    public static int getGreatestCommonDivisor(int a, int b) {
        int bigger = Math.min(a, b);
        while (bigger != 1) {
            if (a % bigger == 0 && b % bigger == 0) {
                break;
            }
            bigger--;
        }
        return bigger;
    }
}
