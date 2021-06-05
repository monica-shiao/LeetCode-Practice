/***
Tags: Math
Create: 2021/5/13
Update: 2021/5/13

Problem description:
You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane. Multiple points can have the same coordinates.

You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a radius of rj.

For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.

Return an array answer, where answer[j] is the answer to the jth query.


Example 1:


Input: points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
Output: [3,2,2]
Explanation: The points and circles are shown above.
queries[0] is the green circle, queries[1] is the red circle, and queries[2] is the blue circle.


Example 2:


Input: points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
Output: [2,3,2,4]
Explanation: The points and circles are shown above.
queries[0] is green, queries[1] is red, queries[2] is blue, and queries[3] is purple.



Constraints:


	1 <= points.length <= 500
	points[i].length == 2
	0 <= x​​​​​​i, y​​​​​​i <= 500
	1 <= queries.length <= 500
	queries[j].length == 3
	0 <= xj, yj <= 500
	1 <= rj <= 500
	All coordinates are integers.



Follow up: Could you find the answer for each query in better complexity than O(n)?

***/

/* Soltion1
Runtime: 117 ms, faster than 5.02%
Memory Usage: 39.2 MB, less than 98.05%
平方：Math.pow()
*/
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int point_num = points.length, circle_num = queries.length, i, j, count = 0;
        double distance;
        int[] ans = new int[circle_num];
        
        for(i = 0; i < circle_num; i++) {   //queries -> circle
            for(j = 0; j < point_num; j++) {    // points -> compare every points per circle
                
                //((x1-x2)^2 + (y1-y2)^2) ^ 0.5 = distance between two points.
                distance = Math.pow(Math.pow(queries[i][0] - points[j][0],2.0) + Math.pow(queries[i][1] - points[j][1],2.0), 0.5);	
                if(distance <= queries[i][2])   ++count;
            }
            ans[i] = count;
            count = 0;
        }
        return ans;
    }
}
/* Soltion2
Runtime: 22 ms, faster than 74.01% 
Memory Usage: 39.8 MB, less than 47.61%

Remove Math.pow() can save time, but use more space.
*/
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int i, j, count;
        double distance;
        int[] ans = new int[queries.length];
        
        for(i = 0; i < queries.length; i++) {   //queries
            count = 0;
            for(j = 0; j < points.length; j++) {    // points
                
            	//((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)) - r*r = distance between two points - radius
                distance = (queries[i][0] - points[j][0])*(queries[i][0] - points[j][0]) + (queries[i][1] - points[j][1]) * (queries[i][1] - points[j][1]) - queries[i][2]*queries[i][2];

                if(distance <= 0)   ++count;	//if distance longer bigger than 0 => distance of two points is longer than radius => the point is out of the circle.
            }
            ans[i] = count;
        }
        return ans;
    }
}

