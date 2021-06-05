/***
Tags: String
Create: 2021/5/12
Update: 2021/5/12

Problem description:
Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defangedIP addressreplaces every period "." with "[.]".


Example 1:
Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"
Example 2:
Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"


Constraints:


	The given address is a valid IPv4 address.

***/

// Becasue "." & "\" are metacharacters, if you want to use them literally, you need to escape it by using backslash -> "\\."
class Solution {
    public String defangIPaddr(String address) {
        String[] ip = address.split("\\.");
        String ans = "";
        
        for(int i = 0; i < 4; i++) {
            ans += ip[i];
            if (i < 3)  ans += "[.]";
        }
        return ans;
    }
}
