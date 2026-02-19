//https://leetcode.com/problems/count-binary-substrings/?envType=daily-question&envId=2026-02-19
class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int count = 0;

        int ones = 0;
        int zeroes = 0;
        int l=0;

        for (int r = 0; r < n; r++) {

            if (s.charAt(r) == '0')
                zeroes++;
            else
                ones++;

            if (ones == zeroes) {
                int ans=ones;
                count += ans;
                   System.out.println(l+" "+r+" "+ans);
            }

            if (r + 1 < n && s.charAt(l) != s.charAt(r) && s.charAt(r) != s.charAt(r + 1)) {

                while (l <= r && s.charAt(l) != s.charAt(r)) {

                    if (s.charAt(l) == '1')
                        ones--;
                    else
                        zeroes--;

                    if (ones == zeroes) {
                       
                        System.out.println(l+" "+r+" "+ones);
                        count += ones;
                    }

                    l++;
                }
            }
        }

         while (l < n) {

                    if (s.charAt(l) == '1')
                        ones--;
                    else
                        zeroes--;

                    if (ones == zeroes) {
                       
                       
                        count += ones;
                    }

                    l++;
                }

        return count;
    }
}
