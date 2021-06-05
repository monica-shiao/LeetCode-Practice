/***
Tags: String
Create: 2020/2/10
Update: 2020/2/10

Problem description:
Implement atoi whichconverts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:


	Only the space character ' ' is considered as whitespace character.
	Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [&minus;231, 231&minus; 1]. If the numerical value is out of the range of representable values, INT_MAX (231&minus; 1) or INT_MIN (&minus;231) is returned.


Example 1:

	Input: "42"
	Output: 42


Example 2:

	Input: "   -42"
	Output: -42
	Explanation: The first non-whitespace character is '-', which is the minus sign.
	            Then take as many numerical digits as possible, which gets 42.


Example 3:

	Input: "4193 with words"
	Output: 4193
	Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.


Example 4:

	Input: "words and 987"
	Output: 0
	Explanation: The first non-whitespace character is 'w', which is not a numerical 
	            digit or a +/- sign. Therefore no valid conversion could be performed.

Example 5:

	Input: "-91283472332"
	Output: -2147483648
	Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
	            Thefore INT_MIN (&minus;231) is returned.

***/


// My First Version
// Runtime: 4 ms, faster than 23.92%; Memory Usage: 38.7 MB, less than 5.59%
class Solution {
    public int myAtoi(String str) {
        int neg = 0, space = 1;
        StringBuffer str_num = new StringBuffer("0");
        
        for(int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if(curr == ' '){
                if(space == 1)  continue;
                else break;
            }
            else if(curr == '-' || curr == '+') {
                space = 0;
                if(neg != 0 || str_num.length() > 1)    break;
                else {
                    if(curr == '-')  neg = 1;
                    else    neg = 2;
                    continue;
                }
            }
            else {
                space = 0;
                if(48 <= (int)curr && (int)curr <= 57)    str_num.append(curr);
                else    break;
            }
        }
        
        try {
            if(neg == 1)    return Integer.valueOf(str_num.toString()) * -1;
            else    return Integer.valueOf(str_num.toString());
        }
        catch (Exception e){
            if(neg == 1)    return Integer.MIN_VALUE;
            else    return Integer.MAX_VALUE;
        }
    }
}
