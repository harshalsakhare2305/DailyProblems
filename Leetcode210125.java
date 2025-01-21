//https://leetcode.com/problems/grid-game/
class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] prefixTop = new long[n];
        long[] prefixBottom = new long[n];
        
        // Compute prefix sums for both rows
        prefixTop[0] = grid[0][0];
        prefixBottom[0] = grid[1][0];
        for (int i = 1; i < n; i++) {
            prefixTop[i] = prefixTop[i - 1] + grid[0][i];
            prefixBottom[i] = prefixBottom[i - 1] + grid[1][i];
        }
        
        long result = Long.MAX_VALUE;
        
        // Evaluate the maximum score the second player can guarantee
        for (int i = 0; i < n; i++) {
            long top = (i + 1 < n) ? prefixTop[n - 1] - prefixTop[i] : 0; // Remaining top row
            long bottom = (i - 1 >= 0) ? prefixBottom[i - 1] : 0;         // Collected bottom row
            long secondPlayerScore = Math.max(top, bottom);              // Worst-case for second player
            result = Math.min(result, secondPlayerScore);                // Minimize second player's max
        }
        
        return result;
    }
}
