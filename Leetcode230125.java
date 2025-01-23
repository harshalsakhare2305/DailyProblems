
//https://leetcode.com/problems/count-servers-that-communicate/
class Solution {
    public int countServers(int[][] grid) {
        int[] row =new int[grid.length];
        int[] col =new int[grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int count=0;
       for(int i:row){
        if(i>1)count+=i;
       }

         for(int i:col){
        if(i>1)count+=i;
       }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && (row[i]>1 && col[j]>1)){
                      count--;
                }
            }
        }

        return count;
    }
}
