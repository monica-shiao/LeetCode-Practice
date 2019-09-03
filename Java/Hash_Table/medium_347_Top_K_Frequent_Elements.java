/***
Tags: Hash_Table, Heap
Create: 2019/9/3
Update: 2019/9/3

Problem description:
Given a non-empty array of integers, return the k most frequent elements.

Example 1:
	Input: nums = [1,1,1,2,2,3], k = 2
	Output: [1,2]



Example 2:
	Input: nums = [1], k = 1
	Output: [1]


Note: 
	You may assume k is always valid, 1 <= k <= number of unique elements.
	Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

***/


// My Third Version (Hashmap + List<Integer>[])
// Runtime: 11 ms (faster than 87.68%); Memory Usage: 39.6 MB (less than 73.28%)
// Idea from mo10

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums.length == 0 || k == 0)    return null;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new LinkedList[nums.length + 1];
        List<Integer> ans = new LinkedList<>();
        int val;
        
        for(int num : nums) 
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        for(int key : map.keySet()){
            val = map.get(key);
            
            if(bucket[val] == null)    
                bucket[val] = new LinkedList<>();
            
            bucket[val].add(key);
        }
        
        for(int i = bucket.length - 1; i >= 0 && ans.size() < k; i--) {
            if(bucket[i] != null)   
                ans.addAll(bucket[i]);
        }
                    
        return ans;   
    }
}



// My Second Version (Hashmap + Priority Queue)
// Runtime: 44 ms (faster than 33.76%); Memory Usage: 40.8 MB (less than 50.86%)
// Idea from Official Version

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums.length == 0 || k == 0)    return null;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new LinkedList<>();
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        
        // keep k top frequent elements in the heap 
        for(int key : map.keySet()) {
            heap.add(key);
            if(heap.size() > k)    heap.poll();
        }
        
        // build output list
        while(k > 0) {
            ans.add(heap.poll());
            --k;
        }
        return ans;   
    }
}


// My First Version (Hashmap + array)
// Runtime: 46 ms (faster than 22.98%); Memory Usage: 42.1 MB (less than 9.48%)

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums.length == 0 || k == 0)    return null;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new LinkedList<>();
        
        for(int num : nums) {
            if(map.containsKey(num)) 
                map.replace(num, map.get(num) + 1);
            else 
                map.put(num, 1);
        }
        
        int len = map.size();
        int[][] arr = new int[len][2];
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr[i][1] = entry.getKey();
            arr[i++][0] = entry.getValue();
        }
        
        Arrays.sort(arr, (i1, i2) -> Integer.compare(i2[0], i1[0]));
        
        for(int i = 0; i < k; i++) 
            ans.add(arr[i][1]);
        
        return ans;   
    }
}

