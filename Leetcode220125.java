//https://leetcode.com/problems/map-of-highest-peak/?envType=daily-question&envId=2025-01-22
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m =isWater.length;
        int n =isWater[0].length;
        int[][] ans =new int[m][n];
        for(int[] arr:ans){
            Arrays.fill(arr,-1);
        }

        Queue<int[]> q =new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    ans[i][j]=0;
                    q.add(new int[]{i,j});
                }
            }
        }
     int[] drow ={-1,0,1,0};
     int[] dcol={0,1,0,-1};
        while(!q.isEmpty()){
            int[] curr =q.poll();
            int r= curr[0];
            int c =curr[1];

            for(int i=0;i<4;i++){
                int nr =r +drow[i];
                int nc =c +dcol[i];

                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    if(ans[nr][nc]==-1){
                        ans[nr][nc]=ans[r][c]+1;
                          q.add(new int[]{nr,nc});
                    }else{
                        if(ans[nr][nc]>(ans[r][c]+1)){
                            ans[nr][nc]=ans[r][c]+1;
                            q.add(new int[]{nr,nc});
                        }
                    }

                  
                }
            }
        }

        return ans;
    }
}
