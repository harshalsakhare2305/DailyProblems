class Solution {
    public int maxWater(int arr[]) {
        int n=arr.length;
        int[] rightmax =new int[arr.length];
        int[] leftmax =new int[arr.length];
        Arrays.fill(rightmax,-1);
        Arrays.fill(leftmax,-1);
        
        rightmax[n-1]=-1;
        leftmax[0]=-1;
        int max=n-1;
        for(int i=n-2;i>=0;i--){
            if(arr[max]>arr[i]){
                rightmax[i]=max;
            }else{
                rightmax[i]=-1;
                max=i;
            }
            
        }
        
        max=0;
        
        for(int i=1;i<n;i++){
            if(arr[max]>arr[i]){
                leftmax[i]=max;
            }else{
                leftmax[i]=-1;
                max=i;
            }
            
        }
        
        int count=0;
        for(int i=0;i<n;i++){
           // System.out.println(rightmax[i]+" "+leftmax[i]);
            if(rightmax[i]==-1 || leftmax[i]==-1)continue;
            int ht =Math.min(arr[rightmax[i]],arr[leftmax[i]]);
            
            count+=(ht);
            count-=arr[i];
            
        }
        
        return count;
    }
}
