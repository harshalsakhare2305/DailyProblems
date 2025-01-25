//https://www.geeksforgeeks.org/problems/find-the-first-node-of-loop-in-linked-list--170645/1
class Solution {
    public static Node findFirstNode(Node head) {
        // code here
        
        HashSet<Node> s=new HashSet();
        Node temp=head;
        while(temp!=null){
            if(s.contains(temp)){
                return temp;
            }else{
                s.add(temp);
                temp=temp.next;
            }
        }
        return null;
    }
}
