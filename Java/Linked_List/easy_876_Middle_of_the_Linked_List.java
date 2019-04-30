/***
Tags: Linked_List
Create: 2019/4/30
Update: 2019/4/30

Problem description:
Given a non-empty, singlylinked list with head node head, returnamiddle node of linked list.

If there are two middle nodes, return the second middle node.


Example 1:

	Input: [1,2,3,4,5]
	Output: Node 3 from this list (Serialization: [3,4,5])
	The returned node has value 3.  (The judge&#39;s serialization of this node is [3,4,5]).
	Note that we returned a ListNode object ans, such that:
	ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.

Example 2:

	Input: [1,2,3,4,5,6]
	Output: Node 4 from this list (Serialization: [4,5,6])
	Since the list has two middle nodes with values 3 and 4, we return the second one.

Note:

	The number of nodes in the given list will be between 1and 100.

***/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Officail Version (Cool!)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 35.4 MB (less than 88.01%)

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

// Official Version (Using array to save linked-lists)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 35.3 MB (less than 88.01%)

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;

        while (head != null) {
            A[t++] = head;
            head = head.next;
        }

        return A[t / 2];
    }
}


// My First Version
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 35.3 MB (less than 88.01%)

/*
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode curr = head, node = head, tmp;
        int cnt = 0, i;
        
        while(curr != null){
            curr = node.next;
            node = curr;
            ++cnt;
        }
        
        for(i = 0; i < cnt; i++){
            if(i == cnt / 2)    return head;
            
            curr = head.next;
            head = curr;
        }
        
        return head;
    }
}*/
