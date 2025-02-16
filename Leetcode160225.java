//https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/?envType=daily-question&envId=2025-02-16
import java.util.*;

class Solution {
    int num;

    public boolean helper(int idx, boolean[] vis, int len, int[] ans) {
        // Move to next empty index if already filled
        while (idx < len && ans[idx] != -1) idx++;

        if (idx == len) return true; // Successfully placed all numbers

        for (int i = num; i >= 1; i--) {
            if (vis[i]) continue;

            if (i == 1) { // Special case for 1 (single placement)
                ans[idx] = i;
                vis[i] = true;
                if (helper(idx + 1, vis, len, ans)) return true;
                ans[idx] = -1;
                vis[i] = false;
            } else {
                int j = idx + i;
                if (j < len && ans[j] == -1) { // Check bounds
                    ans[idx] = ans[j] = i;
                    vis[i] = true;

                    if (helper(idx + 1, vis, len, ans)) return true;

                    // Undo (backtrack)
                    ans[idx] = ans[j] = -1;
                    vis[i] = false;
                }
            }
        }
        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int len = 2 * n - 1;
        int[] ans = new int[len];
        num = n;
        Arrays.fill(ans, -1);
        boolean[] vis = new boolean[n + 1];

        helper(0, vis, len, ans);
        return ans;
    }
}
