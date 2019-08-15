/***
Tags: Math, String
Create: 2019/8/14
Update: 2019/8/14

Problem description:
Roman numerals are represented by seven different symbols:I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example,two is written as IIin Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:


	I can be placed before V (5) and X (10) to make 4 and 9.
	X can be placed before L (50) and C (100) to make 40 and 90.
	C can be placed before D (500) and M (1000) to make 400 and 900.


Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:
	Input:"III"
	Output: 3

Example 2:
	Input:"IV"
	Output: 4

Example 3:
	Input:"IX"
	Output: 9

Example 4:
	Input:"LVIII"
	Output: 58
	Explanation: L = 50, V= 5, III = 3.


Example 5:
	Input:"MCMXCIV"
	Output: 1994
	Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

***/

// My First Version
// Runtime: 6 ms (faster than 51.80%); Memory Usage: 35.9 MB (less than 100.00%)

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int i, ans = 0;
        char c;
        
        if(s.length() == 1) return map.get(s.charAt(0));
        
        for(i = s.length() - 1; i >= 0; i--) {
            c = s.charAt(i);
            ans += map.get(c);
            
            if(i == 0)  break;
            
            if((c == 'V' || c == 'X') && s.charAt(i - 1) == 'I') {
                ans -= 1;
                --i;
            }
            else if((c == 'L' || c == 'C') && s.charAt(i - 1) == 'X') {
                ans -= 10;
                --i;
            }
            else if((c == 'D' || c == 'M') && s.charAt(i - 1) == 'C') {
                ans -= 100;
                --i;
            }
        }
        return ans;
    }
}

// My Second Version
// Runtime: 7 ms (faster than 36.29%); Memory Usage: 36.2 MB (less than 100.00%)

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int i, ans = 0, val;
        
        if(s.length() == 1) return map.get(s.charAt(0));
        
        for(i = s.length() - 1; i >= 0; i--) {
            val = map.get(s.charAt(i));
            ans += val;
            
            if(i != 0 && map.get(s.charAt(i - 1)) < val) {
                ans -= map.get(s.charAt(i - 1));
                --i;
            }
        }
        return ans;
    }
}
