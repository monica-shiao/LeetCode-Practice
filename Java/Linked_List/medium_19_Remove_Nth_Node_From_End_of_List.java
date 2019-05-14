/***
Tags: Linked_List (Two_Pointer)
Create: 2019/5/14
Update: 2019/5/14

Problem description:
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

	Given linked list: 1->2->3->4->5, and n = 2.

	After removing the second node from the end, the linked list becomes 1->2->3->5.


Note:
	Given n will always be valid.

	Follow up:

	Could you do this in one pass?

***/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// My First Version
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 33.8 MB (less than 100.00%)

class Solution {
    int flag = 0, cnt = 0;
    ListNode tmp;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return recursive(head, n);
    }
    
     public ListNode recursive(ListNode head, int n) {
     	// When begin to go back, count the number that must be deleted.
         if(head == null){
             flag = 1;
             return null;
         }    
         
         tmp = recursive (head.next, n);
         ListNode last = new ListNode(head.val);
         
         if(flag == 1)    cnt += 1;
         
         if(cnt == n)    return tmp;
         
         last.next = tmp;
         
         return last;
     }
}