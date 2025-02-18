//https://leetcode.com/problems/construct-smallest-number-from-di-string/
class Solution {
    public String smallestNumber(String pattern) {
        String str ='*'+pattern;
        int tar =str.length();
        int[] next =new int[str.length()];
        Arrays.fill(next,tar);
        int n=str.length();

        int idx =str.charAt(n-1) == 'I' ? (n-1) : tar;

        for(int i=n-2;i>=0;i--){
            next[i]=idx;

            if(str.charAt(i)=='I'){
                idx =Math.min(idx,i);
            }
        }

        String ans ="";
        int left =next[0]-0;
        int curr=left;

        for(int i=1;i<n;i++){
           ans=ans+curr; //Appending string

           if(str.charAt(i)=='D'){
              curr--;
           }else{
            curr=left+(next[i]-i);
           }

           left=Math.max(left,curr);
            

        }

        ans+=curr;

        return ans;

    }
}
