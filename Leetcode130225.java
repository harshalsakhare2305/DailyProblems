//https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/?envType=daily-question&envId=2025-02-13
class Solution {
    public int minOperations(int[] nums, int k) {
        int n =nums.length;
        
        PriorityQueue<Long> pq =new PriorityQueue<>();

        for(int i:nums){
          pq.add(i * 1L);
        }
        int ans =0;
        while(pq.peek()<k){
            long first =pq.poll();
            long second =pq.poll();
            ans++;
            long temp =first*2+second;
            pq.add(temp);
            
        }

    
     return ans;
    }
}
