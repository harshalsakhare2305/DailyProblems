https://www.geeksforgeeks.org/problems/rotate-a-linked-list/1

class Solution {
    public Node rotate(Node head, int k) {
     
      int size=0;
      Node curr =head;
      while(curr!=null){
          curr=curr.next;
          size++;
      }
    //  System.out.println(size);
      k%=size;
      if(k==0)return head;
      int i=1;
      curr=head;
      while(i<k){
          i++;
          curr=curr.next;
      }
          
      
      Node next=curr.next;
      curr.next=null;
     Node temp =next;
     while(temp.next!=null){
         temp=temp.next;
     }
      temp.next=head;
      return next;
    }
}
