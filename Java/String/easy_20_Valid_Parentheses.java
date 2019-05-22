/***
Tags: String, Stack
Create: 2019/5/22
Update: 2019/5/22

Problem description:
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
	Open brackets must be closed by the same type of brackets.
	Open brackets must be closed in the correct order.


Note that an empty string isalso considered valid.

Example 1:
	Input: "()"
	Output: true


Example 2:
	Input: "()[]{}"
	Output: true


Example 3:
	Input: "(]"
	Output: false

Example 4:
	Input: "([)]"
	Output: false

Example 5:
	Input: "{[]}"
	Output: true

***/

// My First Version (ASCII)
// Runtime: 1 ms (faster than 99.05%); Memory Usage: 33.5 MB (less than 100.00%)

class Solution {
    public boolean isValid(String s) {
        char curr;
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++) {
            curr = s.charAt(i);
            if(curr == ')' || curr == '}' || curr == ']') {
                if(stack.empty() || Math.abs((int)stack.pop() - (int)curr) > 2)    return false;
            }
            else    stack.add(curr);
        }
        return stack.empty();
    }
}
// My Second Version (HashMap)
// Runtime: 2 ms (faster than 78.69%); Memory Usage: 33.5 MB (less than 100.00%)

class Solution {
    public boolean isValid(String s) {
        char curr;
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        for(int i = 0; i < s.length(); i++) {
            curr = s.charAt(i);
            if(map.containsKey(curr)){
                if(stack.empty() || stack.pop() != map.get(curr))    return false;
            }
            else    stack.push(curr);
        }
        return stack.empty();
    }
}