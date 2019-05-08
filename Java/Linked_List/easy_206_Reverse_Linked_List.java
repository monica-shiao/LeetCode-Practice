/***
Tags: Linked_List
Create: 2019/5/1
Update: 2019/5/8

Problem description:
Reverse a singly linked list.

Example:
	Input: 1->2->3->4->5->NULL
	Output: 5->4->3->2->1->NULL


Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

***/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// My second version (Recursive)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 36 MB (less than 99.25%)
/*
    Curr        Last
---------------------------
     1          null
     2          1 -> null
     3          2 -> 1 -> null
     4          3 -> 2 -> 1 -> null

Curr.next = last

*/

class Solution {
    public ListNode reverseList(ListNode head) {
        return recursive(head, null);
    }
    
    public ListNode recursive(ListNode head, ListNode last) {
        if(head == null)   return last;
        
        ListNode curr = new ListNode(head.val);
        curr.next = last;
        last = curr;
        return recursive(head.next, last);
    }
}


// Official Iterative Version
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 37.9 MB (less than 9.41%)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, next_tmp;
        
        while(head != null){
        	// Using next_tmp to store the following list.
            next_tmp = head.next;

            // Let head.next link with the list which has already reversed.
            head.next = pre;

            // Store new reversed list to pre parameter.
            pre = head;

            // Let head to be the list which hasn't processed.
            head = next_tmp;
        }
        return pre;
    }
}

// My First Version
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 37.9 MB (less than 13.75%)
class Solution {
    public ListNode reverseList(ListNode head) {
        int[] value = new int[5000];
        int cnt = 0;

        if(head == null)    return null;
        
        while(head != null){
            value[cnt++] = head.val;
            head = head.next;
        }
        
        ListNode node = new ListNode(value[--cnt]), curr = node;
        cnt -= 1;
        
        while(cnt != -1){
            curr.next = new ListNode(value[cnt--]);
            curr = curr.next;
        }
        return node;
    }
}


