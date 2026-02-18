//https://leetcode.com/problems/binary-number-with-alternating-bits/description/?envType=daily-question&envId=2026-02-18
class Solution {
    public boolean hasAlternatingBits(int n) {
        while(n != 0){
            int lastBit = n & 1;
            int lastPrev = (n >> 1) & 1;
            if((lastBit ^ lastPrev) == 0) return false;
            n = n >> 1;
        }
        return true;
    }
}
