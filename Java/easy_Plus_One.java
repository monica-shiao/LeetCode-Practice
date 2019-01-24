/*
Problem description:
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
	Input: [1,2,3]
	Output: [1,2,4]

Example 2:
	Input: [9,9,9]
	Output: [1,0,0,0]

Example 3:
	Input: [0,2,3]
	Output: [2,4]
*/


	

/* My First Version

class Solution {
    public int[] plusOne(int[] digits) {
        int[] new_array = new int[ digits.length + 1 ];
        int i, temp = 1;
        
        for(i = digits.length - 1; i >= 0; i--){
            // Upper 10, carry digit.
            if(digits[i] + temp >= 10){
                digits[i] = (digits[i] + 1) % 10;
                temp = 1;
            }
            else{
                digits[i] += temp;
                temp = 0;
            }
        }
        
        if(temp == 1){
            // Create new array to save list which carry digit at the head of the list.
            new_array[0] = 1;
            for(i = 1; i < digits.length + 1; i++){
                new_array[i] = digits[i - 1]; 
            }
            
            return new_array;
        }
        
        if (new_array[0] == 0){
            int flag = 0, t=0;
            for(i = 0; i < digits.length; i++){
                if(flag == 1 ){
                    new_array[t++] = digits[i];
                    continue;
                }
                if(digits[i] != 0){
                    flag = 1;
                    new_array[t++] = digits[i];
                }
            }
           
            //return new_array;
        }
        
        return digits;
    }
}

*/