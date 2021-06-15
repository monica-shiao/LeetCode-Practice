/***
Tags: Sort
Create: 2021/6/14
Update: 2021/6/14

Problem description:
You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:


	numberOfBoxesi is the number of boxes of type i.
	numberOfUnitsPerBoxi is the number of units in each box of the type i.


You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the numberof boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.


Example 1:

Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
Output: 8
Explanation: There are:
- 1 box of the first type that contains 3 units.
- 2 boxes of the second type that contain 2 units each.
- 3 boxes of the third type that contain 1 unit each.
You can take all the boxes of the first and second types, and one box of the third type.
The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.


Example 2:

Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
Output: 91

Constraints:


	1 <= boxTypes.length <= 1000
	1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
	1 <= truckSize <= 106


***/


/*** For example

> Original:
Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
Output: 91

> After sorting: [number of this kind of box, number of units in this kind of box]
boxTypes = [
[5,10],
[3,9],
[4,7],
[2,5]]

> Count unit
i = 1
boxTypes[i][] -> [5,10]    5 * 10 = 50
rest of space = 10 - 5 = 5 (只剩五箱的空位了)

i = 2
boxTypes[i][] -> [3,9]    3 * 9 = 27
rest of space = 5 - 3 = 2 (只剩兩箱的空位了)

i = 3
boxTypes[i][] -> [4,7]    2 * 7 = 14
只能裝兩箱
											+)
-------------------------------------------------
									91 (units)

Reference (java Arrays.sort 2d array): https://stackoverflow.com/questions/15452429/java-arrays-sort-2d-array
***/

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int i, type_number = boxTypes.length, restSize = truckSize, total = 0;
        
        // Sort boxTypes[][1] in descending order -> sort the array by units of each box.
        Arrays.sort(boxTypes, (x, y) -> Integer.compare(y[1], x[1]));
        
        for(i = 0; i < type_number & restSize >= 0; i++) {
        	// If the location of the truck is sufficient for all boxes of this type, calculate all the units in this type of box.
            if(restSize >= boxTypes[i][0])  total += boxTypes[i][0] * boxTypes[i][1];
            // If the rest of space are only use some of box of this type, just count the total units we can get from this type of box.
            else    total += restSize * boxTypes[i][1];
            
            restSize -= boxTypes[i][0];
        }
        return total;
    }
}
