//https://www.geeksforgeeks.org/problems/subarrays-with-sum-k/1
class Solution {
    public int countSubarrays(int arr[], int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int ans=0, cur=0;
        for(int i:arr){
            cur+=i;
            if(map.containsKey(cur-k))  ans+=map.get(cur-k);
            map.merge(cur,1,Integer::sum);
        }
        return ans;
    }
}
