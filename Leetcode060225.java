
//https://leetcode.com/problems/tuple-with-same-product/
class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> mp =new HashMap<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(i!=j){
                    int prod =nums[i]*nums[j];
                    mp.put(prod,mp.getOrDefault(prod,0)+1);
                }
            }
        }

        int sum=0;

        for(int i:mp.values()){
            if(i>=2){
                int fact =((i-1)*i)/2;
                sum+=(fact*8);
            }
        }

        return sum;
    }
}
