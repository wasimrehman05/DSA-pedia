/**

  1. Two Sum

	Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	You may assume that each input would have exactly one solution, and you may not use the same element twice.
	You can return the answer in any order.

**/

import java.util.Arrays;
import java.util.Comparator;

class BruteFroceSolution {
	/**
	 * --time complexity = O(n^2)
	 * --space complexity = O(1)
	 **/

	public static int[] twoSum(int[] nums, int target) {
		int[] output = null;
		for (int i = 0; i < nums.length; i += 1) {
			for (int j = i + 1; j < nums.length; j += 1) {
				if (nums[i] + nums[j] == target) {
					output = new int[] { i, j };
					break;
				}
			}
			if (output != null) {
				break;
			}
		}
		return output;
	}

	public static void main(String[] arg) {
		int[] answer = twoSum(new int[] { 4, 1, 2, 3 }, 6);
		System.out.println(Arrays.toString(answer));
	}

}

class TwoPointerSolution {
	/**
	 * --time complexity = O(n log n), The Arrays.sort() method has a time
	 * complexity of O(n log n), and the while loop has a time complexity of O(n).
	 * Therefore, the overall time complexity is O(n log n).
	 * --space complexity = O(n), Beacause we creating a temporary array of
	 * calculation.
	 **/

	public static int[] twoSum(int[] nums, int target) {
		int[] output = null;
		int[][] temp = new int[nums.length][2];
		for (int i = 0; i < nums.length; i++) {
			temp[i] = new int[] { nums[i], i };
		}

		Arrays.sort(temp, Comparator.comparingInt(a -> a[0]));

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			if (temp[left][0] + temp[right][0] == target) {
				output = new int[] { temp[left][1], temp[right][1] };
				break;
			} else if (temp[left][0] + temp[right][0] > target) {
				right--;
			} else {
				left++;
			}
		}

		return output;
	}

	public static void main(String[] arg) {
		int[] answer = twoSum(new int[] { 4, 1, 2, 3 }, 6);
		System.out.println(Arrays.toString(answer));
	}
}
