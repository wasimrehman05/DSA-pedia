/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<String>(wordDict);

        List<String> output = new ArrayList<>();

        int start = 0;

        subStrCheck(s, wordSet, start, "", output);

        return output;

    }

    public void subStrCheck(String s, HashSet<String> wordSet, int start, String str, List<String> output) {

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordSet.contains(s.substring(start, end))) {
                String newStr = str + " " + s.substring(start, end);

                if (end == s.length()) {
                    output.add(newStr.trim());
                    return;
                }

                subStrCheck(s, wordSet, end, newStr, output);
            }
        }
    }
}
// @lc code=end
