//https://leetcode.com/problems/champagne-tower/?envType=daily-question&envId=2026-02-14

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        double[][] dp =new double[query_row+1][query_row+1];
         
        dp[0][0]=poured*1.0;

        for(int i=1;i<=query_row;i++){
            for(int j=0;j<=i;j++){

            double val=0;

            if(i>0 && j>0){
                val+=Math.max(0,(dp[i-1][j-1]-1)/2.0);
            }

            if(i>0 && j<query_row){
                val+=Math.max(0,(dp[i-1][j]-1)/2.0);
            }

            dp[i][j]+=val;

            }
        }

        return dp[query_row][query_glass]>=1.0?1.0:dp[query_row][query_glass];



    }
}
