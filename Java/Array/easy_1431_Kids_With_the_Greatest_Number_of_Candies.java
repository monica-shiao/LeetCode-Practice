/***
Tags: Array
Create: 2021/5/12
Update: 2021/5/12

Problem description:
Given the array candies and the integer extraCandies, where candies[i] represents the number of candies that the ith kid has.

For each kid check if there is a way to distribute extraCandies among the kids such that he or she can have the greatest number of candies among them.Notice that multiple kids can have the greatest number of candies.


Example 1:


Input: candies = [2,3,5,1,3], extraCandies = 3
Output: [true,true,true,false,true] 
Explanation: 
Kid 1 has 2 candies and if he or she receives all extra candies (3) will have 5 candies --- the greatest number of candies among the kids. 
Kid 2 has 3 candies and if he or she receives at least 2 extra candies will have the greatest number of candies among the kids. 
Kid 3 has 5 candies and this is already the greatest number of candies among the kids. 
Kid 4 has 1 candy and even if he or she receives all extra candies will only have 4 candies. 
Kid 5 has 3 candies and if he or she receives at least 2 extra candies will have the greatest number of candies among the kids. 


Example 2:


Input: candies = [4,2,1,1,2], extraCandies = 1
Output: [true,false,false,false,false] 
Explanation: There is only 1 extra candy, therefore only kid 1 will have the greatest number of candies among the kids regardless of who takes the extra candy.


Example 3:


Input: candies = [12,1,12], extraCandies = 10
Output: [true,false,true]



Constraints:


	2 <= candies.length <= 100
	1 <= candies[i] <= 100
	1 <= extraCandies <= 50


***/

/*
Runtime: 0 ms, faster than 100.00% 
Memory Usage: 39 MB, less than 45.81%
*/

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int lar = 0, len = candies.length, i;
        List<Boolean> ans = new ArrayList<>();
        
        for(i = 0; i < len; i++) {	// get max number in array.
            if (candies[i] > lar)   lar = candies[i];
        }
        
        for(i = 0; i < len; i++) {
            if (candies[i] + extraCandies >= lar)  
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}