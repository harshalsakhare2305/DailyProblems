class Solution {
    public int maxTwoEvents(int[][] events) {
        int n=events.length;

        Arrays.sort(events,(a,b)->a[0]-b[0]);

        int[][] endSorted =events.clone();
        Arrays.sort(endSorted,(a,b)->a[1]-b[1]);

        int[] maxTill =new int[n];
        maxTill[0]=endSorted[0][2];
        for(int i=1;i<n;i++){
            maxTill[i]=Math.max(maxTill[i-1],endSorted[i][2]);
        }

        int maxi=Integer.MIN_VALUE;

        int j=0;
        for(int i=0;i<n;i++){
            int st =events[i][0];
            int ei=events[i][1];

            while(j<n && endSorted[j][1]<st){
                j++;
            }

            maxi=Math.max(maxi,events[i][2]);

            if(j>0){
                maxi=Math.max(maxi,events[i][2]+maxTill[j-1]);
            }
        }

        return maxi;
    }
}
