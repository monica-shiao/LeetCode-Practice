/***
Tags: Linked_List
Create: 2019/5/12
Update: 2019/5/12

Problem description:
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:
	Input: 1->2->3->4->5->NULL
	Output: 1->3->5->2->4->NULL

Example 2:
	Input: 2->1->3->5->6->4->7->NULL
	Output: 2->3->6->7->1->5->4->NULL

Note:

	The relative order inside both the even and odd groups should remain as it was in the input.
	The first node is considered odd, the second node even and so on ...

***/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Offficial Version (Awesome, O(1) space complexity and O(nodes) time complexity.)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 36.3 MB (less than 94.60%)
// Processing each odd and even number at a time.

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)   return head;
        ListNode odd = head, even_head = head.next, even = even_head;
        
        while(odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = even_head;
        return head;
    }
}

// My First Version (O(n) space complexity and O(nodes) time complexity.)
// Runtime: 1 ms (faster than 59.48%); Memory Usage: 35.3 MB (less than 96.71%)

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)    return head;
        ListNode final_head = new ListNode(head.val), odd_curr = final_head;
        ListNode even_head = new ListNode(head.next.val), even_curr = even_head;
        int cnt = 1;
        
        while(head != null && head.next != null && head.next.next != null) {
            if(cnt % 2 == 1){
                odd_curr.next = new ListNode(head.next.next.val);
                odd_curr = odd_curr.next;
            }
            else {
                even_curr.next = new ListNode(head.next.next.val);
                even_curr = even_curr.next;
            }
            head = head.next;
            ++cnt;
        }
        even_curr.next = null;
        odd_curr.next = even_head;
          
        return final_head;
    }
}



