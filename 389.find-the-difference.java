/*
 * @lc app=leetcode id=389 lang=java
 *
 * [389] Find the Difference
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        String str = s + t;
        
        for (int i = 0; i < str.length(); i++) {
            res ^= str.charAt(i);
        }

        return res;
    }
}
// @lc code=end

