/*
 * @lc app=leetcode id=166 lang=java
 *
 * [166] Fraction to Recurring Decimal
 */

// @lc code=start
import java.util.HashMap;
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // Handle edge case: if numerator is 0, the result is "0"
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Determine sign
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Convert to long to avoid overflow
        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);

        // Append integer part
        result.append(num / denom);
        long remainder = num % denom;

        // If no remainder, return result as there is no fractional part
        if (remainder == 0) return result.toString();

        // Append decimal point
        result.append(".");

        // Use a hashmap to store remainder positions to detect repeating decimals
        HashMap<Long, Integer> remainderMap = new HashMap<>();

        while (remainder != 0) {
            // If remainder is seen before, insert parentheses
            if (remainderMap.containsKey(remainder)) {
                int insertPos = remainderMap.get(remainder);
                result.insert(insertPos, "(");
                result.append(")");
                break;
            }

            // Store remainder with its position in the result
            remainderMap.put(remainder, result.length());

            // Perform division
            remainder *= 10;
            result.append(remainder / denom);
            remainder %= denom;
        }

        return result.toString();
    }
}
// @lc code=end

