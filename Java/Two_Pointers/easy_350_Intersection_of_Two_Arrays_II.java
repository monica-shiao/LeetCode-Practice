/***
Tags: Hash_Table, Two Pointer, Binary Search, Sort
Create: 2019/8/15
Update: 2019/8/15

Problem description:
Given two arrays, write a function to compute their intersection.

Example 1:
	Input: nums1 = [1,2,2,1], nums2 = [2,2]
	Output: [2,2]



Example 2:
	Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	Output: [4,9]


Note:
	Each element in the result should appear as many times as it shows in both arrays.
	The result can be in any order.


Follow up:
	What if the given array is already sorted? How would you optimize your algorithm?
	What if nums1's size is small compared to nums2's size? Which algorithm is better?
	What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

***/

// My Second Version
// Runtime: 2 ms (faster than 91.22%); Memory Usage: 37.8 MB (less than 45.16%)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // length : arr1 < arr2
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0; 
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                ++i;
                ++j;
            }
            else if(nums1[i] < nums2[j]) {
                ++i;
            }
            else {
                ++j;
            }
        }
        
        int[] ans = new int[list.size()];
        for(i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}



// My First Version (Ugly QQ)
// Runtime: 4 ms (faster than 22.59%); Memory Usage: 36.6 MB (less than 83.87%)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // length : arr1 < arr2
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        if(nums1.length <= nums2.length) {
            return commonality(nums1, nums2);
        }
        else {
            return commonality(nums2, nums1);
        }
    }
    
    public int[] commonality(int[] arr1, int[] arr2) {
        int i, j, tmp = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(i = 0; i < arr1.length; i++) {
            for(j = tmp; j < arr2.length; j++) {
                if(arr1[i] == arr2[j]) {
                    tmp = j + 1;
                    list.add(arr1[i]);
                    break;
                }
            }
        }
        
        int[] ans = new int[list.size()];
        for(i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}


