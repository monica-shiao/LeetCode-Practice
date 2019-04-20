/***
Tags: Hash_Table
Create: 2019/4/20
Update: 2019/4/20

Problem description:
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
	Input: J = "aA", S = "aAAbbbb"
	Output: 3

Example 2:
	Input: J = "z", S = "ZZ"
	Output: 0

Note:
S and J will consist of letters and have length at most 50.

The characters in J are distinct.

***/

// My First Version
// Runtime: 1 ms (faster than 98.91%); Memory Usage: 36.9 MB (less than 87.95%)

class Solution {
    public int numJewelsInStones(String J, String S) {
        int i, ans = 0;
        int[] ascii = new int[128];
        Arrays.fill(ascii, 0);
        
        for(i = 0; i < S.length(); i++){
            ascii[(int)S.charAt(i)] ++;
        }
        
        for(i = 0; i < J.length(); i++){
            if(ascii[(int)J.charAt(i)] != 0)
                ans += ascii[(int)J.charAt(i)];
        }
        return ans;
    }
}

// My Second Version (Very Force? XD)
// Runtime: 1 ms (faster than 98.91%); Memory Usage: 36 MB (less than 88.44%)
class Solution {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        for(int i = 0; i < J.length(); i++){
            for(int j = 0; j < S.length(); j++){
                if(S.charAt(j) == J.charAt(i)) ans++;
            }
        }
        return ans;
    }
}

