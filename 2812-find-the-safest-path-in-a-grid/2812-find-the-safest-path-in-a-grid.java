import java.util.*;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] d : dirs) {
                int ni = curr[0] + d[0], nj = curr[1] + d[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && dist[ni][nj] == -1) {
                    dist[ni][nj] = dist[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.offer(new int[]{0, 0, dist[0][0]});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], safeness = curr[2];
            
            if (r == n - 1 && c == n - 1) return safeness;
            
            for (int[] d : dirs) {
                int ni = r + d[0], nj = c + d[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    pq.offer(new int[]{ni, nj, Math.min(safeness, dist[ni][nj])});
                }
            }
        }
        return 0;
    }
}