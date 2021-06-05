/***
Tags: Array
Create: 2021/5/12
Update: 2021/5/12

Problem description:
You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.


Example 1:


Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.


Example 2:


Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
Explanation: 
1st customer has wealth = 6
2nd customer has wealth = 10 
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.

Example 3:


Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
Output: 17



Constraints:


	m ==accounts.length
	n ==accounts[i].length
	1 <= m, n <= 50
	1 <= accounts[i][j] <= 100


***/


// array[m][n] -> array.length = m, array[0].length = n
class Solution {
    public int maximumWealth(int[][] accounts) {
        int cus_num = accounts.length, acct_num = accounts[0].length, i, j, wealth = 0;
        
        for (i = 0; i < cus_num; i++) {	// ith person
            for (j = 1; j < acct_num; j++) {	// total wealth per person
                accounts[i][j] += accounts[i][j-1];
            }

            // if the wealth of ith person is larger than current largest wealth, just instead of it.
            if (accounts[i][j-1] > wealth)  wealth = accounts[i][j-1];
        }
        
        return wealth;
    }
}
