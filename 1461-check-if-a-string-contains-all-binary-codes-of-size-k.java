//https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/?envType=daily-question&envId=2026-02-23
class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> st =new HashSet<>();
        int n=s.length();

        if(k>n)return false;

        int l=0;
        int r=0;

        while(r<n){

            while(r-l+1>k){
                l++;
            }
              String sub ="";
            if(r<n-1 && r-l+1==k){
                 sub =s.substring(l,r+1);
                 st.add(sub);
            }else if(r-l+1==k){
                sub=s.substring(l);
                st.add(sub);
            }

            

            r++;
        }

        return (st.size() == (1<<k));
    }
}
