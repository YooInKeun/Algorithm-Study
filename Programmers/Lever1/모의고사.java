import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int answerCnt1 = 0;
        int answerCnt2 = 0;
        int answerCnt3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % 5]) {
                answerCnt1++;
            }
            if (answers[i] == person2[i % 8]) {
                answerCnt2++;
            }
            if (answers[i] == person3[i % 10]) {
                answerCnt3++;
            }
        }
        
        // 다음에는 Max 함수 활용하자
        List<Integer> answerList = new ArrayList<Integer>();
        if (answerCnt1 > answerCnt2 && answerCnt1 > answerCnt3) {
            answerList.add(1);
        }
        else if (answerCnt2 > answerCnt1 && answerCnt2 > answerCnt3) {
            answerList.add(2);
        }
        else if (answerCnt3 > answerCnt1 && answerCnt3 > answerCnt2) {
            answerList.add(3);
        }
        else if (answerCnt1 == answerCnt2 && answerCnt1 > answerCnt3) {
            answerList.add(1);
            answerList.add(2);
        }
        else if (answerCnt1 == answerCnt3 && answerCnt1 > answerCnt2) {
            answerList.add(1);
            answerList.add(3);
        }
        else if (answerCnt2 == answerCnt3 && answerCnt2 > answerCnt1) {
            answerList.add(2);
            answerList.add(3);
        }
        else if (answerCnt1 == answerCnt2 && answerCnt1 == answerCnt3) {
            answerList.add(1);
            answerList.add(2);
            answerList.add(3);
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
