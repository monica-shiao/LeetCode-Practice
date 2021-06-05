/***
Tags: String
Create: 2019/11/19
Update: 2019/11/20

Problem description:
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

	Input: haystack = "hello", needle = "ll"
	Output: 2


Example 2:

	Input: haystack = "aaaaa", needle = "bba"
	Output: -1


Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C'sstrstr() and Java'sindexOf().

***/

// My First Version
// Runtime: 3 ms (faster than 33.75%); Memory Usage: 37.9 MB (less than 67.17%)

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals(""))  return 0;
        
        int curr = 0, hay_p = 0, nee_p = 0;
        
        while(curr < haystack.length()) {
            if(haystack.charAt(curr) == needle.charAt(nee_p)) {
                if(nee_p == 0)    hay_p = curr;
                ++nee_p;
            }
            else {
                if(nee_p != 0)  curr = hay_p;
                nee_p = 0;
            }
            
            if(nee_p == needle.length())    return hay_p;
            
            ++curr;
        }
        
        return -1;
    }
}

// indexOf()
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 37.8 MB (less than 67.17%)

class Solution {
    public int strStr(String haystack, String needle) {

        return haystack.indexOf(needle);
    }
}

// jeantimex Version
// Runtime: 3 ms (faster than 33.75%); Memory Usage: 37.6 MB (less than 68.70%)
class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}