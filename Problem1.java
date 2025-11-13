// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Starting from 3rd element, check the difference between (i,i-1) and (i-1,i-2) to keep track of number of slices ending at ith index
 *  If they are same, then the current slice will be 1 more than the slice at i-1
 *  If they are not same, then there is not a slice ending at ith index. Set it to 0.
 *
 * Add it to total at every point and return total in the end.
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        //can't have slices for 2 elements
        if (n < 3)
            return 0;

        int[] dp = new int[n];
        int total = 0;

        for (int i = 2; i < n; i++) {
            // if difference between i and i-1 index is same as i-1 and i-2, then i'th index will have 1 more slice than i-1 index
            if ((nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2])) {
                dp[i] = dp[i - 1] + 1;
                total += dp[i];
            } else {
                // doesn't match so there is no slice ending at this index
                dp[i] = 0;
            }
        }

        return total;
    }
}