//https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
class Solution {
    static Node reverse(Node head){
        Node prev =null;
        Node curr =head;
        
        while(curr!=null){
            Node next =curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        
        return prev;
    }
    
    static Node addTwoLists(Node num1, Node num2) {
       num1 =reverse(num1);
       num2=reverse(num2);
       
       int carry=0;
       Node dummy =new Node(-1);
       Node temp =dummy;
       Node temp1=num1;
       Node temp2=num2;
       
       while(temp1!=null && temp2!=null){
           int sum =temp1.data+temp2.data+carry;
           carry=sum/10;
           sum=sum%10;
           Node nd =new Node(sum);
           temp.next=nd;
           temp=temp.next;
           temp1=temp1.next;
           temp2=temp2.next;
       }
       
       while(temp1!=null){
         int sum =temp1.data+carry;
           carry=sum/10;
           sum=sum%10;
           Node nd =new Node(sum);
           temp.next=nd;
           temp=temp.next;
           temp1=temp1.next;
           
       }
       
       while(temp2!=null){
         int sum =temp2.data+carry;
           carry=sum/10;
           sum=sum%10;
           Node nd =new Node(sum);
           temp.next=nd;
           temp=temp.next;
           temp2=temp2.next;
           
       }
       
       if(carry>0){
           Node nd =new Node(carry);
           temp.next=nd;
           temp=temp.next;
       }
       
       dummy=dummy.next;
   
       dummy =reverse(dummy);
       while(dummy.data==0){
           dummy=dummy.next;
       }
       
       return dummy;
       
       
    }
}
