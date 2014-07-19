/* 
 * Author: Hao Tan <ihntee@gmail.com>
 * Time: 2014/07/19
 * Problem Description: Sort a stack in ascending order (with biggest item on top)
 * Time: O(n^2)
 */
import java.util.Stack;

class Question {
    public static Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> stack2 = new Stack<Integer>();
        while (!stack.isEmpty()) {
            // assume objects on stack are integers
            int temp = stack.pop();
            // record numbers of pops
            int i = 0;
            while (!stack2.isEmpty() && temp < stack2.peek()) {
                stack.push(stack2.pop());
                i++;
            }
            // insert the temp value to stack2
            stack2.push(temp);
            // push the items back to stack2
            for (; i > 0; i--) {
                stack2.push(stack.pop());
            }
        }
        return stack2;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(2);
        s.push(1);
        s.push(5);
        s.push(4);
        s.push(8);
        s.push(8);
        s.push(9);
        Stack<Integer> s2 = sort(s);
        while (!s2.isEmpty())
            System.out.println(s2.pop());
    }
}