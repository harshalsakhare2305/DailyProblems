//https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null)return null;
        
        if(!leaf(node)){
            ans.add(node.data);
        }
        
        left(node, ans);
        addleaves(node, ans);
        right(node, ans);
        
        return ans;
    }
    
    public static boolean leaf(Node node){
        return (node.left == null && node.right == null);
    }
    
    void left(Node root, ArrayList<Integer> ans){
        Node curr = root.left;
        
        while(curr != null){
            if(!leaf(curr)){
                ans.add(curr.data);
            }
            if(curr.left !=null){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
    }
    
    void right(Node root,ArrayList<Integer> ans){
        Node curr = root.right;
        Stack<Integer> st = new Stack<>();
        
        while(curr != null){
            if(!leaf(curr)){
                st.push(curr.data);
            }
            if(curr.right != null){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
         while(!st.isEmpty()){
                ans.add(st.pop());
            }
    }
    
    void addleaves(Node root, ArrayList<Integer> ans){
        if(root == null)return;
        
        if(leaf(root)){
            ans.add(root.data);
        }
        else{
            addleaves(root.left, ans);
            addleaves(root.right, ans);
        }
    }
}
