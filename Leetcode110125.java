//https://leetcode.com/problems/construct-k-palindrome-strings/

class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()<k)return false;
        HashMap<Character,Integer>mp =new HashMap<>();


        for(char ch:s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        
        int oddCount=0;
        for(int i:mp.values()){
            if(i%2!=0)oddCount++;
        }

        if(oddCount>k){
            return false;
        }

        return true;

    }
}
