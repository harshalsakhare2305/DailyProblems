//https://leetcode.com/problems/trapping-rain-water-ii/?envType=daily-question&envId=2025-01-19
class Solution {
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->a[2]-b[2]);
        int water=0;
        int m=heightMap.length;
        int n=heightMap[0].length;
        boolean[][] vis =new boolean[m][n];
        for(int i=0;i<n;i++){
            pq.add(new int[]{0,i,heightMap[0][i]});
            vis[0][i]=true;
        }
         for(int i=0;i<n;i++){
            pq.add(new int[]{m-1,i,heightMap[m-1][i]});
            vis[m-1][i]=true;
        }

        for(int i=0;i<m;i++){
            pq.add(new int[]{i,0,heightMap[i][0]});
            vis[i][0]=true;
        }

        for(int i=0;i<m;i++){
            pq.add(new int[]{i,n-1,heightMap[i][n-1]});
            vis[i][n-1]=true;
        }
       int[] drow ={-1,0,1,0};
       int[] dcol ={0,1,0,-1};
        while(!pq.isEmpty()){
            int[] temp =pq.poll();
            int r =temp[0];
            int c =temp[1];
            int val =temp[2];

            for(int k=0;k<4;k++){
                int nr =r+drow[k];
                int nc =c +dcol[k];
                if(nr>=0 && nc>=0 && nr<m && nc<n && !vis[nr][nc]){
                    water+=Math.max(val-heightMap[nr][nc],0);
                    pq.add(new int[]{nr,nc,Math.max(val,heightMap[nr][nc])});
                    vis[nr][nc]=true;
                }
            }
        }

        return water;
    }
}
