//https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer,Integer> mp =new HashMap<>();
        int maxi=0;
       mp.put(0,-1);
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            
            int rem=sum-k;
            if(mp.containsKey(rem)){
                int len =i-mp.get(rem);
                maxi=Math.max(maxi,len);
            }
            
                if(!mp.containsKey(sum)){
                    mp.put(sum,i);
                }
            
        }
        
        return maxi;
    }
}
