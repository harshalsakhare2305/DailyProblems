//https://www.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
class Solution {
  public:
    Node *reverseKGroup(Node *head, int k) {
        // code here
        if (head == NULL) return head;
        
        Node* prevPtr = NULL, *currPtr = head, *nextPtr;
        int i = 0;
        
        while (currPtr != NULL && i < k) {
            nextPtr = currPtr -> next;
            currPtr -> next = prevPtr;
            
            prevPtr = currPtr;
            currPtr = nextPtr;
            i++;
        }
        
        if (currPtr != NULL) {
            head -> next = reverseKGroup(currPtr, k);
        }
        
        return prevPtr;
    }
};
