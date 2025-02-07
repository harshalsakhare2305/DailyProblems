//https://www.geeksforgeeks.org/problems/inorder-traversal/1
class Solution {
    public void inorder(Node root, ArrayList<Integer> ans){
        if(root==null)return ;
        
        inorder(root.left,ans);
        ans.add(root.data);
        inorder(root.right,ans);
    }
    ArrayList<Integer> inOrder(Node root) {
      ArrayList<Integer> ans =new ArrayList<>();
      inorder(root,ans);
      return ans;
    }
}
