/***
Tags: String, Backtracking
Create: 2019/5/20
Update: 2019/5/22

Problem description:
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


Example:
	Input: "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


Note:
	Although the above answer is in lexicographical order, your answer could be in any order you want.

***/


// My First Version
// Runtime: 0 ms (faster than 100.00%); Memory Usage: 35.3 MB (less than 97.98%)

class Solution {
    public List<String> letterCombinations(String digits) {
        String[] words = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> ans = new ArrayList<>(), tmp_list;
        int i, j, k, pos, ans_size;
        
        if(digits.length() == 0)    return new ArrayList<>();
        
        // Run through every number in digits
        for(i = 0; i < digits.length(); i++) {
        	// Convert digit of Charactor type to int (and number 2 in problem -> 0 in words array)
            pos = (int)digits.charAt(i) - 50;
            // In order to add new charactor to older list, fixed total number of old list (not include new members we're going to add)
            ans_size = ans.size();
            tmp_list = (ArrayList<String>)ans.clone();
            ans.clear();

            // Every charactor in current string
            for(j = 0; j < words[pos].length(); j++){
            	// Add every charactor to every older string in list.
                for(k = 0; k < ans_size; k++){
                    ans.add(tmp_list.get(k) + String.valueOf(words[pos].charAt(j)));
                }
                if(i == 0)  ans.add(String.valueOf(words[pos].charAt(j)));
            }
        }
        
        return ans;
    }
}