//https://leetcode.com/problems/maximize-happiness-of-selected-children/?envType=daily-question&envId=2025-12-25
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq =new PriorityQueue<>((a,b)->b-a);

        for(int h:happiness){
            pq.add(h);
        }

        int turn =0;
        long sum=0;
        while(turn<k){
            int select=pq.poll();
          select=Math.max(select-turn,0);
          sum+=select;
          turn++;
        }

        return sum;
    }
}
