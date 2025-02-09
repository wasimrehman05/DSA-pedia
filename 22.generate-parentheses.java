/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<String>();

        dfs(0, 0, "", output, n);

        return output;
    }

    private void dfs(int open, int close, String str, List<String> output, int n) {
        if (open == n && close == n) {
            output.add(str);
            return;
        }

        if (open < n) {
            dfs(open + 1, close, str+"(", output, n);
        }

        if (close < open) {
            dfs(open, close + 1, str+")", output, n);
        }
    }
}
// @lc code=end
