//https://leetcode.com/problems/bitwise-xor-of-all-pairings/?envType=daily-question&envId=2025-01-16
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1=0;
        int xor2=0;
        int n=nums1.length;
        int m=nums2.length;
        for(int i=0;i<n;i++){
            xor1^=nums1[i];
        }

         for(int i=0;i<m;i++){
            xor2^=nums2[i];
        }

       int bit1= (n & 1);
       int bit2 =(m & 1);

       if(bit2==0 && bit1==1)return xor2;
       else if(bit2==0 && bit1==0)return 0;
       else if(bit2==1 && bit1==1)return (xor1^xor2);
       else return xor1;
    }
}
