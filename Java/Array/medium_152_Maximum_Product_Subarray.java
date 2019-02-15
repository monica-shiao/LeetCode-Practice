/***
Tags: "Array" "Dynamic Programming"
Create: 2019/02/15
Update: 2019/02/15

Problem description:
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:
    Input: [2,3,-2,4]
    Output: 6
    Explanation: [2,3] has the largest product 6.

Example 2:
    Input: [-2,0,-1]
    Output: 0
    Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
***/

// Good Solution
// O(n) time complexity
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int pre_max = nums[0], pre_min = nums[0], ans = nums[0], max, min;

        for (int i = 1; i < nums.length; i++) {
            // pre_max & pre_min 乘上 every nums 才會是連續狀態。
            // 比較 pre_max * nums[i] & nums[i] 誰大，pre_max * nums[i]大就是繼續連續乘下去。
            // nums[i]大就是不用前面乘積，自己已較大，且從現在開始看看能不能變更大。
            // min 用於可能負負得正。
            max = Math.max(Math.max(pre_max * nums[i], pre_min * nums[i]), nums[i]);
            min = Math.min(Math.min(pre_max * nums[i], pre_min * nums[i]), nums[i]);
            ans = Math.max(max, ans);
            pre_max = max;
            pre_min = min;
        }
        return ans;
    }
}


// My First Version
// O(2)space complexity and costs long long time.

class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, tmp, i, j;
        for(i = 0; i < nums.length; i++){
            if(nums[i] > max)   max = nums[i];

            tmp = nums[i];

            for(j = i+1; j < nums.length; j++){
                tmp *= nums[j];
                if(tmp > max)   max = tmp;
            }
        }
        return max;
    }
}