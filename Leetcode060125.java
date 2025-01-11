//https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/submissions/1505089897/?envType=daily-question&envId=2025-01-06
class Solution {
    public int[] minOperations(String boxes) {
        int[] ans =new int[boxes.length()];
        int right=0;
        int total=0;
        int steps=0;
        for(int i=0;i<boxes.length();i++){
            if(boxes.charAt(i)=='1'){
                right++;
                total++;
                steps+=(i-0);
            }
        }

        ans[0]=steps;
        for(int i=1;i<boxes.length();i++){
            if(boxes.charAt(i-1)=='1'){
                right--;
            }
            steps-=(right);
            steps+=(total-right);

            ans[i]=steps;
        }

        return ans;
    }
}
