/***
Problem description:
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
Note that the row index starts from 0.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Could you optimize your algorithm to use only O(k) extra space?

Example 1:
	Input: 3
	Output: [1,3,3,1]

Example 2:
	Input: 4
	Output: [1,4,6,4,1]

***/

// Java Version
// Just use one list to save num. Using backtracking to reset the new value.

/* Simple note: 

Eample: 

"3 choose 2" is the sum of "2 choose 1" and "2 choose 2" in the previous line.
In the same way, "2 choose 1" is the sum of "1 choose 0" and "1 choose 1".

    [1]  <---------------------> [C(0,0)]
   [1,1]  <----------------> [C(1,0)  C(1,1)]
                                  ------   ------
  [1,2,1]  <-----------> [C(2,0) |C(2,1)| |C(2,2)|]
                                  ----\-   -/----
                                       ------
 [1,3,3,1]  <-------> [C(3,0)  C(3,1) |C(3,2)| C(3,3)]
                                       ------
[1,4,6,4,1]  <-> [C(4,0)  C(4,1)  C(4,2)  C(4,3)  C(4,4)]

Below solution's flow:
row.add(0,1)
    [1]

for(i=1)
    [1,1]

for(i=2){
    [1,2] ---> [1, 1+(old)1 = (new)2]

    row.add(1)
    [1,2,1]
}

for(i=3){
    [1,3,3] ---> first:[1, 2, 2+(old)1=(new)3], second:[1, 1+(old)2=(new)3, 3]
    row.add(1)
    [1,3,3,1]
}
    
*/


public List<Integer> getRow(int rowIndex){
        List<Integer> row = new ArrayList<>();
        int i, j;

        // First digit always is 1.
        row.add(0, 1);

        for(i = 1; i <= rowIndex; i++) {
            for(j = i-1; j >= 1; j--){
                // Num is the sum of same place num and previous place num in the previous line.
                row.set(j, row.get(j) + row.get(j-1));
            }
            row.add(1);
        }
        return row;
    }




/* My Version (Practice recersive, but no space complexity O(k))

public class Main {

    public static void main(String[] args) {
        int rowIndex = 4;

        for(int i = rowIndex; i >= 0; i-- ){
            System.out.println(recursive(rowIndex,i));
        }
    }

    public static int recursive(int x, int y){
        if(y == 0 || x == y){
            return 1;
        }

        int p = recursive(x-1,y-1) + recursive(x-1,y);
        return  p ;
    }
}

*/
