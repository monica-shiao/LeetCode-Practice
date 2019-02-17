/***
Tags: "Math"
Create: 2019/01/22
Update: 2019/01/22

Problem description:
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
    Input: 123
    Output: 321

Example 2:
    Input: -123
    Output: -321

Example 3:
    Input: 120
    Output: 21

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
***/

class Solution {
    public int reverse(int x) {
        int ans=0, flag=0;
        if(x<0){
            flag = 1;
            x *= -1;
        }
        while(x>0){
            if(ans > Integer.MAX_VALUE/10)  return 0;
            ans = ans*10 + (x%10);
            x /= 10;
        }
        if(flag==1)
            ans *= -1;
        return ans;
    }
}