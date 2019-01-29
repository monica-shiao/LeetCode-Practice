/***
Tags: "Array", "Two Pointers", "Binary Search"
Create: 2019/01/25
Update: 2019/01/28

Problem description:
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:
    Your returned answers (both index1 and index2) are not zero-based.
    You may assume that each input would have exactly one solution and you may not use the same element twice.

Example:

    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
***/

// 夾擠是個不錯的想法，Runtime is O(n)
// Reference: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/discuss/226428/Fastest-Solution-(Currently-faster-than-100-of-other-Java-submissions)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;
        while(i < j){
            if(numbers[i] + numbers[j] < target){
                i++;
            }
            else if(numbers[i] + numbers[j] > target){
                j--;
            }
            else{
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{-1, -1};
    }
}


// My Version QQ
// Runtime is O(n^2)
/*
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i, j;
        int[] ans = new int[2];
        
        for(i = 0; i < numbers.length; i++){
            for(j = i + 1; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target){
                    return (i < j) ? new int[]{i+1,j+1} : new int[]{j+1,i+1};
                }
            }
        }
        return ans;
    }
}
*/





