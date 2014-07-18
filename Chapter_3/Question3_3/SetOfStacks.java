/* 
 * Author: Hao Tan
 * Time: 2014/07/17
 * Problem Description: Design a set of stacks. Wehn previous stack exceeds some
 *						threshhold, we start a new stack
 */
import java.util.ArrayList;
import java.util.Stack;

class SetOfStacks {
	ArrayList<Stack<Integer>> stacks;
	int current; // current stack
	int size; // size of the whole SetOfStacks
	int capacity; // every stack cannot exceed it

	public SetOfStacks(int capacity) {
		stacks = new ArrayList<Stack<Integer>>();
		this.capacity = capacity;
	}

	public Integer pop() {
		if (size == 0) return null;
		if (stacks.get(current).isEmpty()) {
			stacks.remove(current--);
		}
		size--;
		return stacks.get(current).pop();
	}

	public void push(int value) {
		if (size == 0) {
			stacks.add(new Stack<Integer>());
		} else if (size % capacity == 0) {
			stacks.add(new Stack<Integer>());
			current++;
		}
		stacks.get(current).push(value);
		size++;
	}

	public static void main(String[] args) {
		SetOfStacks setofstacks = new SetOfStacks(30);
		for (int i = 0; i < 200; i++) {
			setofstacks.push(i);
		}

		for (int i = 0; i < 201; i++) {
			System.out.println(setofstacks.pop());
		}
	}
}