/***
Tags: Hash_Table, Sort
Create: 2019/5/28
Update: 2019/5/28

Problem description:
Given two strings s and t, write a function to determine if t is an anagram of s.

Example 1:
	Input: s = "anagram", t = "nagaram"
	Output: true


Example 2:
	Input: s = "rat", t = "car"
	Output: false


Note:
	You may assume the string contains only lowercase alphabets.

Follow up:
	What if the inputs contain unicode characters? How would you adapt your solution to such case?

***/




// My First Version (ASCII + Array)
// Runtime: 4 ms (faster than 75.35%); Memory Usage: 35.9 MB (less than 73.30%)

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] ascii = new int[26];
        Arrays.fill(ascii, 0);
        int i, s_curr, t_curr;
        
        if(s.length() != t.length())    return false;
        
        for(i = 0; i < s.length(); i++) {
            s_curr = (int)s.charAt(i);
            t_curr = (int)t.charAt(i);
            if(  97 <= s_curr && 97 <= t_curr && s_curr <= 122 && t_curr <= 122) {
            	// One way of writing : s.charAt(i) - 'a'
                ++ascii[s_curr - 97];
                --ascii[t_curr - 97];
            }
            else    return false; 
        }
        
        for(i = 0; i < 26; i++) {
            if(ascii[i] != 0)   return false;
        }
        
        return true;
    }
}

// My Second Version (ASCII + string.toCharArray() + Arrays.sort())
// Runtime: 6 ms (faster than 39.50%); Memory Usage: 35.3 MB (less than 84.16%)

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())    return false;

        char[] s_arr = s.toCharArray(), t_arr = t.toCharArray();
        Arrays.sort(s_arr);
        Arrays.sort(t_arr);
        
        /*
        for(int i = 0; i < s_arr.length; i++) {
            if(97 <= (int)s_arr[i] && 97 <= (int)t_arr[i] && (int)s_arr[i] <= 122 && (int)t_arr[i] <= 122) {
                if(s_arr[i] != t_arr[i])    return false;
            }
            else    return false;
        }
        return true;*/

        // Official Version
        return Arrays.equals(str1, str2);

    }
}
