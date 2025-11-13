// Time Complexity : O(m*n)
// Space Complexity : O(1) since we are making changes in place
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using bottom up dp approach.
 * Start from second last row and get minimum from j and j+1 index from row below at every index and add it to current node's value.
 * Keep going towards the top where the top index will have the minimum value.
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int column = 0; column <= row; column++) {
                int bestBelow = Math.min(triangle.get(row + 1).get(column), triangle.get(row + 1).get(column + 1));
                triangle.get(row).set(column, bestBelow + triangle.get(row).get(column));
            }
        }

        return triangle.get(0).get(0);
    }
}