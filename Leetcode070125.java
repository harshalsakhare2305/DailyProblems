//https://leetcode.com/problems/string-matching-in-an-array/description/?envType=daily-question&envId=2025-01-07
class Solution {
    public int[] getLPS(String word){
        int[] lps =new int[word.length()];
        int length=0;
        lps[0]=0;
        int i=1;
        while(i<word.length()){
            if(word.charAt(i)==word.charAt(length)){
                length++;
                lps[i]=length;
                i++;
            }else{
                if(length!=0){
                    length=lps[length-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }

        return lps;
    }

    public boolean issubstring(String word,String pattern ,int[]lps){ //KMP algorithm
        int i=0;
        int j=0;
        while(i<word.length()){
            if(word.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }else{
               if(j!=0){
                 j=lps[j-1];
               }else{
                i++;
               }
            }

            if(j==pattern.length())return true;
        }

        return false;
    }
    public List<String> stringMatching(String[] words) {
        List<String> ans =new ArrayList<>();
        int count=0;
        for(int i=0;i<words.length;i++){
            int[] lps =getLPS(words[i]);

            for(int j=0;j<words.length;j++){
                if(i==j)continue;
                if(issubstring(words[j],words[i],lps)){
                    ans.add(words[i]);
                    break;
                }
            }
        }

        return ans;
    }
}
