/***
Tags: Array, Sort
Create: 2019/8/26
Update: 2019/8/31

Problem description:
Given a collection of intervals, merge all overlapping intervals.

Example 1:
	Input: [[1,3],[2,6],[8,10],[15,18]]
	Output: [[1,6],[8,10],[15,18]]
	Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].


Example 2:
	Input: [[1,4],[4,5]]
	Output: [[1,5]]
	Explanation: Intervals [1,4] and [4,5] are considered overlapping.

NOTE:input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

***/


// My Second Version (Idea from brubru777)
// Runtime: 35 ms (faster than 58.64%); Memory Usage: 37.3 MB (less than 100.00%)

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)   return intervals;
        
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        
        List<int[]> ans = new ArrayList<>();
        int[] new_arr = intervals[0];
        int i = 1, max;
        ans.add(new_arr);
        
        while(i < intervals.length) {
            if(intervals[i][0] <= new_arr[1]) {
                max = (intervals[i][1] >= new_arr[1]) ? intervals[i][1] : new_arr[1];
                new_arr[1] = max;
            }
            else {
                new_arr = intervals[i];
                ans.add(new_arr);
            }
            ++i;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}


// brubru777 Version (Beautiful Version)
// Runtime: 38 ms (faster than 25.40%); Memory Usage: 41.1 MB (less than 60.15%)

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)    return intervals;
        
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        
        List<int[]> ans = new ArrayList<>();
        int[] new_interval = intervals[0];
        ans.add(new_interval);
        
        for(int[] interval: intervals) {
            if(interval[0] <= new_interval[1])    // Overlapping intervals, move the end if needed
                new_interval[1] = Math.max(interval[1], new_interval[1]);
        
            else {    // Disjoint intervals, add the new interval to the list
                new_interval = interval;
                ans.add(new_interval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}


// My First Version (Less Memory)
// Runtime: 51 ms (faster than 5.41%); Memory Usage: 38.4 MB (less than 98.55%)

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, large;
        int[] tmp1, tmp2, new_arr = new int[2];
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        for(int[] each : intervals)    ans.add(each);
        
        while(i < ans.size()) {
            if(i + 1 < ans.size()) {
            	// Find whose[0] is smaller. Save smaller in tmp1
                tmp1 = (ans.get(i)[0] <= ans.get(i + 1)[0]) ? ans.get(i) : ans.get(i + 1);
                tmp2 = (ans.get(i)[0] <= ans.get(i + 1)[0]) ? ans.get(i + 1) : ans.get(i);
                
                if(tmp1[0] <= tmp2[0] && tmp2[0] <= tmp1[1]) {
                    large = (tmp1[1] >= tmp2[1]) ? tmp1[1] : tmp2[1];
                    ans.remove(i + 1);
                    ans.remove(i);
                    ans.add(i, new int[]{tmp1[0], large});
                }
                else    ++i;
            }
            else    break;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}




