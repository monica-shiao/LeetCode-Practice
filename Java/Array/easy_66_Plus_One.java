/***
Tags: "Array", "Math"
Create: 2019/01/23
Update: 2019/01/24

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
***/

// One Solution
//  +1 要進位的那個 digit 為0。沒有進位的分兩種，一種是原值要+1，另一是前一個進位要加一，但無論如何都是+1。故加一完後就結束。 
// Source: http://www.cnblogs.com/grandyang/p/4079357.html

public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = digits.length - 1; i >= 0; --i) {
            // Two case: 1. origin value plus one 
            // 2. number after carry is one (so next digit plus one).
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            // Carry num will be ten, so this digit is 0.
            digits[i] = 0;
        }

        int[] res = new int[n + 1];

        res[0] = 1;
        return res;
    }
}

// Second Solution
// 利用餘數與除法取得每個位數，不過比我原本的優於當沒有進位程式就會結束。
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) 
            return digits;

        int carry = 1, n = digits.length, sum;

        for (int i = n - 1; i >= 0; --i) {
            if (carry == 0) 
                return digits;

            sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        int[] res = new int[n + 1];
        
        res[0] = 1;
        //return digits when num is a single digit.
        return carry == 0 ? digits : res;
    }
}

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