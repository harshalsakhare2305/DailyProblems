//https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
       int r=0;int ss=0;
        for(int i=0;i<arr.length;i++)
        {
            r+=arr[i];
        }
        for(int i=0;i<arr.length;i++)
        {
            int ps=r-arr[i]-ss;
            if (ps==ss)
            {
                return i;
            }
            ss+=arr[i];
        }
        
        
        
        return -1;
        
    }
}
