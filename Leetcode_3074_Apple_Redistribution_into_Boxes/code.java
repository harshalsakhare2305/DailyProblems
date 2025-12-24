//https://leetcode.com/problems/apple-redistribution-into-boxes/?envType=daily-question&envId=2025-12-24
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int appleTotal =0;

        for(int i:apple){
            appleTotal+=i;
        }

        Arrays.sort(capacity);
        int sum=0;
        int j=0;
      for(int i=capacity.length-1;i>=0;i--){
        sum+=capacity[i];
        j++;
        if(sum>=appleTotal){
            return j;
        }
      }

        return -1;
    }
}
