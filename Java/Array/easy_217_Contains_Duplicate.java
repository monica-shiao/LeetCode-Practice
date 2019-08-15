/***
Tags: Array, Hash Table
Create: 2019/8/14
Update: 2019/8/14

Problem description:
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:
	Input: [1,2,3,1]
	Output: true

Example 2:
	Input: [1,2,3,4]
	Output: false

Example 3:
	Input: [1,1,1,3,3,4,3,2,4,2]
	Output: true

***/

// My Second Version (Arrays.sort)
// Runtime: 5 ms (faster than 93.65%); Memory Usage: 42.2 MB(less than 98.28%)

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 1)    return false;
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1])  return true;
        }
        return false;
    }
}



// My First Version (HashSet)
// Runtime: 9 ms (faster than 50.95%); Memory Usage: 43.5 MB (less than 77.59%)

// Using ArrayList will get the Time Limit Exceeded. Because when adding or removing element, the position of other elements will be changed.
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> tmp = new HashSet<>();
        
        for(int num : nums) {
            if(tmp.contains(num))   return true;
            else tmp.add(num);
        }
        return false;
    }
}

