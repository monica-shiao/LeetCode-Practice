/***
Tags: Linked_List
Create: 2019/5/8
Update: 2019/5/10

Problem description:
Reverse a linked list from position m to n. Do it in one-pass.

Note:1 <= m <= n <= length of list.

Example:
	Input: 1->2->3->4->5->NULL, m = 2, n = 4
	Output: 1->4->3->2->5->NULL
	
***/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// My First Version (Half of recursion)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 33.4 MB (less than 100.00%)

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode curr, tmp = null;
        int cnt = 1;
        
        if(m == 1 && cnt == 1) {
            // Using tmp to store the list which is after need to reverse list.
            tmp = head;
            
            while(cnt++ <= n)    tmp = tmp.next;
            
            // Let reversed list be the head (beginning pointer).
            head = Reverse(head, n, 1, null);
            
            curr = head;
            
            // Use curr to find the end of head. (To connect unreversed list -> tmp)
            while(curr.next != null)    curr = curr.next;
            
        }
        
        else {
            curr = head;
            
            while(curr.next != null) {
                
                // Find the num ranked (m-1)th. Reversing m~n num and storing in num.next.
                if(cnt + 1 == m) {
                    tmp = curr;
                    int cnt1 = cnt;

                    while(cnt1++ <= n)    tmp = tmp.next;
                    
                    curr.next = Reverse(curr.next, n, cnt+1, null);
                }

                curr = curr.next;
                ++cnt;
            }
        }
    
        curr.next = tmp;
        return head;
    }
    
    public ListNode Reverse(ListNode head, int target, int cnt, ListNode last) {
        if(cnt > target)    return last;
        
        ListNode curr = new ListNode(head.val);
        curr.next = last;
        last = curr;

        return Reverse(head.next, target, ++cnt, last);
    }
}
