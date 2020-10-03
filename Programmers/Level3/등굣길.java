class Solution {
    public static int[][] graph;
    public int solution(int m, int n, int[][] puddles) {
        graph = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = -1;
            }
        }
        
        graph[0][0] = 0;
        for (int i = 1; i < m; i++) {
            graph[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            graph[0][i] = 1;
        }

        for (int i = 0; i < puddles.length; i++) {
            graph[puddles[i][0] - 1][puddles[i][1] - 1] = 0;
            
            if (puddles[i][0] == 1) {
                for (int j = puddles[i][1] - 1; j < n; j++) {
                    graph[0][j] = 0;
                }
            }

            if (puddles[i][1] == 1) {
                for (int j = puddles[i][0] - 1; j < m; j++) {
                    graph[j][0] = 0;
                }
            }
        }

        return getValueOfPosition(new int[]{m - 1, n - 1}) % 1000000007;
    }

        public static int getValueOfPosition(int[] position) {
        for (int i = 1; i <= position[0]; i++) {
            for (int j = 1; j <= position[1]; j++) {
                if (graph[i][j] == -1) {
                    graph[i][j] = graph[i - 1][j] % 1000000007 + graph[i][j - 1] % 1000000007;
                }
            }
        }
        return graph[position[0]][position[1]];
    }
    
//     재귀로 풀기
//     public static int getValueOfPosition(int[] position) {
//         if (graph[position[0]][position[1] - 1] == -1) {
//             graph[position[0]][position[1] - 1] = getValueOfPosition(new int[]{position[0], position[1] - 1});
//         }

//         if (graph[position[0] - 1][position[1]] == -1) {
//             graph[position[0] - 1][position[1]] = getValueOfPosition(new int[]{position[0] - 1, position[1]});
//         }

//         return graph[position[0] - 1][position[1]] + graph[position[0]][position[1] - 1];
//     }
}
