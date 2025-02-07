//https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/?envType=daily-question&envId=2025-02-07
import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] ans = new int[queries.length];
        HashMap<Integer, Integer> colorCount = new HashMap<>();
        HashMap<Integer, Integer> colorMap = new HashMap<>();  

        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int cl = queries[i][1];

           
            if (colorMap.containsKey(idx)) {
                int prevColor = colorMap.get(idx);
                colorCount.put(prevColor, colorCount.get(prevColor) - 1);
                if (colorCount.get(prevColor) == 0) {
                    colorCount.remove(prevColor);
                }
            }

           
            colorMap.put(idx, cl);
            colorCount.put(cl, colorCount.getOrDefault(cl, 0) + 1);

          
            ans[i] = colorCount.size();
        }

        return ans;
    }
}
