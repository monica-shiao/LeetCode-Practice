/***
Tags: Linked_List Math
Create: 2019/5/13
Update: 2019/5/14

Problem description:
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	Explanation: 342 + 465 = 807.
***/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Official Version (Great~~)
// Runtime: 2 ms (faster than 95.07%); Memory Usage: 38 MB (less than 99.07%)


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0), curr = ans;
        int n1, n2, sum, carry = 0;

        // Processing all part of l1 and l2.
        while(l1 != null || l2 != null) {
            n1 = (l1 != null) ? l1.val : 0;
            n2 = (l2 != null) ? l2.val : 0;
            sum = n1 + n2 + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            
            if(l1 != null)   l1 = l1.next;
            if(l2 != null)   l2 = l2.next;
            curr = curr.next;    
        }
        
        // Final carry problem
        if(carry != 0){
            curr.next = new ListNode(carry);
        }
        
        return ans.next;
    }
}

// My First Version 
// Runtime: 2 ms (faster than 95.07%); Memory Usage: 41.9 MB (less than 69.11%)
// Separate Math and Linked List to handle   

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode merge = new ListNode(0), head = merge, tmp = merge;
        // Merge Two List (Linked List)
        while(l1 != null && l2!= null) {
            merge.next = new ListNode(l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
            merge = merge.next;
        }
        if(l1 != null)  merge.next = l1;
        else    merge.next = l2;
        
        // Processing carry problem (Math)
        int carry = 0;
        while(tmp != null) {
            tmp.val += carry; 
            carry = 0;
            if(tmp.val >= 10){
                carry = tmp.val / 10; 
                tmp.val %= 10;
            } 

            if(tmp.next != null)    tmp = tmp.next;
            else break;
        }
        if(carry != 0)  tmp.next = new ListNode(carry);
        return head.next;
    }
}


// My Second Version
// Runtime: 2 ms (faster than 95.07%); Memory Usage: 43.5 MB (less than 63.60%)
// If nodes number of l2 more than l1. Add to l1 and add node's value in l1 & l2 in processing.

/*
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = l1;
        int carry = 0, tmp;
        // Processing the full part of l2 (add node's value in l2 into l1)
        while(l2 != null) {
            tmp = curr.val + l2.val + carry;
            carry = tmp / 10;
            curr.val = tmp % 10;

            if( curr.next == null && l2.next != null) {
                curr.next = new ListNode(0);
            }
            if(l2.next != null)     curr = curr.next;
            l2 = l2.next;
        }
        
        // Processing carry problem in l1
        while(carry != 0) {
            if(curr.next == null){
                curr.next = new ListNode(carry);
                carry = 0;
            }
            else{
                curr = curr.next;
                tmp = curr.val + carry;
                carry = tmp / 10;
                curr.val = tmp % 10;
            }    
        }
        return l1;
    }
}*/



