class Solution {
    public int maxLen(int[] arr) {
        // Your code here
        int n=arr.length;
        if(n==1)
        return 0;

//Making all the zero's as -1 then we will find the subarray whose sum is zero.   

for(int i=0;i<n;i++)
        {
            if(arr[i]==0)
            {
                arr[i]=-1;
            }
           
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        int currSum=0;
        int maxLength=0;
        for(int i=0;i<n;i++)
        {
            currSum+=arr[i];
            if(currSum==0)
            {
               maxLength=i+1; 
            }
            
            if(map.containsKey(currSum))
            {
              maxLength=Math.max(maxLength,i-map.get(currSum));  
            }
            if(!map.containsKey(currSum))
            {
                map.put(currSum,i);
            }
        }
        
        return maxLength;
      
    }
}
