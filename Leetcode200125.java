//https://leetcode.com/problems/first-completely-painted-row-or-column/

//Brute with Optimization
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
    

        HashMap<Integer,int[]> mp =new HashMap<>();

         int[] countrow =new int[mat.length];
         int[] countcol =new int[mat[0].length];

         for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
             
                mp.put(mat[i][j],new int[]{i,j});
            }
         }

         for(int i=0;i<arr.length;i++){
             int r =mp.get(arr[i])[0];
             int c =mp.get(arr[i])[1];

             countrow[r]++;
             countcol[c]++;
             if(countrow[r]==mat[0].length || countcol[c]==mat.length){
                return i;
             }
         }

         return 0;


    }
}

// ----------------------------------------------------------------------------------------------

//Optimal Solution

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer,Integer> mp =new HashMap<>();
        for(int i=0;i<arr.length;i++){
             mp.put(arr[i],i);
        }


    
    int min=Integer.MAX_VALUE;
        for(int i=0;i<mat.length;i++){
             int rowtime =Integer.MIN_VALUE;
            for(int j=0;j<mat[0].length;j++){
                rowtime=Math.max(rowtime,mp.get(mat[i][j]));
            }

            min=Math.min(min,rowtime);
        }

          for(int i=0;i<mat[0].length;i++){
             int coltime =Integer.MIN_VALUE;
            for(int j=0;j<mat.length;j++){
                coltime=Math.max(coltime,mp.get(mat[j][i]));
            }

            min=Math.min(min,coltime);
        }


        return min;

    }
}
