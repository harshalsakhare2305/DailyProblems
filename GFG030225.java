//https://www.geeksforgeeks.org/problems/height-of-binary-tree/1
class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
         if(node==null)return -1;
         
         int left =height(node.left);
         int right =height(node.right);
         
         return Math.max(left,right)+1;
    }
}
