/***
Tags: Hash_Table Stack
Create: 2019/4/20
Update: 2019/4/21

Problem description:

Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature.  If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].


Note:
The length of temperatures will be in the range [1, 30000].
Each temperature will be an integer in the range [30, 100].

***/

// Official Version (Faster)
// Runtime: 7 ms (faster than 92.58%); Memory Usage: 42.1 MB (less than 94.89%)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] temp = new int[101];
        int[] ans = new int[T.length];
        Arrays.fill(temp, Integer.MAX_VALUE);
        int i, j, temp_index;
        
        for(i = T.length - 1; i >= 0; i--){
            // temp_index saved smallest value(position) in temp. (closest position)
            temp_index = Integer.MAX_VALUE;
            for(j = T[i] + 1; j <= 100; j++){
                if(temp[j] < temp_index)    temp_index = temp[j];
            }
            
            if(temp_index < Integer.MAX_VALUE)
                ans[i] = temp_index - i;
            
            // T[i] is origin temperatures value. temp[T[i]] sets temp[xx] = position.
            temp[T[i]] = i;   
        }
        return ans;
    }
}

// My Stack Version
// Runtime: 42 ms (faster than 72.10%); Memory Usage: 43.4 MB (less than 85.89%)

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[T.length];
        Arrays.fill(ans, 0);
        int i, pop;
        
        for(i = 0; i < T.length; i++){
            if(stack.empty())   stack.push(i);
            else{
            	// if stack.peek() meets T[i] bigger than it, pop itself and record their distance.
                while(T[i] > T[stack.peek()]){
                    pop = stack.pop();
                    ans[pop] = i - pop;
                    if(stack.empty())   break;
                }
                stack.push(i);
            }
        }
        return ans;
    }
}



// My First Version
// Runtime: 212 ms (faster than 18.83%); Memory Usage: 42.6 MB (less than 93.67%)

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int i, j, len = T.length;
        
        for(i = 0; i < len; i++){
            for(j = i+1; j < len; j++){
                if(T[j] > T[i]){
                    T[i] = j - i;
                    break;
                }
            }
            if(j == len)    T[i] = 0;
        }
        return T;
    }
}
