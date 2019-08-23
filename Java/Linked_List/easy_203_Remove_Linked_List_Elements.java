/***
Tags: Linked_List
Create: 2019/8/22
Update: 2019/8/22

Problem description:
Remove all elements from a linked list of integers that have value val.

Example:
	Input:  1->2->6->3->4->5->6, val = 6
	Output: 1->2->3->4->5
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
// Runtime: 1 ms (faster than 98.33%); Memory Usage: 39.6 MB (less than 100.00%)

class Solution {
    public ListNode removeElements(ListNode head, int val) {
    	// Create a previous node before head.
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode ans = pre;
        
        while(head != null) {
        	// Processing the value of node is equal to variable value 
            if(head.val == val) {
                while(head != null && head.val == val) {
                    head = head.next;
                }
                pre.next = head;   
            }
            // Avoid head already became null
            if(head != null) {
                pre = pre.next;
                head = head.next;
            }
            
        }
        return ans.next;
    }
}

// Beautiful Version (By rakashpnvs)
// Java. Beats Memory 100% and Runtime 98.33%. 
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        // Processing the node in the begining that value of head is equal to val. 
        while(head != null && head.val == val) {
            head = head.next;
        }
        
        if(head == null) {
            return null;
        }
        
        ListNode current = head;
    
        while(current.next != null) {
  			// Processing the node in the middle of list that head's value is equal to val. 
            if(current.next.val == val) {
                current.next = current.next.next;
                continue;
            }
            
            current = current.next;
        }
        
        return head;
    }
}

