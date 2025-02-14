
//https://www.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1

//https://www.youtube.com/watch?v=ZWGW7FminDM

class Solution {
    private Node first;
    private Node middle;
    private Node last;
    private Node prev;
    
    
    void inorder(Node root){
        if(root==null)return ;
        
        inorder(root.left);
        
        if(prev!=null && root.data<prev.data){
            
            if(first==null){
                first=prev;
                middle =root;
            }
            
            
            last =root;
        }
        
        prev=root;
        
        inorder(root.right);
        
    }
    
    void correctBST(Node root) {
      first=middle=last=prev=null;
      
      inorder(root);
      
      if(first!=null && last!=null){
          int t =first.data;
          first.data=last.data;
          last.data=t;
      }else if(first!=null && middle!=null){
           int t =first.data;
          first.data=middle.data;
          middle.data=t;
      }
      
      
    }
}
