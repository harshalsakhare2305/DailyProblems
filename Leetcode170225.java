//https://leetcode.com/problems/letter-tile-possibilities/
class Solution {
      int count=0;
    public void helper(int[]freq){
        for(int i=0;i<26;i++){
            if(freq[i]==0)continue;

            freq[i]--;
            helper(freq);
            freq[i]++;

        }

         count++;
    }
    public int numTilePossibilities(String tiles) {
        int[] freq =new int[26];
        for(char ch:tiles.toCharArray()){
            freq[ch-'A']++;
        }

        helper(freq);
        return count-1;
    }
}
