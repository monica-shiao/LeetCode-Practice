/***
Tags: Linked_List Two_Pointer
Create: 2019/5/11
Update: 2019/5/11

Problem description:
Given a singly linked list, determine if it is a palindrome.

Example 1:
	Input: 1->2
	Output: false

Example 2:
	Input: 1->2->2->1
	Output: true

Follow up:
Could you do it in O(n) time and O(1) space?

***/

// My third Version (half reverse & Itertive)
// Runtime: 1 ms (faster than 95.60%); Memory Usage: 38.7 MB (less than 99.87%)

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)   return true;
        
        ListNode mid = findMid(head);
        ListNode reverse = Reverse(mid.next);
        
        while(head != null && reverse != null) {
            if(head.val != reverse.val)   return false;
            reverse = reverse.next;
            head = head.next;
        }
        
        return true;
    }
    
    public ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // Iterative
    public ListNode Reverse(ListNode head) {
        ListNode tmp, pre = null;
        while(head != null) {
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    // Recursive (A little more memory (1Mb) than iterative version)
    /*
    public ListNode Reverse(ListNode head, ListNode last) {
        if(head == null)    return last;
        
        ListNode curr = new ListNode(head.val);
        curr.next = last;
        last = curr;
        return Reverse(head.next, last);
    }
    */
}

// My Second Version (Linked List & Recursive)
// Runtime: 1 ms (faster than 95.60%); Memory Usage: 41.3 MB (less than 95.54%)

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode reverse = Reverse(head, null);
        while(reverse != null) {
            if(head.val != reverse.val)    return false;
            reverse = reverse.next;
            head = head.next;
        }
        
        return true;
    }
    
    public ListNode Reverse(ListNode head, ListNode last) {
        if(head == null)    return last;
        
        ListNode curr = new ListNode(head.val);
        curr.next = last;
        last = curr;
        return Reverse(head.next, last);
    }
}


// Beauty Recursive Version (Idea from rajkukadia)
// Runtime: 2 ms (faster than 37.06%); Memory Usage: 42.6 MB (less than 27.82%)
// Reference: https://leetcode.com/problems/palindrome-linked-list/discuss/181453/Java-or-5-lines-method-or-2ms-or-O(n)-or-recursive-or-easy-to-understand

class Solution {
    ListNode curr;
    boolean equal, ans;
    
    public boolean isPalindrome(ListNode head) {
        curr = head;
        return Reverse(head);
    }
    
    public boolean Reverse(ListNode ptr) {
        if(ptr == null)    return true;
        
        ans = Reverse(ptr.next);
        equal = (ptr.val == curr.val) ? true : false;
        curr = curr.next;
        
        return ans && equal;
    }
}

// My First Version 
// Runtime: 8 ms (faster than 6.04%); Memory Usage: 41.5 MB (less than 94.75%)

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)   return true;
        Map<Integer, Integer> map= new HashMap<>();
        int cnt = 0;
        
        while(head != null) {
            map.put(cnt++, head.val);
            head = head.next;
        }
        
        --cnt;
        
        for(int i = 0; i <= cnt / 2; i++) {
            if((int)map.get(i) != (int)map.get(cnt - i))
                return false;  
        }
            
        return true;
    }
}
