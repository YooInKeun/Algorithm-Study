import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
                
        int truckSize = truck_weights.length;
        int truckCount = 0;
        
        int[] lengthList = new int[truckSize];
        for (int i = 0; i < truckSize; i++) {
            lengthList[i] = bridge_length;
        }
        
        int waitingIndex = 0;
        int waitingTruckWeight = truck_weights[waitingIndex];
        weight -= waitingTruckWeight;
        lengthList[waitingIndex]--;
        answer++;
        waitingIndex++;
        
        while (truckCount != truckSize) {
            if (waitingIndex < truckSize) {
                waitingTruckWeight = truck_weights[waitingIndex];
                
                // 다리 무게 감당할 수 있는지 체크 후, 감당할 수 있으면 대기 순번 다음번 인덱스로 변경
                if (waitingTruckWeight <= weight) {
                    weight -= waitingTruckWeight;
                    waitingIndex++;
                }
            }
            
            // lengthList 값이 0이면 모두 통과한 차량
            for (int i = 0; i < waitingIndex; i++) {
                lengthList[i]--;
                
                if (lengthList[i] == 0) {
                    weight += truck_weights[i];
                    truckCount++;
                }
            }
            answer++;        
        }
        // 마지막 차량 마무리
        answer++;
        
        return answer;
    }
}
