/***
Tags: Linked_List
Create: 2019/5/12
Update: 2019/5/12

Problem description:
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:
	Input: 1->2->4, 1->3->4
	Output: 1->1->2->3->4->4

***/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// My Second Version (Brute Force)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 37.1 MB (less than 97.90%)

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 != null && l2 != null) {
            ListNode head;
            
            if(l1.val < l2.val){
                head = l1;
                l1 = l1.next;
            }
            else {
                head = l2;
                l2 = l2.next;
            }

            ListNode tmp = head;

            while(l1 != null && l2 != null) {
                if(l1.val <= l2.val) {
                    tmp.next = l1;
                    l1 = l1.next;
                }
                else {
                    tmp.next = l2;
                    l2 = l2.next;
                }
                tmp = tmp.next;
            }
            tmp.next = (l1 != null) ? l1 : l2;

            return head;
        }
        else {
            return (l1 == null) ? l2 : l1;
        }
    }
}


// My First Version (Merge l2 into l1)
// Runtime: 1 ms (faster than 79.64%); Memory Usage: 38.4 MB (less than 83.30%)

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 != null && l2 != null) {
        	// Let the list whose first number is the smallest number become l1.
            if(l1.val > l2.val) {
                ListNode tmp = l1;
                l1 = l2;
                l2 = tmp;
            }   
            ListNode head = l1, tmp;
            
            while(head.next != null && l2 != null) {
            	// Merge l2 into l1.
                if(head.val <= l2.val && l2.val < head.next.val) {
                    tmp = head.next;
                    head.next = new ListNode(l2.val);
                    head.next.next = tmp;
                    l2 = l2.next;
                }
                head = head.next;
            }
            
            if(l2 != null)  head.next = l2;
            
            return l1;
        }    
        else {
            if(l1 == null)  return l2;
            else    return l1;
        }
    }
}

