//https://leetcode.com/problems/word-subsets/?envType=daily-question&envId=2025-01-10
// Time Complexity- O(n+m)
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        HashMap<Character,Integer> mega=new HashMap<>();
      

            for(int i=0;i<words2.length;i++){ //O(n)
            HashMap<Character,Integer> mp =new HashMap<>();
               
              for(char ch:words2[i].toCharArray()){ //O(1)
                mp.put(ch,mp.getOrDefault(ch,0)+1);
              }
              
              for(char ch:mp.keySet()){ //O(1)
                if(mega.containsKey(ch)){
                    mega.put(ch,Math.max(mega.get(ch),mp.get(ch)));
                }else{
                    mega.put(ch,mp.get(ch));
                }
              }

             
        }

        List<String> ans =new ArrayList<>();

        for(int i=0;i<words1.length;i++){ //O(n)
            HashMap<Character,Integer> mp =new HashMap<>();
               
              for(char ch:words1[i].toCharArray()){
                mp.put(ch,mp.getOrDefault(ch,0)+1);
              }


          boolean flag=true;
          for(char ch:mega.keySet()){
            if(!(mp.containsKey(ch) && (mp.get(ch)>= mega.get(ch)))){
                  flag=false;
                  break;
            }
          }

          if(flag){
            ans.add(words1[i]);
          }
        }
         
      return ans;
    }
}
