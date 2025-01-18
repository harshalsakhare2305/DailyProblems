//https://geeksforgeeks.org/problems/reverse-a-linked-list/1
class Solution {
    Node reverseList(Node head) {
        if(head.next==null)return head;
        Node prev =head;
        Node curr =prev.next;
        while(curr!=null){
            Node next =curr.next;
            
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        
        head.next=null;
        return prev;
        
        
    }
}
