/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> output = new ArrayList<>();

        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > prev[1]) {
                output.add(prev);
                prev = intervals[i];
            } else if (intervals[i][1] > prev[1] ) {
                prev[1] = intervals[i][1];
            }
        }

        output.add(prev);

        return output.toArray(new int[output.size()][]);
    }
}
// @lc code=end

