//https://leetcode.com/problems/two-best-non-overlapping-events/submissions/1863329344/?envType=daily-question&envId=2025-12-23
class Solution {
    public int BinarySearch(int target,int[][]events){
        int low=0;
        int high=events.length-1;

        int ans=events.length;

        while(low<=high){
            int mid=(low+high)/2;

            if(events[mid][0]>target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;

    }
     
     int[][] dp;

    public int helper(int idx,int count,int[][]events){
        if(idx>=events.length)return 0;

        if(dp[idx][count]!=-1)return dp[idx][count];
         
         int nextidx =BinarySearch(events[idx][1],events);
        int take =0;
        if(count<2){
           take=events[idx][2]+helper(nextidx,count+1,events);
        }

        int ntake=helper(idx+1,count,events);

        return dp[idx][count]=Math.max(take,ntake);
    }
    public int maxTwoEvents(int[][] events) {
        int n =events.length;

        Arrays.sort(events,new Comparator<int[]>(){
            public int compare(int[]a,int[]b){
                return (a[0]==b[0])?(a[1]-b[1]):(a[0]-b[0]);
            }
        });

        dp =new int[n+1][3];

        for(int[]r:dp){
            Arrays.fill(r,-1);
        }

        return helper(0,0,events);

       
    }
}
