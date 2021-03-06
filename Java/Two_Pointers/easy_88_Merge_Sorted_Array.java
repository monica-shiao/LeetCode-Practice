/***
Tags: Array, Two_Pointer
Create: 2019/11/18
Update: 2019/11/18

Problem description:
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

	The number of elements initialized in nums1 and nums2 are m and n respectively.
	You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.


Example:

Input:
	nums1 = [1,2,3,0,0,0], m = 3
	nums2 = [2,5,6],       n = 3

Output:[1,2,2,3,5,6]

***/

// First Version (optimized by caikehe)
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 36.3 MB (less than 100.00%)

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, curr = m + n - 1;
        
        while(p1 >= 0 && p2 >= 0) {
            nums1[curr--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
        
        // Check for all elements in nums2 are merged in nums1(situation:nums1[0] > nums2[0])
        while (p1==-1 && p2>=0) {
            nums1[p2] = nums2[p2--];
        }
    }
}