/***
Tags: Linked_List, Sort
Create: 2019/9/2
Update: 2019/9/2

Problem description:
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:
	Input: 4->2->1->3
	Output: 1->2->3->4


Example 2:
	Input: -1->5->3->4->0
	Output: -1->0->3->4->5

***/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Merge jeantimex's Version (Merge Sort)
// Runtime: 3 ms (faster than 97.50%); Memory Usage: 39.5 MB (less than 100.00%)

public class Solution {
  
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
      
    ListNode slow = head, fast = head, pre = head;
     
    while(fast != null && fast.next != null) {
        pre = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    pre.next = null;
    return merge(sortList(head), sortList(slow));
  }
  
  ListNode merge(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0), tmp = head;
      
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
      
    if(l1 != null)    tmp.next = l1;
    if(l2 != null)    tmp.next = l2;
      
    return head.next;
  }
}


// xietao0221's Version (Merge Sort)
// Runtime: 4 ms (faster than 60.64%); Memory Usage: 40.5 MB (less than 71.93%)

public class Solution {
  
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
      
    ListNode slow = head, fast = head, pre = head;
     
    while(fast != null && fast.next != null) {
        pre = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    pre.next = null;
    return merge(sortList(head), sortList(slow));
  }
  
  ListNode merge(ListNode l1, ListNode l2) {
    if(l1 == null)    return l2;
    if(l2 == null)    return l1;
    if(l1.val <= l2.val) {
        l1.next = merge(l1.next, l2);
        return l1;
    }
    else {
        l2.next = merge(l1, l2.next);
        return l2;
    }
  }
}