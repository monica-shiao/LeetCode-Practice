/***
Tags: Hash_Table, Bit manipulation
Create: 2019/8/14
Update: 2019/8/14

Problem description:
Given a non-emptyarray of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
	Input: [2,2,1]
	Output: 1


Example 2:
	Input: [4,1,2,1,2]
	Output: 4


***/

// Bit manipulation
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 38.3 MB (less than 98.52%)

class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int result = 0;
        
        // xor : The thing xor itself will become 0; Xor different thing will save it in result.
        for(int i : nums)
            result ^= i;
        
        return result;
    }
} 


// My Hashset Version (HashSet)
// Runtime: 8 ms (faster than 20.75%); Memory Usage: 39.9 MB (less than 97%)

class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        Set<Integer> set = new HashSet<>();
        
        for(int i : nums) {
            if(!set.contains(i))    set.add(i);  
            else    set.remove(i);   
        }
        
        return set.iterator().next();
    }
}
