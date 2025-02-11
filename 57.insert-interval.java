/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start

import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> output = new ArrayList<int[]>();

        int i = 0, n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            output.add(intervals[i++]);
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        output.add(newInterval);

        while (i < n) {
            output.add(intervals[i++]);
        }

        return output.toArray(new int[output.size()][]);
    }
}
// @lc code=end
