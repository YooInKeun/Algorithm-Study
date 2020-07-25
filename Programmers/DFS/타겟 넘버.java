import java.util.*;

class Solution {
    int target = 0;
    int answer = 0;
    int[] numbers;
    int[] minusNumbers;
    
    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;
        
        int numbersLength = numbers.length;
        int[] visited = new int[numbersLength];
        this.minusNumbers = new int[numbersLength];
        
        // 마이너스 적용한 배열 생성
        for (int i = 0; i < numbersLength; i++) {
            minusNumbers[i] = -numbers[i];
        }
        
        // 조합 구하기
        for (int i = 0; i <= numbersLength; i++) {
            this.combination(visited, 0, i);
        }
        
        return this.answer;
    }
    
    public void combination(int[] visited, int start, int r) {
        if (r == 0) {
            // 최종으로 계산하는 배열
            int[] calcNumbers = new int[visited.length];
            for (int i = 0; i < visited.length; i++) {
                calcNumbers[i] = (visited[i] == 0) ? numbers[i] : minusNumbers[i];
            }
            
            int sum = this.calcSum(calcNumbers);
            if (sum == this.target) {
                this.answer++;
            }
            return ;
        }
        
        for (int i = start; i < visited.length; i++) {
            visited[i] = 1;
            combination(visited, i + 1, r - 1);
            visited[i] = 0;
        }
    }
    
    // 합 구하는 함수
    public int calcSum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
