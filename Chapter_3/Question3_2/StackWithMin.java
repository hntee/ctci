/* 
 * Author: Hao Tan
 * Time: 2014/07/17
 * Problem Description: Design a stack with push, pop and min, all operate in O(1) time
 * Idea: Implement another stack to record the min value
 */

import java.util.Stack;

public class StackWithMin extends Stack<Integer> {
	Stack<Integer> minStack;

	public StackWithMin() {
		minStack = new Stack<Integer>();
	}

	public void push(int x) {
		if (x <= min())
			minStack.push(x);
		super.push(x);
	}

	public Integer pop() {
		if (this.isEmpty())
			return null;
		if (super.peek() == min())
			minStack.pop();
		return super.pop();
	}

	public int min() {
		if (minStack.isEmpty())
			return Integer.MAX_VALUE;
		else
			return minStack.peek();
	}

	public static void main(String[] args) {
		StackWithMin swm = new StackWithMin();
		swm.push(6);
		swm.push(5);
		swm.push(8);
		swm.push(7);
		swm.push(4);
		swm.push(5);

		System.out.println("min: " + swm.min());
		System.out.println("pop.." + swm.pop());
		System.out.println("min: " + swm.min());
		System.out.println("pop.." + swm.pop());
		System.out.println("min: " + swm.min());
		System.out.println("pop.." + swm.pop());
		System.out.println("min: " + swm.min());
		System.out.println("pop.." + swm.pop());
		System.out.println("min: " + swm.min());
		System.out.println("pop.." + swm.pop());
	}
}