/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();

        dfs(0, 0, "", n, output);

        return output;
    }

    private void dfs(int open, int close, String str, int n, List<String> output) {
        if (open == close && open + close == 2 * n) {
            output.add(str);
            return;
        }

        if (open < n) {
            dfs(open + 1, close, str + "(", n, output);
        }

        if (close < open) {
            dfs(open, close + 1, str + ")", n, output);
        }
    }
}
// @lc code=end
