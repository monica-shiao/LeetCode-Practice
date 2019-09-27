/***
Tags: Stack, DFS
Create: 2019/9/26
Update: 2019/9/26

Problem description:
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
***/

// My First Version
// Runtime: 1 ms (faster than 70.44%); Memory Usage: 35.8 MB (less than 40.91%)

class Solution {
    public String decodeString(String s) {
        if(s.length() < 2)    return s;
        
        Stack<String> st = new Stack<>();
        String ans = "", sub_string, tmp_string, num_string = "";
        int has_num = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ']') {
            	// Getting start to read the content in []
                sub_string = st.pop();
                // tmp_string is used to save content
                tmp_string = "";
                
                while(!sub_string.equals("[")) {
                    tmp_string = sub_string + tmp_string; 
                    sub_string = st.pop();
                }
    
                String tmp_ans = "", num = st.pop();
                
                for(int j = 0; j < Integer.valueOf(num); j++)
                    tmp_ans += tmp_string;
                
                // Meaning this content is wrapped in other []
                if(st.size() != 0)    st.push(tmp_ans);
                else    ans += tmp_ans;
            }
            else {
                if(Character.isDigit(s.charAt(i))) {
                	// Handling number that exceed one digit 
                    num_string += String.valueOf(s.charAt(i));
                    // Meaning there are number that accumulating (cause exceed one digit)
                    has_num = 1;
                }
                else {
                	// Handling the character isn't in []
                    if(has_num == 0 && st.size() == 0)    ans += s.charAt(i);
                    else {
                        if(s.charAt(i) == '[') {
                        	// Pushing accumulating number in stack
                            st.push(num_string);
                            num_string = "";
                            has_num = 0;
                        }
                        st.push(String.valueOf(s.charAt(i)));
                    }
                }
            }
        }
        return ans;
    }
}


// My Second Version (StringBuilder)