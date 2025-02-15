//https://leetcode.com/problems/find-the-punishment-number-of-an-integer/?envType=daily-question&envId=2025-02-15

class Solution {
    public boolean isPossible(String num, int target) {
        if (num.isEmpty()) {
            return target == 0;
        }

        for (int i = 0; i < Math.min(4, num.length()); i++) {
            String str = num.substring(0, i + 1);
            int n = Integer.parseInt(str);
            String remain = num.substring(i + 1);
            if (n <= target && isPossible(remain, target - n)) {
                return true;  // Return immediately if valid partition is found
            }
        }
        return false;
    }

    public int punishmentNumber(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            String sq = String.valueOf(square);
            if (isPossible(sq, i)) {
                count += square;
            }
        }
        return count;
    }
}


import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isPossible(String num, int target) {
        String key = num + "-" + target;  // Unique key for memoization
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (num.isEmpty()) {
            return target == 0;
        }

        for (int i = 0; i < Math.min(4, num.length()); i++) {
            String str = num.substring(0, i + 1);
            int n = Integer.parseInt(str);
            String remain = num.substring(i + 1);
            if (n <= target && isPossible(remain, target - n)) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    public int punishmentNumber(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            String sq = String.valueOf(square);
            if (isPossible(sq, i)) {
                count += square;
            }
        }
        return count;
    }
}
