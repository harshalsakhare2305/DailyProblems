//https://www.geeksforgeeks.org/problems/construct-tree-1/1
class Solution {
    
   
       
    public static Node buildTree(int inorder[], int preorder[],int prest,int preend,int inst,int inend,HashMap<Integer,Integer>mp){
        if(prest>preend || inst>inend)return null;
        
        Node root =new Node(preorder[prest]);
        int idx =mp.get(root.data);
        
        int numleft =idx-inst;
        
        root.left =buildTree(inorder,preorder,prest+1,prest+numleft,inst,idx-1,mp);
        root.right =buildTree(inorder,preorder,prest+numleft+1,preend,idx+1,inend,mp);
        
        return root;
    }
    public static Node buildTree(int inorder[], int preorder[]) {
        HashMap<Integer,Integer> mp =new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        
        int n =inorder.length;
        
        
        Node root=buildTree(inorder,preorder,0,n-1,0,n-1,mp);
        
      
        return root;
        
    }
}
