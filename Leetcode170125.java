//https://leetcode.com/problems/neighboring-bitwise-xor/?envType=daily-question&envId=2025-01-17
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n=derived.length;
        // int xor=0;
        // for(int i=0;i<n;i++){
        //    xor^=derived[i];
        // }

        // return xor==0;

        int[] original = new int[n+1];
        original[0]=0;
        for(int i=1;i<n+1;i++){
            original[i]=derived[i-1]^original[i-1];
        }

        boolean checkzero =original[0]==original[n];

         int[] original2 = new int[n+1];
        original[0]=1;
        for(int i=1;i<n+1;i++){
            original2[i]=derived[i-1]^original2[i-1];
        }

        boolean checkone =original2[0]==original2[n];

        return checkzero || checkone;
    }
}
