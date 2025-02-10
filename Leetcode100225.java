//https://leetcode.com/problems/clear-digits/?envType=daily-question&envId=2025-02-10
class Solution {
    public String clearDigits(String s) {
        int n=s.length();
        Stack<Character> st =new Stack<>();
        for(int i=0;i<n;i++){
            int ascii =(int)s.charAt(i);
            if(ascii>=48 && ascii<=57){
                if(st.size()!=0){
                    st.pop();
                }
            }else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb =new StringBuilder("");
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        sb.reverse();
        
        return sb.toString();
    }
}
