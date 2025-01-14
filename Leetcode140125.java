//https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/?envType=daily-question&envId=2025-01-14
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> st =new HashSet<>();
        int n =A.length;
        int[] ans =new int[n];        
        int count=0;
        for(int i=0;i<n;i++){
            if(!st.contains(A[i])){
                st.add(A[i]);
            }else{
                count++;
            }

            if(!st.contains(B[i])){
                st.add(B[i]);
            }else{
                count++;
            }

            ans[i]=count;
        }

        return ans;
    }
}
