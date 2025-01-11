//https://leetcode.com/problems/counting-words-with-a-given-prefix/description/?envType=daily-question&envId=2025-01-09
class Solution {
    public int prefixCount(String[] words, String pref) {
        int Count=0;
        int m=pref.length();
        for(int i=0;i<words.length;i++){
            if(m>words[i].length())continue;
            String str=words[i].substring(0,m);
            if(str.equals(pref)){
               Count++;
            }
        }

        return Count++;
    }
}

/*class Solution {

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++; // Found a string with pref as prefix
            }
        }
        return count;
    }
} */
