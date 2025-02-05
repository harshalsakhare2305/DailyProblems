//https://www.geeksforgeeks.org/problems/mirror-tree/1
class Solution {
     Node helper(Node node){
         if(node==null)return null;
         
         Node right =helper(node.left);
         Node left =helper(node.right);
         
         node.left =left;
         node.right=right;
         
         return node;
     }
    void mirror(Node node) {
       node =helper(node);
       
    }
    
}
