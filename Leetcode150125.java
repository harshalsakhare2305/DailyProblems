class Solution {
    public int minimizeXor(int num1, int num2) {
        int setbit=0;
        //log n
        while(num2>0){ //Counting Set bits
            setbit++;
            num2=(num2 & (num2-1)); //Clear the leftmost setbit
        }
      
      int ans=0;
    // O(32)
      for(int i=31;i>=0;i--){  //Set the bit where ith bit from left is set in num1 to decrese the xor
        if( setbit>0 && (num1 & (1<<i))!=0){
            ans =ans | (1<<i);
            setbit--;
        }

     

        if(setbit==0)break;
      }
    //O(32)
      while(setbit>0){   //if setbit count is still there but number of setbit in num1 are covered then set the bit from right
        ans= ans | (ans+1);  //Setting the leftmost clear bit
        setbit--;
      }
    
    return ans;

    }
}
