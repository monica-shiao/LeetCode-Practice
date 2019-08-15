/***
Tags: Math
Create: 2019/8/14
Update: 2019/8/14

Problem description:
Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
***/

// My First Version
// Runtime: 1 ms (faster than 100.00%); Memory Usage: 37 MB (less than 100.00%)

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
    
        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0)    ans.add("FizzBuzz");
            else if(i % 3 == 0)     ans.add("Fizz");
            else if(i % 5 == 0)     ans.add("Buzz");
            else    ans.add(Integer.toString(i));
        }
        
        return ans;
    }
}
