/* 
 * Author: Hao Tan
 * Time: 2014/07/19
 * Problem Description: Implement a queue using two stacks
 * Time: enqueue: O(1), dequeue: O(n), peek: O(n), isEmpty: O(1)
 */

import java.util.Stack;

class MyQueue<Item> {
	Stack<Item> enqueueStack;
	Stack<Item> dequeueStack;
	public MyQueue(){
		enqueueStack = new Stack<Item>();
		dequeueStack = new Stack<Item>();
	}
	public void enqueue(Item item) {
		enqueueStack.push(item);
	}
	public Item dequeue() {
		if (peek() == null) return null;
		return dequeueStack.pop();
	}
	public Item peek() {
		if (isEmpty()) return null;
		if (dequeueStack.isEmpty()) {
			// push all the elements of enqueueStack onto dequeueStack
			while(!enqueueStack.isEmpty()) {
				dequeueStack.push(enqueueStack.pop());
			}
		}
		return dequeueStack.peek();
	}

	public boolean isEmpty() {
		return enqueueStack.isEmpty() && dequeueStack.isEmpty();
	}

	public static void main(String[] args) {
		MyQueue<Integer> myqueue = new MyQueue<Integer>();
		System.out.println("isEmpty? " + myqueue.isEmpty());
		myqueue.enqueue(1);
		myqueue.enqueue(2);
		myqueue.enqueue(3);
		System.out.println("isEmpty? " + myqueue.isEmpty());
		System.out.println("peek " + myqueue.peek());
		System.out.println("dequeue " + myqueue.dequeue());
		System.out.println("dequeue " + myqueue.dequeue());
		System.out.println("dequeue " + myqueue.dequeue());
		System.out.println("isEmpty? " + myqueue.isEmpty());

	}
}