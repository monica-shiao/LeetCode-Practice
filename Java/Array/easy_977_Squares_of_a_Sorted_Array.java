/***
Tags: Array
Create: 2019/4/4
Update: 2019/4/4

Problem description:
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number,also in sorted non-decreasing order.

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Note:

	1 <= A.length <= 10000
	-10000 <= A[i] <= 10000
	A is sorted in non-decreasing order.

***/

// My 2ed Version (Stack)
// Runtime: 13 ms (faster than 14.57%); Memory: 42.5 MB (less than 61.14%)
class Solution {
    public int[] sortedSquares(int[] A) {
        Stack<Integer> tmp = new Stack<>();
        int[] B = new int[A.length];
        int i, tmp1=0;
        
        for(i = 0; i < A.length; i++){
            if(A[i] >= 0){
                if(!tmp.empty()){
                    if(tmp.peek() < A[i]*A[i]){
                        B[tmp1++] = tmp.pop();
                        i--;
                        continue;
                    }
                }
                B[tmp1++] = A[i]*A[i]; 
            }   
            else{
                tmp.push(A[i]*A[i]);
            }
        }
        
        while(!tmp.empty()){
            B[tmp1++] = tmp.pop();
        }
        return B;
    }
} 


// Selection Sort
// Runtime: 884 ms (faster than 5.01%); Memory: 42.1 MB (less than 83%)
class Solution {
    public int[] sortedSquares(int[] A) {
        int i, j, min;
        for(i = 0; i < A.length; i++)   
            A[i] = A[i] * A[i];
        
        for(i = 0; i < A.length-1; i++){
            min = i;
            
            for(j = i+1; j < A.length; j++){
                if(A[j] < A[min])    min = j;
            }
            
            if(min != i){
                A[i] = A[min] ^ A[i];
                A[min] = A[min] ^ A[i];
                A[i] = A[min] ^ A[i];
            }
        }
        return A;
    }
}

