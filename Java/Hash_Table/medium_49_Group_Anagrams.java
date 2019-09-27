/***
Tags: Hash_Table, String
Create: 2019/9/27
Update: 2019/9/27

Problem description:
Given an array of strings, group anagrams together.

Example:

	Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
	Output:
	[
	  ["ate","eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]

Note:

	All inputs will be in lowercase.
	The order of your output does notmatter.

***/

// Optimize first version
// Runtime: 8 ms (faster than 96.95%); Memory Usage: 41.5 MB (less than 94.74%)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)    return new LinkedList();
        HashMap<String, LinkedList> map = new HashMap<String, LinkedList>();
        
        for(String s : strs) {
        	// Sort characters in strs[i]
            char tempArray[] = s.toCharArray(); 
            Arrays.sort(tempArray); 
            String tmp_string = new String(tempArray);
            
            // Key: Sorted string. Value: Save original string(strs[i]) in List
            if(!map.containsKey(tmp_string)) 
                map.put(tmp_string, new LinkedList());
            
            map.get(tmp_string).add(s);
        }
        return new ArrayList(map.values());
    }
}


// My First Version
// Runtime: 10 ms (faster than 48.25%); Memory Usage: 45.9 MB (less than 30.41%)
 
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, LinkedList> map = new HashMap<String, LinkedList>();
        List<List<String>> ans = new ArrayList<>();
        int i, len = strs.length;
        String tmp_string = "";
        
        for(i = 0; i < len; i++) {
        	// Sort characters in strs[i]
            char tempArray[] = strs[i].toCharArray(); 
            Arrays.sort(tempArray); 
            tmp_string = new String(tempArray);
            
            // Key: Sorted string. Value: Save original string(strs[i]) in List
            if(!map.containsKey(tmp_string)) 
                map.put(tmp_string, new LinkedList());
            
            map.get(tmp_string).add(strs[i]);
        }
        
        Set<String> keys = map.keySet();
        for(String key : keys)    ans.add(map.get(key));
    
        return ans;
    }
}