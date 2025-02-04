/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> output = new ArrayList<>();

        if (digits.isEmpty())
            return output;

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        output.add("");

        for (char digit : digits.toCharArray()) {
            
            String letters = map.get(digit);
            List<String> tempList = new ArrayList<>();

            for (char letter : letters.toCharArray()) {
                for (String combination : output) {
                    tempList.add(combination + letter);
                }
            }
            output = new ArrayList<>(tempList);
        }

        return output;
    }
}
// @lc code=end
