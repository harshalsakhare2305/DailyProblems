//https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/
import java.util.PriorityQueue;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});

        int[] drow = {0, 0, 0, 1, -1};
        int[] dcol = {0, 1, -1, 0, 0};

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int i = temp[0];
            int j = temp[1];
            int cost = temp[2];

            if (vis[i][j]) continue;  // Skip if already visited
            vis[i][j] = true;

            if (i == m - 1 && j == n - 1) return cost;  // Reached destination

            // Move in the direction of the arrow with no cost
            int nr = i, nc = j;
            if (grid[i][j] == 1) nc = j + 1;
            else if (grid[i][j] == 2) nc = j - 1;
            else if (grid[i][j] == 3) nr = i + 1;
            else if (grid[i][j] == 4) nr = i - 1;

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc]) {
                pq.add(new int[]{nr, nc, cost});
            }

            // Explore all other directions with additional cost
            for (int k = 1; k <= 4; k++) {
                nr = i + drow[k];
                nc = j + dcol[k];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc]) {
                    pq.add(new int[]{nr, nc, cost + 1});
                }
            }
        }

        return 0;  // Should not reach here
    }
}
