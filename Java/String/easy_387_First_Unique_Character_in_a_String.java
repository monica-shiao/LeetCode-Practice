/***
Tags: "String" "Hash Table"
Create: 2019/02/25
Update: 2019/02/25

Problem description:
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:
    s = "leetcode"
    return 0.

    s = "loveleetcode"
    return 2.

Note: You may assume the string contain only lowercase letters.

***/

// My Version
// Time complexity is O(n).
class Solution {
    public int firstUniqChar(String s) {
            
        for(int i = 0; i < s.length(); i++){
            if(s.lastIndexOf(s.charAt(i)) == i && s.indexOf(s.charAt(i)) == i){
                return i;
            }
        }
        return -1;
    }
}