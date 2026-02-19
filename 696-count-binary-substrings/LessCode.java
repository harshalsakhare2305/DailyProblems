class Solution {
    public int countBinarySubstrings(String s) {
        int prev = 0;   // length of previous group
        int curr = 1;   // length of current group
        int ans = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                ans += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }

        ans += Math.min(prev, curr);
        return ans;
    }
}
