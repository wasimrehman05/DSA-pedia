/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    private double solve(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            return solve(1/x, -n);
        }

        if (n % 2 == 0){
            return solve(x * x, n / 2);
        } 

        return x * solve(x * x, (n-1) / 2);
    }

    public double myPow(double x, int n) {
        return solve(x, (long)n);
    }
}
// @lc code=end

