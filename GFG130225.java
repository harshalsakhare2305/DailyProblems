//http://geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1
class Solution {
    ArrayList<Integer> list =new ArrayList<>();
    void inorder(Node root){
        if(root==null)return;
        
        inorder(root.left);
        list.add(root.data);
        inorder(root.right);
    
    }
    boolean findTarget(Node root, int target) {
        inorder(root);
       int left =0;
       int right =list.size()-1;
       
       while(left<right){
           int sum =list.get(right);
           sum+=list.get(left);
           
           if(sum==target)return true;
           else if(sum>target){
               right--;
           }else if(sum<target){
               left++;
           }
       }
       
       
       return false;
      
    }
}
