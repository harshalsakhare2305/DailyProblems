//https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
class Solution {
    public void helper(int mask,String s,String str,HashSet<String>st){
        if(Integer.bitCount(mask)==s.length()){
            st.add(str);
            return ;
        }
        
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if( (mask & (1<< i)) == 0 ){
                helper((mask | (1<<i)),s,str+ch,st);
            }
        }
        
        
    }
    public ArrayList<String> findPermutation(String s) {
        
        HashSet<String> st =new HashSet<>();
        helper(0,s,"",st);
        
        ArrayList<String> ans =new ArrayList<>(st);
        
        return ans;
    }
}
