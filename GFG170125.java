//https://www.geeksforgeeks.org/problems/product-array-puzzle4525/1
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int prod=1;
        int zero=0;
        for(int i:arr){
           if(i==0)zero++;
           else prod*=i;
           
           if(zero>1)prod=0;
        }
        
        int[] ans =new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                if(arr.length-zero-1>0){
                    if(zero>0){
                        ans[i]=0;
                    }else{
                        ans[i]=prod/arr[i];
                    }
                }else{
                    ans[i]=0;
                }
            }else{
                ans[i]=prod;
            }
        }
        
        return ans;
    }
}
