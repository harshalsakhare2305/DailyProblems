//https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/?envType=daily-question&envId=2025-02-03
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n =nums.length;
        if(n==1) return 1;
        int[] dp =new int[n];
        Arrays.fill(dp,1);
        int maxi=0;
        
        for(int i=1;i<n;i++){
           if(nums[i]>nums[i-1] && dp[i]<dp[i-1]+1){
              dp[i]=dp[i-1]+1;
           }

           maxi=Math.max(maxi,dp[i]);
        }

          int[] dp1 =new int[n];
        Arrays.fill(dp1,1);
          for(int i=n-2;i>=0;i--){
           if(nums[i]>nums[i+1] && dp1[i]<dp1[i+1]+1){
              dp1[i]=dp1[i+1]+1;
           }

           maxi=Math.max(maxi,dp1[i]);
        }

        return maxi;
    }

}
