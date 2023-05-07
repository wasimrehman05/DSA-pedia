/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 **/

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode dummyHead = new ListNode(0);
			ListNode curr = dummyHead;
			int carry = 0;
			while (l1 != null || l2 != null) {
					int val1 = (l1 != null) ? l1.val : 0;
					int val2 = (l2 != null) ? l2.val : 0;
					int sum = carry + val1 + val2;
					carry = sum / 10;
					curr.next = new ListNode(sum % 10);
					curr = curr.next;
					if (l1 != null)
							l1 = l1.next;
					if (l2 != null)
							l2 = l2.next;
			}
			if (carry > 0) {
					curr.next = new ListNode(carry);
			}
			return dummyHead.next;
	}

	public static void main(String[] args) {
			Solution solution = new Solution();

			// Test case 1: Input: (2 -> 4 -> 3) + (5 -> 6 -> 4), Output: 7 -> 0 -> 8
			ListNode l1 = new ListNode(2);
			l1.next = new ListNode(4);
			l1.next.next = new ListNode(3);
			ListNode l2 = new ListNode(5);
			l2.next = new ListNode(6);
			l2.next.next = new ListNode(4);
			ListNode result = solution.addTwoNumbers(l1, l2);
			printLinkedList(result);

			// Test case 2: Input: (9 -> 9 -> 9) + (1), Output: 0 -> 0 -> 0 -> 1
			ListNode l3 = new ListNode(9);
			l3.next = new ListNode(9);
			l3.next.next = new ListNode(9);
			ListNode l4 = new ListNode(1);
			ListNode result2 = solution.addTwoNumbers(l3, l4);
			printLinkedList(result2);
	}

	private static void printLinkedList(ListNode node) {
			while (node != null) {
					System.out.print(node.val + " ");
					node = node.next;
			}
			System.out.println();
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
			this.val = val;
	}

	ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
	}
}