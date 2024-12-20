import java.util.*;

public class OueueUsingStacks {
    private final Stack<Integer> input;
  private final Stack<Integer> output;

  public OueueUsingStacks() {
    input = new Stack<>();
    output = new Stack<>();
  }

  public void push(int x) {
    input.push(x);
  }
  public int pop() {
    peek();
    return output.pop();
  }
  public int peek() {
    if (output.empty())
      while (!input.empty())
        output.push(input.pop());
    return output.peek();
  }
  public boolean empty() {
    return input.empty() && output.empty();
  }

  public static void main(String[] args) {
    OueueUsingStacks queue = new OueueUsingStacks();
    queue.push(1);
    queue.push(2);
    System.out.println(queue.peek());  // returns 1
    System.out.println(queue.pop());   // returns 1
    System.out.println(queue.empty()); // returns false
  }

}
