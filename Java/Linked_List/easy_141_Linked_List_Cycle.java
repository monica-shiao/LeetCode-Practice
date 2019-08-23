/***
Tags: Linked_List, Two_Pointers
Create: 2019/8/22
Update: 2019/8/22

Problem description:
Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Example 1:
	Input: head = [3,2,0,-4], pos = 1
	Output: true
	Explanation: There is a cycle in the linked list, where tail connects to the second node.


Example 2:
	Input: head = [1,2], pos = 0
	Output: true
	Explanation: There is a cycle in the linked list, where tail connects to the first node.


Example 3:
	Input: head = [1], pos = -1
	Output: false
	Explanation: There is no cycle in the linked list.

Follow up:

Can you solve it using O(1) (i.e. constant) memory?

***/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Pretty Version (By jeantimex)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 37.2 MB (less than 100.00%)

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow)    return true;
        }
        return false;
    }
}


// My First Version (Two_Pointers)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 37.7 MB (less than 85.00%)

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)   return false;
        
        ListNode slow = head, fast = head.next;
        
        while(slow != fast) {
            if(fast.next == null || fast.next.next == null)    return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
