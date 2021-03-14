import java.util.*;

class Solution {
    
    private static final Map<String, Integer> combinationMap = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                boolean[] visited = new boolean[orders[j].length()];
                combination(orders[j].toCharArray(), visited, 0, orders[j].length(), course[i]);
            }
        }

        List<String> answerList = new ArrayList<>();
        for (String key : combinationMap.keySet()) {
            if (combinationMap.get(key) >= 2) {
                answerList.add(key);
            }
        }
        Collections.sort(answerList);
        return answerList.toArray(new String[answerList.size()]);
    }
    
    public static void combination(char[] orderArr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            updateCombinationMap(orderArr, visited, n);
            return;
        }
        
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(orderArr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
    
    public static void updateCombinationMap(char[] orderArr, boolean[] visited, int n) {
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                charList.add(orderArr[i]);
            }
        }
        Collections.sort(charList);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charList.size(); i++) {
            sb.append(charList.get(i));            
        }

        String courseMenu = sb.toString();
        if (combinationMap.get(courseMenu) == null) {
            combinationMap.put(courseMenu, 1);
        } else {
            combinationMap.put(courseMenu, combinationMap.get(courseMenu) + 1);
        }
    }
}
