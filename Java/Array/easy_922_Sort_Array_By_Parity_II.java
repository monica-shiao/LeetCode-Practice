/***
Tags: Array
Create: 2019/4/2
Update: 2019/4/4

Problem description:
Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.


Example 1:

	Input: [4,2,5,7]
	Output: [4,5,2,7]
	Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.


Note:

	2 <= A.length <= 20000
    A.length % 2 == 0
    0 <= A[i] <= 1000

***/

// My Third Version (Additional Array)
// Runtime: 2 ms (faster than 99.85%); Memory: 43.2 MB (less than 9.73%)
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] ans = new int[A.length];
        int odd = 1, even = 0, i;
        for(i = 0; i < A.length; i++){
            if(A[i] % 2 == 0){
                ans[even] = A[i];
                even += 2;
            }
            else{
                ans[odd] = A[i];
                odd += 2;
            }
        }
        return ans;
    }
}


// My Second Version (Selection Sort, In-place)
// Runtime: 9 ms (faster than 15.18%); Memory: 42 MB (less than 73.37%)
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int i, j, tmp;
        
        for(i = 0; i < A.length; i++){
            if(i % 2 == 0){
                if(A[i] % 2 != 0){
                    for(j = i+1; j < A.length; j++){
                        if(A[j] % 2 == 0){
                            tmp = A[i];
                            A[i] = A[j];
                            A[j] = tmp;
                            break;
                        }
                    }
                }
            }
            else{
                if(A[i] % 2 == 0){
                    for(j = i+1; j < A.length; j++){
                        if(A[j] % 2 != 0){
                            tmp = A[i];
                            A[i] = A[j];
                            A[j] = tmp;
                            break;
                        }
                    }
                }
            }
        }
        
        return A;
    }
}



// My First Version (Stack)
// Runtime: 14 ms (faster than 9.50%); Memory: 42.9 MB (less than 21.42%); Terrible it is, haha QQ.
/*
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] ans = new int[A.length];
        Stack odd = new Stack();
        Stack even = new Stack();
        int i;
        
        for(i = 0; i < A.length; i++){
            if(A[i] % 2 == 0)   even.push(A[i]);
            else    odd.push(A[i]);
            
        }
        
        for(i = 0; i < A.length; i++){
            if(i % 2 == 0)  ans[i] = (int)even.pop();
            else    ans[i] = (int)odd.pop();
        }
        
        return ans;
    }
}
*/
