/*
 * @lc app=leetcode id=506 lang=java
 *
 * [506] Relative Ranks
 */

// @lc code=start

import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        // Use PriorityQueue with a custom comparator to store index and score
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < n; i++) {
            maxHeap.add(new int[]{i, score[i]}); // Store index and score
        }

        String[] ans = new String[n];
        int place = 1;

        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int curIndex = top[0];

            if (place == 1) {
                ans[curIndex] = "Gold Medal";
            } else if (place == 2) {
                ans[curIndex] = "Silver Medal";
            } else if (place == 3) {
                ans[curIndex] = "Bronze Medal";
            } else {
                ans[curIndex] = String.valueOf(place);
            }
            place++;
        }

        return ans;
    }
}
// @lc code=end
