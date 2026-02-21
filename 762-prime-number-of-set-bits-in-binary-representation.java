//https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/?envType=daily-question&envId=2026-02-21

class Solution {
    boolean[] prime;
    void Seive(){
       
      prime[1]=false;
        for(int i=2;i<32;i++){
            if(prime[i]){
              
                for(int j=2*i;j<32;j+=i){
                    prime[j]=false;
                }
            }
        }


    }
    public int countPrimeSetBits(int left, int right) {
        int ct=0;
         prime=new boolean[32];
         Arrays.fill(prime,true);
        Seive();
        for(int mask=left;mask<=right;mask++){

            int count=Integer.bitCount(mask);
            if(prime[count]){
                System.out.println(mask);
                ct++;
            }
        }

        return ct;
    }
}
